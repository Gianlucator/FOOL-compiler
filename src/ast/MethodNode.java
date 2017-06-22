package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * Created by crist on 22/06/2017.
 */
public class MethodNode implements Node {

    private String id;

    public MethodNode(String id) {
        this.id = id;
    }

    public String getId() { return id; }

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
        return null;
    }
}
