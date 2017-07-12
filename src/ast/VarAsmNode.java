package ast;

import java.util.ArrayList;
import java.util.HashMap;

import util.Environment;
import util.SemanticError;
import lib.FOOLlib;

public class VarAsmNode implements Node {

    private String id;
    private Node type;
    private Node exp;
    private STentry entry;

    public VarAsmNode(String i, Node t, Node v) {
        id = i;
        type = t;
        exp = v;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //create result list
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        //env.setOffset(-2);
        HashMap<String, STentry> hm = env.getSymTable().get(env.getNestingLevel());

        entry = new STentry(env.getNestingLevel(), type, env.getOffset()); //separo introducendo "entry"
        env.decOffset();

        if (hm.put(id, entry) != null)
            res.add(new SemanticError("Var id " + id + " already declared"));

        res.addAll(exp.checkSemantics(env));

        String classInstance = "";
        // Memorizzo nel method environment il tipo con cui istanzio l'oggetto.

        // se si sta facendo: NomeClasse nomeOggetto = new NomeClasse()
        // e quindi la exp è una newExpNode


        if (exp instanceof NewExpNode) {
            classInstance = ((NewExpNode) exp).getClassId();
            HashMap<String, String> ohm;
            ohm = env.getObjectEnvironment().get(env.getNestingLevel());
            ohm.put(id, classInstance);

        } else if (exp instanceof CallMetNode || exp instanceof CallFunNode) {
            // altrimenti se si assegna alla varabile il valore di ritorno di un metodo/funzione

            // si recupera l'arrowtype del metodo/funzione
            // per poter sapere il tipo del valore di ritorno del metodo/funzione
            ArrowTypeNode arrowType = null;

            if (exp instanceof CallMetNode) {  // metodo
                arrowType = ((CallMetNode) exp).getArrowType();
            } else if (exp instanceof CallFunNode) {  // funzione
                arrowType = ((CallFunNode) exp).getArrowType();
            }

            // tipo del valore di ritorno del metodo/funzione
            Node returnType = arrowType.getRet();

            // se il metodo/funzione ritorna un oggetto
            if (returnType instanceof ClassIdNode && FOOLlib.isSubtype(returnType,type)) {
                type = returnType;
                classInstance = ((ClassIdNode) type).getClassId();
                HashMap<String, String> ohm;
                ohm = env.getObjectEnvironment().get(env.getNestingLevel());
                ohm.put(id, classInstance);
            }

            if(!(type.toString()).equals(returnType.toString()))
                res.add(new SemanticError("Cannot assign type " + returnType + " value to variable declared as " + type));
        }


        return res;
    }

    public String toPrint(String s) {
        return s + "Var:" + id + "\n"
                + type.toPrint(s + "  ")
                + exp.toPrint(s + "  ");
    }

    //valore di ritorno non utilizzato
    public Node typeCheck() {
        if (exp.typeCheck() instanceof ClassIdNode && type instanceof ClassIdNode) {
            if (!FOOLlib.isSubtype(((ClassIdNode) exp.typeCheck()).getClassId(), ((ClassIdNode) type).getClassId()))
                FOOLlib.addTypeError("Incompatible class for object " + id);

            //Imposto il tipo dell'oggetto con il tipo con cui è stato istanziato
            //se è sottotipo del tipo con cui è stato dichiarato.
            entry.setType(exp.typeCheck());
        } else {
            if (!(FOOLlib.isSubtype(exp.typeCheck(), type)))
                FOOLlib.addTypeError("Incompatible value for variable " + id);
        }
        return null;
    }

    public String codeGeneration() {
        return exp.codeGeneration();
    }

}  