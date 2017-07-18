package ast;

import java.util.ArrayList;

import util.Environment;
import util.SemanticError;
import lib.FOOLlib;
import util.TypeError;


// chiamata di funzione
// vedi FunNode per dichiarazione di funzione
public class CallFunNode implements Node {

    private String id;
    private STentry entry;
    private ArrayList<Node> parlist;
    private int nestinglevel;

    public CallFunNode(String i, STentry e, ArrayList<Node> p, int nl) {
        id = i;
        entry = e;
        parlist = p;
        nestinglevel = nl;
    }

    public CallFunNode(String text, ArrayList<Node> args) {
        id = text;
        parlist = args;
    }

    public ArrowTypeNode getArrowType() {
        return ((ArrowTypeNode) entry.getType());
    }

    public String toPrint(String s) {  //
        String parlstr = "";
        for (Node par : parlist)
            parlstr += par.toPrint(s + "  ");
        return s + "Call:" + id + " at nestlev " + nestinglevel + "\n"
                + entry.toPrint(s + "  ")
                + parlstr;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //create the result
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        // Prende il nesting level
        int j = env.getNestingLevel();
        STentry tmp = null;
        // Controlla i nesting level partendo da j
        while (j >= 0 && tmp == null) {
            tmp = (env.getSymTable().get(j--)).get(id);
        }
        // Se NON ha trovato l'id lancia errore semantico
        if (tmp == null)
            res.add(new SemanticError("Function " + id + " not declared"));
        else {
            this.entry = tmp;
            this.nestinglevel = env.getNestingLevel();

            // Passa alla check-semantic degli argomenti
            for (Node arg : parlist)
                res.addAll(arg.checkSemantics(env));
        }
        return res;
    }

    public Node typeCheck() {  //
        ArrowTypeNode t = null;
        // Verifica se l'entry è effettivamente una funzione
        if (entry.getType() instanceof ArrowTypeNode)
            t = (ArrowTypeNode) entry.getType();
        else
            FOOLlib.addTypeError("Invocation of a non-function " + id);

        ArrayList<Node> p = t.getParList();
        // Controllo semantico dei parametri in input
        if (!(p.size() == parlist.size()))
            FOOLlib.addTypeError("Wrong number of parameters in the invocation of " + id);

        // Controllo controvarianza dei parametri
        for (int i = 0; i < parlist.size(); i++) {
            if (!(FOOLlib.isSubtype((parlist.get(i)).typeCheck(), p.get(i))))
                FOOLlib.addTypeError("Wrong type for " + (i + 1) + " parameter in the invocation of " + id);
        }

        return t.getRet();
    }

    public String codeGeneration() {
        String parCode = "";
        // Genera il codice dei parametri
        for (int i = parlist.size() - 1; i >= 0; i--)
            parCode += parlist.get(i).codeGeneration();
        // fa anche push

        String getAR = "";
        for (int i = 0; i < nestinglevel - entry.getNestinglevel(); i++)
            getAR += "lw\n"; // load a value from the memory cell pointed by top

        return "lfp\n" + // = push $fp, load frame pointer in the stack
                parCode +  // codice generato per i param
                "lfp\n" + getAR + //setto AL risalendo la catena statica
                // ora recupero l'indirizzo a cui saltare e lo metto sullo stack (?)
                "push " + entry.getOffset() + "\n" + //metto offset sullo stack
                "lfp\n" + getAR + //risalgo la catena statica
                // offset della funzione + ar(=activation record relativo al funzione)
                "add\n" +  // add two values from the stack e ne fa push
                "lw\n" + // load a value from the memory cell pointed by top of the stack
                //js: jump to instruction pointed by top of stack and store next instruction in ra
                "js\n";
    }
}  