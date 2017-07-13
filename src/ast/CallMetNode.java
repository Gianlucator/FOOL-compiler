package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * Created by crist on 08/06/2017.
 */
public class CallMetNode implements Node {
    // nome oggetto su cui è richiamato il metodo
    private String objectName;
    private String objectClass;

    // nome metodo
    private String methodName;

    // lista parametri passati al metodo
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
        // si prende l'arrowtype node del funNode del metodo
        ArrowTypeNode t = methodNode.getArrowType();

        // lista parametri con cui è stato dichiarato
        ArrayList<Node> p = t.getParList();

        // se il numero di parametri con cui il metodo è stato invocato è diverso dal numero con cui è stato dichiarato
        if (!(p.size() == (parlist.size() - 1))) {
            // si lancia errore semantico
            FOOLlib.addTypeError("Wrong number of parameters in the invocation of " + methodName);
        } else {
            // altrimenti si controlla se i parametri attuali sono dello stesso tipo
            // o di sottotipo di quelli con cui è stato dichiarato
            for (int i = 1; i < parlist.size(); i++) {
                if (!(FOOLlib.isSubtype((parlist.get(i)).typeCheck(), p.get(i - 1))))
                    FOOLlib.addTypeError("Wrong type for " + i + " parameter in the invocation of " + methodName);
            }
        }

        // il typecheck della chiamata di metodo ritorna il tipo di ritorno del metodo
        return t.getRet();
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        // lista di errori semantici
        ArrayList<SemanticError> res = new ArrayList<>();

        int j = env.getNestingLevel();  // 1
        //tring classId = null;
        boolean foundMethod = false;

        // se: this.nomeMetodo(..)
        if (objectName.equals("this"))
            // ci si trova all'interno della dichiarazione di una classe
            objectClass = env.getClassEnvironment();
        else {
            // si cerca la dichiarazione dell'oggetto su cui si sta chiamando il metodo
            while (j >= 0 && objectClass == null) {
                objectClass = env.getObjectEnvironment().get(j--).get(objectName);
            }
        }

        // se l'oggetto non viene trovato
        if (objectClass == null) {
            // si lancia errore semantico
            res.add(new SemanticError("Object " + objectName + " not declared"));
        } else {
            // se l'oggetto viene trovato bisogna controllare se il metodo è stato dichiarato
            // dobbiamo essere sicuri che il metodo esista ==> o nella classe o in una superclasse
            String classToSearch = objectClass;

            while (!classToSearch.equals("") && !foundMethod) {
                ClassNode objectClass = env.getClassLayout(classToSearch);
                methodNode = (FunNode) objectClass.getMethod(methodName);
                foundMethod = (methodNode != null);

                classToSearch = objectClass.getSuperclass();
            }
        }

        // se non viene trovato il metodo nella classe e nelle superclassi
        if (!foundMethod) {
            res.add(new SemanticError("Method " + methodName + " not declared in class " + objectClass));
        } else {
            // se invece viene trovato il metodo si fa il controllo semantico sui parametri passati al metodo
            for (Node arg : parlist)
                res.addAll(arg.checkSemantics(env));

            // si aggiunge ai parametri il self
            // c'è gia, in classnode gli diamo un classidnode ma ora lo si sostituisce con un parNode
            parlist.add(0, new ParNode(objectName, new ClassIdNode(objectClass)));
        }

        // create object ID node
        objectEntry = new IdNode(objectName);
        res.addAll(objectEntry.checkSemantics(env));

        return res;
    }

    @Override
    public String codeGeneration() {
        String loadObject = (objectName.equals("this") ? "" : objectEntry.codeGeneration() + "sop\n");

        String parCode = "";
        for (int i = parlist.size() - 1; i >= 0; i--)
            parCode += parlist.get(i).codeGeneration();

        return  loadObject +
                "lfp\n" +
                parCode +
                "lfp\n" +
                "push " + methodNode.getMethodOffset() + "\n" +
                "smo\n" +
                "lop\n" +
                "push -2\n" +
                "add\n" +
                "lw\n" +
                "js\n";
    }
}
