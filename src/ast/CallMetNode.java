package ast;

import lib.FOOLlib;
import util.DispatchTable;
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
        String classId = "";
        boolean foundMethod = true;

        // dichiarazione di oggetto
        if (env.getObjectEnvironment().size() > j) {
            while (j >= 0 && classId.equals("")) {
                // TODO: Il try/catch credo si possa eliminare ora.
                try {
                    // Ottengo la classe più vicina al nl attuale, con cui è stato istanziato l'oggetto.
                    classId = env.getObjectEnvironment().get(j--).get(objectName);
                } catch (Exception e) {
                }
            }
        }

        if (classId.equals("")) {
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

        return  parCode +
                objectEntry.codeGeneration() +
                "shp\n" +
                "push " + mLabel + "\n" +
                "lw\n" +
                "js\n";

        /*// 1. generate code for evaluating each parameter fi
        String parCode = "";
        for (int i = parlist.size() - 1; i >= 0; i--)
            parCode += parlist.get(i).codeGeneration();
        *//* 2. generate code for pushing value of fi on stack. Note: you should generate code for evaluating and pushing the
              parameters on stack in such a way that fn is pushed first, and f1 last. *//*

        // 3. generate code for pushing value of x on stack.

        // 4. generate code for jumping to the assembly routine generated for p

        String getAR = "";
        //for (int i = 0; i < smth ; i++) //devo risalire allo scope della classe in cui è stato dichiarato il metodo.
            getAR += "lw\n";

        return "lfp\n" + //CL
                parCode +
                "lfp\n" + getAR + //setto AL risalendo la catena statica
                // ora recupero l'indirizzo a cui saltare e lo metto sullo stack
                //"push " + entry.getOffset() + "\n" + //metto offset sullo stack
                "lfp\n" + getAR + //risalgo la catena statica
                "add\n" +
                "lw\n" + //carico sullo stack il valore all'indirizzo ottenuto
                "js\n";*/
    }
}
