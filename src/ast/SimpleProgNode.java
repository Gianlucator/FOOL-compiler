package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * Created by Stefano on 14/06/2017.
 */
public class SimpleProgNode implements Node{

    Node simpleprog;

    public SimpleProgNode(Node simpleprog) {
        this.simpleprog = simpleprog;
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

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //declare resulting list
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        res.addAll(simpleprog.checkSemantics(env));

        return res;
    }
}
