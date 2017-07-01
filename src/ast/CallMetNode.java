package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * Created by crist on 08/06/2017.
 */
public class CallMetNode implements Node {
    private String objectName;
    private String methodName;
    private ArrayList<Node> args;

    // chiamata di un metodo di una classe
    public CallMetNode(String objectName, String methodName, ArrayList<Node> args) {
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

        int j = env.getNestingLevel();
        STentry tmp = null;
        boolean foundMethod = false;
        ClassIdNode classId = new ClassIdNode("");
        ClassNode classNode = null;

        // dichiarazione di oggetto
        while (j >= 0 && classId.getClassId().equals("")) {
            try{    //Provo a castare le entry nella symtable con lo stesso nome a classId
                classId = (ClassIdNode) (env.getSymTable().get(j--)).get(objectName).getType();
            }catch (Exception e){
                System.out.println("Could not cast object type to ClassIdNode.\n");
            }
            if (classId.getClassId().equals(""))
                res.add(new SemanticError("Object " + objectName + " not declared"));
            else {
                classNode = env.getClassLayout(classId.getClassId());

                ArrayList<Node> methods = classNode.getMethods();
                for (Node decs : methods) {
                    if (((FunNode) decs).getId().equals(methodName)) {
                        foundMethod = true;
                    }
                }
            }
        }
        if (!foundMethod) {
            res.add(new SemanticError("Method " + methodName + " not declared"));
        } else {
            System.out.println(classNode.toPrint(""));
        }


        /*
        while (j >= 0 && tmp == null)
            tmp = (env.symTable.get(j--)).get(methodName);
        if (tmp == null)
            res.add(new SemanticError("Id " + methodName + " not declared"));

        else {
            this.entry = tmp;
            this.nestinglevel = env.nestingLevel;

            for (Node arg : args)
                res.addAll(arg.checkSemantics(env));

        if (tmp == null)
            res.add(new SemanticError("Id " + objectName + " not declared"));
        }
        */
        return res;
    }
}
