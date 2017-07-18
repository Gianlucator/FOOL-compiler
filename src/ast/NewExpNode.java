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

            // Controllo controvarianza valori campi
            if (!FOOLlib.isSubtype(arg, varNodeType))
                FOOLlib.addTypeError("Incompatible parameter at position " + i + " during instantiation of class " + classId);
        }

        return new ClassIdNode(classId);
    }

    @Override
    public String codeGeneration() {
        int hpCounter = 0;
        String code = "";

        // Generazione del codice degli argomenti del costruttore
        for (int i = args.size() - 1; i >= 0; i--) {
            if (args.get(i) instanceof NewExpNode)
                code += args.get(i).codeGeneration() + saveToHP(hpCounter);
            // salvo il valore della new proprio in hpCounter
            hpCounter++;
        }

        hpCounter = 0;
        for (int i = args.size() - 1; i >= 0; i--) {
            if (!(args.get(i) instanceof NewExpNode))
                code += args.get(i).codeGeneration() + saveToHP(hpCounter);
            // salvo il valore della variabile proprio in hpCounter
            hpCounter++;
        }

        // Pusha il nome della classe
        code += "push " + classId + "\n" + saveToHP(hpCounter);
        hpCounter++;

        // salviamo la dimensione arg.size() + 2
        int size = args.size() + 2;
        code += "push " + size + "\n" + saveToHP(hpCounter);

        // aggiorniamo l'indirizzo iniziale dell'oggetto sommando i campi che abbiamo aggiunto
        // alla fine il risultato che rimane sullo stack e' l'indirizzo finale dell'oggetto
        code += "lhp\n" +                   // Caricamento heap pointer
                "push " + size + "\n" +     // Push della dimensione dell'oggetto
                "add\n" +
                "shp\n" +
                "lhp\n";

        return code;
    }

    // dato un indirizzo, ritorna la stringa che permette di salvare un valore in un certo indirizzo a partire dall'hp
    private String saveToHP(int indexToSaveTo) {
        return  "lhp\n" +
                "push " + indexToSaveTo + "\n" +
                "add\n" +
                "sw\n";
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
