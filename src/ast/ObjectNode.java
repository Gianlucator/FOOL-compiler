package ast;

import util.DispatchTable;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * Created by crist on 22/06/2017.
 */
public class ObjectNode implements Node {
    private String tag;
    private int size;
    private DispatchTable dt;
    private ArrayList<Node> fields;

    public ObjectNode(String tag, Environment env) {
        this.tag = tag;
        this.size = 3 + fields.size();
        this.dt = env.dispatchTables.get(tag);
        this.fields = ((ClassNode) env.symTable.get(0).get(tag).getType()).getFields();
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
