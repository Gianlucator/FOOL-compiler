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
        if (exp instanceof NewExpNode) {
            classInstance = ((NewExpNode) exp).getClassId();
        } else if (exp instanceof CallMetNode || exp instanceof CallFunNode) {
            ArrowTypeNode arrowType = null;

            if (exp instanceof CallMetNode) {
                arrowType = ((CallMetNode) exp).getArrowType();
            } else if (exp instanceof CallFunNode) {
                arrowType = ((CallFunNode) exp).getArrowType();
            }

            type = arrowType.getRet();
            classInstance = ((ClassIdNode) type).getClassId();
        }

        HashMap<String, String> ohm;
        ohm = env.getObjectEnvironment().get(env.getNestingLevel());
        ohm.put(id, classInstance);

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