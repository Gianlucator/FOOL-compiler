package ast;

import util.Environment;
import util.SemanticError;
import java.util.ArrayList;

/**
 * Created by Stefano on 11/06/2017.
 */
public class LetNode implements Node {

    private ArrayList<Node> decList;

    public LetNode(ArrayList<Node> decList) {
        this.decList = decList;
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
        return null;
    }
}
