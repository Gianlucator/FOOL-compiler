package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

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

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<>();
    }
}