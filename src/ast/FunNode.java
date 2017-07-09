package ast;

import java.util.ArrayList;
import java.util.HashMap;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;
import util.TypeError;

// dichiarazione di funzione
// vedi CallFunNode per chiamata di funzione
public class FunNode implements Node {

    private String id;
    private Node type;
    private ArrayList<Node> parlist = new ArrayList<>();
    private ArrayList<Node> declist;
    private Node body;
    private ArrowTypeNode arrowType;

    //Se rimane null è una funzione, altrimenti indica la classe di appartenenza del metodo
    private Node self = null;

    public Node getSelf() {
        return self;
    }

    public void setSelf(Node self) {
        this.self = self;
    }

    public FunNode(String i, Node t) {
        id = i;
        type = t;
    }

    public void addDecBody(ArrayList<Node> d, Node b) {
        declist = d;
        body = b;
    }

    public String getId() {
        return id;
    }

    public ArrowTypeNode getArrowType() {
        return arrowType;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        //create result list
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        //env.offset = -2;
        // mh = Symbol table = lista di hashmap
        HashMap<String, STentry> hm = env.getSymTable().get(env.getNestingLevel());
        HashMap<String, String> ohm = env.addObjectEnvHMtoNL();

        STentry entry = new STentry(env.getNestingLevel(), env.getOffset()); //separo introducendo "entry"
        env.decOffset();

        // se la st contiene già l'id ==> error
        if (hm.put(id, entry) != null && self == null) {
            res.add(new SemanticError("Fun id " + id + " already declared"));
        } else {
            // se la st non contiene ancora l'id ==> lo si aggiunge e
            // si crea una nuova hashmap per la symTable

            // nuovo livello innestato
            env.incNestingLevel();

            // hashmap nested
            HashMap<String, STentry> hmn = env.addSymTableHMtoNL();

            // aggiunto alla symbol table
            env.getSymTable().add(hmn);

            ArrayList<Node> parTypes = new ArrayList<Node>();
            int paroffset = 1;

            //check args
            for (Node a : parlist) {
                ParNode arg = (ParNode) a;
                parTypes.add(arg.getType());
                if ( arg.getType() instanceof ClassIdNode) {
                    ohm.put(arg.getId(), ((ClassIdNode) arg.getType()).getClassId());
                }
                hmn.put(arg.getId(), new STentry(env.getNestingLevel(), arg.getType(), paroffset++));
            }

            //set func type
            if (self == null)
                entry.addType(new ArrowTypeNode(parTypes, type));
            else
                arrowType = new ArrowTypeNode(parTypes, type);

            //check semantics in the dec list
            if (declist.size() > 0) {
                env.setOffset(-2);
                //if there are children then check semantics for every child and save the results
                for (Node n : declist) {
                    res.addAll(n.checkSemantics(env));
                }
            }

            // add self class as first parameter
            if (self != null)
                parlist.add(0, new ParNode("self", self));

            //check body
            res.addAll(body.checkSemantics(env));

            // change returned type into type returned by body.
            try {
                if ((FOOLlib.isSubtype(body.typeCheck(), type))){
                    if (self == null)
                        entry.setType(new ArrowTypeNode(parTypes, body.typeCheck()));
                    else
                        arrowType.setRet(body.typeCheck());
                }
            } catch (Exception e) {}


            //close scope

            env.getSymTable().remove(env.getNestingLevel());
            env.getObjectEnvironment().remove(env.getNestingLevel());
            env.decNestingLevel();
        }
        return res;
    }

    public void addPar(Node p) {
        parlist.add(p);
    }

    public String toPrint(String s) {
        String parlstr = "";
        for (Node par : parlist)
            parlstr += par.toPrint(s + "  ");
        String declstr = "";
        if (declist != null)
            for (Node dec : declist)
                declstr += dec.toPrint(s + "  ");
        return s + "Fun:" + id + "\n"
                + type.toPrint(s + "  ")
                + parlstr
                + declstr
                + body.toPrint(s + "  ");
    }

    //valore di ritorno non utilizzato
    // controlla se il tipo del valore di ritorno coincide con il tipo del valore
    // ritornato dalla funzione
    public Node typeCheck() {
        if (declist != null)
            for (Node dec : declist)
                dec.typeCheck();

        if (!(FOOLlib.isSubtype(body.typeCheck(), type))) {
            FOOLlib.addTypeError("Wrong return type for function " + id);
        }
        return null;
    }

    public String codeGeneration() {
//che altro dovrebbe mancare?
        String declCode = "", popDecl = "";
        if (declist != null) {
            for (Node dec : declist) {
                declCode += dec.codeGeneration();
                popDecl += "pop\n";
            }
        }

        String popParl = "";
        int parSize = (self == null) ? parlist.size() : parlist.size() - 1;
        for (int i = 0; i < parSize; i++) {
            Node dec = parlist.get(i);
            popParl += "pop\n";
        }

        String funl;
        if (self == null)
            funl = FOOLlib.freshFunLabel();
        else
            funl = FOOLlib.getMethodLabel(((ClassIdNode) self).getClassId(), id);

        FOOLlib.putCode(funl + ":\n" +
                "cfp\n" + //setta $fp a $sp
                "lra\n" + //inserimento return address
                declCode + //inserimento dichiarazioni locali
                body.codeGeneration() +
                "srv\n" + //pop del return value and store top into rv (var che contiene il risultato della funz)
                popDecl +
                "sra\n" + // pop del return address e store top (= Access Link) into $ra
                "pop\n" + // pop di Access Link
                // AL= points to the activation record associated with the nearest enclosing scope
                // per il body della funzione AL è il blocco che contiene la dichiarazione della funzione
                popParl +
                // Control Link (o Dynamic Link) = %fp precedente settato dal chiamante
                "sfp\n" +  // setto $fp a valore del Control Link  -  store top into frame pointer
                "lrv\n" + // risultato della funzione (=rv) on top dello stack - load from rv
                "lra\n" + "js\n" //load from ra e salta a $ra
        );

        if (self == null)
            return "push " + funl + "\n";
        else return "";
    }

}  