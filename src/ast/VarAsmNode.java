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

    public VarAsmNode(String i, Node t, Node v) {
        id = i;
        type = t;
        exp = v;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //create result list
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        /*  Instant kill omfg this sucks
        //Controllo per vedere se ho istanziato bene l'oggetto, così da memorizzarlo con il tipo di istanziazione
        if (exp.typeCheck() instanceof ClassIdNode && type instanceof ClassIdNode) {
            if (FOOLlib.isSubtype(((ClassIdNode) exp.typeCheck()).getClassId(), ((ClassIdNode) type).getClassId())) {
                type = (ClassIdNode) exp.typeCheck();
            } else {
                res.add(new SemanticError("Incompatible class type for object: " + id + "\n"));
            }
        }
        */

        //env.setOffset(-2);
        HashMap<String, STentry> hm = env.getSymTable().get(env.getNestingLevel());
        env.decOffset();
        STentry entry = new STentry(env.getNestingLevel(), type, env.getOffset()); //separo introducendo "entry"

        if (hm.put(id, entry) != null)
            res.add(new SemanticError("Var id " + id + " already declared"));

        res.addAll(exp.checkSemantics(env));

        return res;
    }

    public String toPrint(String s) {
        return s + "Var:" + id + "\n"
                + type.toPrint(s + "  ")
                + exp.toPrint(s + "  ");
    }

    //valore di ritorno non utilizzato
    public Node typeCheck() {
        if (!(FOOLlib.isSubtype(exp.typeCheck(), type))) {
            System.out.println("incompatible value for variable " + id);
            System.exit(0);
        }
        return null;
    }

    public String codeGeneration() {
        return exp.codeGeneration();
    }

}  