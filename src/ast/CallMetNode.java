package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;
import util.TypeError;

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

    public ArrowTypeNode getArrowType() {
        return methodNode.getArrowType();
    }

    @Override
    public String toPrint(String indent) {
        return null;
    }

    @Override
    public Node typeCheck() {
        ArrowTypeNode t = methodNode.getArrowType();
        ArrayList<Node> p = t.getParList();

        if (!(p.size() == (parlist.size() - 1)))
            FOOLlib.addTypeError("Wrong number of parameters in the invocation of " + methodName);

        for (int i = 1; i < parlist.size(); i++) {
            if (!(FOOLlib.isSubtype((parlist.get(i)).typeCheck(), p.get(i - 1))))
                FOOLlib.addTypeError("Wrong type for " + i + " parameter in the invocation of " + methodName);
        }
        return t.getRet();
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();

        int j = env.getNestingLevel();
        String classId = null;
        boolean foundMethod = false;

        if (objectName.equals("this"))
            classId = env.getClassEnvironment();
        else {
            // dichiarazione di oggetto
            while (j >= 0 && classId == null) {
                classId = env.getObjectEnvironment().get(j--).get(objectName);
            }
        }

        if (classId == null) {
            res.add(new SemanticError("Object " + objectName + " not declared"));
        } else {
            // dobbiamo essere sicuri che il metodo esista ==> o nella classe o in una super
            String classToSearch = classId;

            while (!classToSearch.equals("") && !foundMethod) {
                ClassNode objectClass = env.getClassLayout(classToSearch);
                methodNode = (FunNode) objectClass.getMethod(methodName);
                foundMethod = (methodNode != null);

                classToSearch = objectClass.getSuperclass();
            }
        }

        if (!foundMethod) {
            res.add(new SemanticError("Method " + methodName + " not declared in class " + classId));
        } else {
            // controllo semantico sui parametri passati al metodo
            for (Node arg : parlist)
                res.addAll(arg.checkSemantics(env));

            // si aggiunge ai parametri il self
            parlist.add(0, new ParNode(objectName, new ClassIdNode(classId)));
            env.thisEnvironment = objectName;
        }

        //create object ID node
        objectEntry = new IdNode(objectName);
        res.addAll(objectEntry.checkSemantics(env));

        return res;
    }

    @Override
    public String codeGeneration() {

        //TODO: trovare label univoca per metodo di una classe
        String selfName = ((ClassIdNode) methodNode.getSelf()).getClassId(),
               mLabel = FOOLlib.getMethodLabel(selfName, methodName),
               loadObject = (objectName.equals("this") ? "" : objectEntry.codeGeneration() + "sop\n");

        String parCode = "";
        for (int i = parlist.size() - 1; i >= 0; i--)
            parCode += parlist.get(i).codeGeneration();

        return  loadObject +
                "lfp\n" +
                parCode +
                "lfp\n" +
                "push " + mLabel + "\n" +
                "js\n";
    }
}
