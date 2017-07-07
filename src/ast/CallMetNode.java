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
    private IdNode objectEntry;

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
        ArrowTypeNode t = methodNode.getArrowType();
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
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();

        int j = env.getNestingLevel();
        String classId = null;
        boolean foundMethod = true;

        // dichiarazione di oggetto
        while (j >= 0 && classId == null) {
            try { // Ottengo la classe più vicina al nl attuale, con cui è stato istanziato l'oggetto.
                classId = env.getObjectEnvironment().get(j--).get(objectName);
            } catch (Exception e) { // do nothing

            }
        }

        if (classId == null) {
            res.add(new SemanticError("Object " + objectName + " not declared"));
        } else {
            // dobbiamo essere sicuri che il metodo esista
            ClassNode objectClass = env.getClassLayout(classId);
            methodNode = (FunNode) objectClass.getMethod(methodName);
            foundMethod = (methodNode != null);
        }

        if (!foundMethod) {
            res.add(new SemanticError("Method " + methodName + " not declared in class " + classId));
        } else {
            // controllo semantico sui parametri passati al metodo
            for (Node arg : parlist)
                res.addAll(arg.checkSemantics(env));

            // si aggiunge ai parametri il self
            parlist.add(0, new ParNode(objectName, new ClassIdNode(classId)));
        }

        //create object ID node
        objectEntry = new IdNode(objectName);
        res.addAll(objectEntry.checkSemantics(env));

        return res;
    }

    @Override
    public String codeGeneration() {

        String selfName = ((ClassIdNode) methodNode.getSelf()).getClassId();
        String mLabel = methodName + selfName;

        String parCode = "";
        for (int i = parlist.size() - 1; i >= 0; i--)
            parCode += parlist.get(i).codeGeneration();

        return  objectEntry.codeGeneration() +
                "sop\n" +
                "lfp\n" +
                parCode +
                "lfp\n" +
                "push " + mLabel + "\n" +
                "js\n";
    }
}
