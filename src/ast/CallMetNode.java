package ast;

import util.Environment;
import util.SemanticError;

import javax.swing.plaf.synth.SynthTextAreaUI;
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
        String classId = "";
        ClassNode classNode = null;

        // dichiarazione di oggetto
        while (j >= 0 && classId.equals("")) {
            try{    // Ottengo la classe più vicina al nl attuale, con cui è stato istanziato l'oggetto.
                classId = env.getMethodEnvironment().get(j--).get(objectName);
            }catch (Exception e){
                //Questa stampa sarà eliminata in futuro
                System.out.print("Class instantiation for object '" + objectName + "' not found at nesting level " + (j+1) + "\n");
            }
        }
        if (classId.equals("")) {
            res.add(new SemanticError("Object " + objectName + " not declared"));
        }
        else {
        classNode = env.getClassLayout(classId);

        ArrayList<Node> methods = classNode.getMethods();
        for (Node method : methods) {
            if(method instanceof FunNode)
                if (((FunNode) method).getId().equals(methodName))
                    foundMethod = true;
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
