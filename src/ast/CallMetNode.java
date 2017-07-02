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
    private ArrayList<Node> parlist;

    // chiamata del metodo di una classe
    public CallMetNode(String objectName, String methodName, ArrayList<Node> parlist) {
        this.objectName = objectName;
        this.methodName = methodName;
        this.parlist = parlist;
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
        boolean foundMethod = false;
        String classId = "";
        ClassNode classNode = null;

        // dichiarazione di oggetto
        while (j >= 0 && classId.equals("")) {
            try{ // Ottengo la classe più vicina al nl attuale, con cui è stato istanziato l'oggetto.
                classId = env.getObjectEnvironment().get(j--).get(objectName);
            }catch (Exception e){
                //Questa stampa sarà eliminata in futuro
                System.out.print("Class instantiation for object '" + objectName + "' not found at nesting level " + (j+1) + "\n");
            }
        }
        if (classId.equals("")) {
            res.add(new SemanticError("Object " + objectName + " not declared"));
        } else {
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
            // controllo semantico sui parametri passati al metodo
            for (Node arg : parlist)
                res.addAll(arg.checkSemantics(env));
            // si aggiunge ai parametri il self
            parlist.add(0, new ParNode(objectName, new ClassIdNode(classId)));
        }
        return res;
    }
}
