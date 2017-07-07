package ast;

import java.util.ArrayList;

import util.Environment;
import util.SemanticError;
import lib.FOOLlib;


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

        int j = env.getNestingLevel();
        STentry tmp = null;
        while (j >= 0 && tmp == null) {
            tmp = (env.getSymTable().get(j--)).get(id);
        }
        if (tmp == null)
            res.add(new SemanticError("Function " + id + " not declared"));
        else {
            this.entry = tmp;
            this.nestinglevel = env.getNestingLevel();

            for (Node arg : parlist)
                res.addAll(arg.checkSemantics(env));
        }
        return res;
    }

    public Node typeCheck() {  //
        ArrowTypeNode t = null;
        if (entry.getType() instanceof ArrowTypeNode)
            t = (ArrowTypeNode) entry.getType();
        else {
            System.out.println("Invocation of a non-function " + id);
            System.err.println("Fatal error during type checking");
        }
        ArrayList<Node> p = t.getParList();
        if (!(p.size() == parlist.size())) {
            System.out.println("Wrong number of parameters in the invocation of " + id);
            System.err.println("Fatal error during type checking");
        }
        for (int i = 0; i < parlist.size(); i++)
            if (!(FOOLlib.isSubtype((parlist.get(i)).typeCheck(), p.get(i)))) {
                System.out.println("Wrong type for " + (i + 1) + " parameter in the invocation of " + id);
                System.err.println("Fatal error during type checking");
            }
        return t.getRet();
    }

    public String codeGeneration() {
        String parCode = "";
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