package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * Created by Stefano on 30/06/2017.
 */
public class ClassIdNode implements Node{

    private String classId;

    public ClassIdNode(String classId) {
        this.classId = classId;
    }


    public String getClassId() {
        return classId;
    }

    @Override
    public String toPrint(String s) {
        return s+"Class Type: " + classId +"\n";
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

        if (env.getClassLayout(classId) == null)
            res.add(new SemanticError("Class " + classId + " not declared"));

        return res;
    }

    @Override
    public String toString() {
        return classId;
    }
}
