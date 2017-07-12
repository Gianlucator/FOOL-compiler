package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * Created by crist on 14/06/2017.
 */
public class NewExpNode implements Node {
    private String classId; // nome oggetto
    private ArrayList<Node> args;  // argomenti passati al costruttore
    private ClassNode classEntry;  // classe di cui è istanza

    public NewExpNode(String classId, ArrayList<Node> args) {
        this.classId = classId;
        this.args = args;
    }

    public String getClassId() {
        return classId;
    }

    @Override
    public String toPrint(String indent) {
        return "";
    }

    @Override
    public Node typeCheck() {
        for (int i = 0; i < classEntry.getFields().size(); i++){
            Node arg = args.get(i).typeCheck();
            Node varNodeType = ((VarDecNode) classEntry.getFields().get(i)).getType();

            if (!FOOLlib.isSubtype(arg, varNodeType))
                FOOLlib.addTypeError("Incompatible parameter at position " + i + " during instantiation of class " + classId);
        }

        return new ClassIdNode(classId);
    }

    @Override
    public String codeGeneration() {
        String code = "";
        String saveToHPThenIncHP =  "lhp\n" +
                                    "sw\n"  +       //store all'indirizzo del hp il valore pushato precedentemente //fa 2 pop
                                    "push 1\n" +
                                    "lhp\n" +
                                    "add\n" +       //vado all'indirizzo successivo
                                    "shp\n";        //modifico l'hp //fa già la pop

        for (int i = args.size() - 1; i >= 0; i--)
            code += args.get(i).codeGeneration() + saveToHPThenIncHP;

        // salviamo la dimensione arg.size() + 1
        int size = args.size() + 1;
        code += "push " + size + "\n" + saveToHPThenIncHP;

        // salviamo indirizzo iniziale dell'oggetto = top heap sullo stack
        code += "lhp\n";

        return code;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        // lista di errori semantici
        ArrayList<SemanticError> res = new ArrayList<>();

        // controllare che la classe (di cui è istanza) esista
        // si cerca a nl 0 nella st
        classEntry = env.getClassLayout(classId);

        // se non è stata dichiarata la classe con cui viene istanziato l'oggetto
        if (classEntry == null)
            // si lancia un errore semantico
            res.add(new SemanticError("Class " + classId + " not declared."));
        else {
            // se invece, correttamente, è stata dichiarata la classe di cui l' oggetto è istanza

            // controllare che il costruttore sia chiamato col corretto numero di argomenti
            // cioè che sia passato al costruttore il corretto NUMERO di argomenti
            int constructorArguments = classEntry.getFields().size();

            // se il numero si argomenti che il costruttore accetta è diverso dal numero
            // di argomenti attualmente passati
            if (constructorArguments != args.size()) {
                // si lancia errore semantico
                String fewOrMany = (constructorArguments > args.size()) ? "few" : "many";
                res.add(new SemanticError(String.format("Too %s arguments arguments for %s constructor. Need %d, %d given.",
                        fewOrMany, classId, constructorArguments, args.size())));
            }
        }

        // si ciclano gli argomenti e si chiama ricorsivamente la check semantics su di essi
        for (Node arg : args)
            res.addAll(arg.checkSemantics(env));

        return res;
    }
}
