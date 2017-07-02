package ast;

import lib.FOOLlib;
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
    private FunNode methodNode;

    // chiamata del metodo di una classe
    public CallMetNode(String objectName, String methodName, ArrayList<Node> parlist) {
        this.objectName = objectName;
        this.methodName = methodName;
        methodNode = null;
        this.parlist = parlist;
    }

    @Override
    public String toPrint(String indent) {
        return null;
    }

    @Override
    public Node typeCheck() {
        ArrowTypeNode t = (ArrowTypeNode) methodNode.getArrowType();
        ArrayList<Node> p = t.getParList();

        if (!(p.size() == (parlist.size() - 1))) {
            System.out.println("Wrong number of parameters in the invocation of " + methodName);
            System.exit(0);
        }

        for (int i = 1; i < parlist.size(); i++) {
            if (!(FOOLlib.isSubtype((parlist.get(i)).typeCheck(), p.get(i - 1)))) {
                System.out.println("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + methodName);
                System.exit(0);
            }
        }
        return t.getRet();
    }

    @Override
    public String codeGeneration() {
        return null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();

        int j = env.getNestingLevel();
        String classId = "";
        boolean foundMethod = false;

        // dichiarazione di oggetto
        while (j >= 0 && classId.equals("")) {
            try { // Ottengo la classe più vicina al nl attuale, con cui è stato istanziato l'oggetto.
                classId = env.getObjectEnvironment().get(j--).get(objectName);
            } catch (Exception e) {
                //Questa stampa sarà eliminata in futuro
                System.out.print("Class instantiation for object '" + objectName + "' not found at nesting level " + (j + 1) + "\n");
            }
        }

        if (classId.equals("")) {
            res.add(new SemanticError("Object " + objectName + " not declared"));
        } else {
            ClassNode objectClass = env.getClassLayout(classId);

            ArrayList<Node> methods = objectClass.getMethods();
            for (Node method : methods) {
                if (method instanceof FunNode) {
                    if (((FunNode) method).getId().equals(methodName)) {
                        methodNode = (FunNode) method;
                        foundMethod = true;
                    }
                }
            }
        }

        if (!foundMethod) {
            res.add(new SemanticError("Method " + methodName + " not declared"));
        } else {
            // controllo semantico sui parametri passati al metodo
            for (Node arg : parlist) {
                res.addAll(arg.checkSemantics(env));
            }
            // si aggiunge ai parametri il self
            parlist.add(0, new ParNode(objectName, new ClassIdNode(classId)));
        }
        return res;
    }
}
