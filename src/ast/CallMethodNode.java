package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * Created by crist on 08/06/2017.
 */
public class CallMethodNode implements Node {
    private String objectName;
    private String methodName;
    private ArrayList<Node> args;

    public CallMethodNode(String objectName, String methodName, ArrayList<Node> args) {
        this.objectName = objectName;
        this.methodName = methodName;
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
        ArrayList<SemanticError> res = new ArrayList<>();

        int j = env.nestingLevel;
        STentry tmp = null;

        if (objectName.equals("this")) {
            for (String key : env.symTable.get(0).keySet()) {
                if (env.symTable.get(0).get(key).getType() instanceof ClassNode) {
                    ((ClassNode) env.symTable.get(0).get(key).getType())
                }
            }
        } else {
            while (j >= 0 && tmp == null){
                tmp = (env.symTable.get(j--)).get(objectName);
            }
        }

        if (tmp == null)
            res.add(new SemanticError("Id " + objectName + " not declared"));


        return null;
    }
}
