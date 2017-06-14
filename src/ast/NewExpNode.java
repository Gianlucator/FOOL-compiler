package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by crist on 14/06/2017.
 */
public class NewExpNode implements Node {
    private String id;
    private ArrayList<Node> args;

    public NewExpNode(String id, ArrayList<Node> args) {
        this.id = id;
        this.args = args;
    }

    @Override
    public String toPrint(String indent) {
        return null;
    }

    @Override
    public Node typeCheck() {
        return null;
    }

    @Override
    public String codeGeneration() {
        return null;
    }

    // sistemare, manca:
    // - mismatch parametri ==> stesso numero (tipo si controlla dopo)
    // - ???
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        HashMap<String,STentry> hm = new HashMap<String,STentry> ();
        //env.symTable.add(hm);

        //declare resulting list
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        if ((env.symTable.get(0)).get(id) == null)
            res.add(new SemanticError("Class " + id + " not declared"));

        for (Node arg : args)
            res.addAll(arg.checkSemantics(env));

        //hm.get(0)

        return res;
    }
}
