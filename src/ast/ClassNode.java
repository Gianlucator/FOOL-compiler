package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;
import util.TypeError;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Stefano on 06/06/2017.
 */
public class ClassNode implements Node {

    private String id;  // nome della classe
    private String superclass;  // nome della superclasse della classe
    private ArrayList<Node> fields;
    private ArrayList<Node> methods;
    private ClassNode superClassLayout;  // nodo che si riferisce alla superclasse della classe

    public ClassNode(String id, String superclass, ArrayList<Node> fields, ArrayList<Node> methods) {
        this.id = id;
        this.superclass = superclass;
        this.fields = fields;
        this.methods = methods;
    }

    @Override
    public String toPrint(String s) {
        return s + "class: " + id + "\n";
    }

    @Override
    public Node typeCheck() {
        if (superClassLayout != null) {
            ArrayList<Node> superFields = superClassLayout.getFields();
            //Override Fields
            Node newField, oldField,
                 newType, oldType;

            for (int i = 0; i < superFields.size(); i++) {
                newField = fields.get(i);
                oldField = superFields.get(i);

                newType = ((VarDecNode) newField).getType();
                oldType = ((VarDecNode) oldField).getType();

                if (!FOOLlib.isSubtype(newType, oldType)) {
                    FOOLlib.addTypeError(String.format("Field %s of type %s cannot override the old field of type %s.",
                            ((VarDecNode) newField).getId(), newType, oldType));
                }
            }

            ArrayList<Node> superMethods = superClassLayout.getMethods();

            for (int i = 0; i < superMethods.size(); i++) {
                ArrayList<Node> oldPar = ((FunNode) superMethods.get(i)).getArrowType().getParList();
                ArrayList<Node> newPar = ((FunNode) methods.get(i)).getArrowType().getParList();

                for (int j = 0; j < oldPar.size(); j++) {
                    newType = newPar.get(j);
                    oldType = oldPar.get(j);

                    if (!FOOLlib.isSubtype(oldType, newType)) {
                        FOOLlib.addTypeError("Parameter " + j + " not contravariant in definition of " + ((FunNode) methods.get(i)).getId() + ".");
                        FOOLlib.addTypeError("\tSubclass parameter is of type '" + newType + "', superclass is of type '" + oldType + "'.");
                    }
                }

                Node oldRet = ((FunNode) superMethods.get(i)).getArrowType().getRet();
                Node newRet = ((FunNode) methods.get(i)).getArrowType().getRet();

                if (!FOOLlib.isSubtype(newRet, oldRet))
                    FOOLlib.addTypeError("Return type '" + oldRet + "' is not covariant wrt its superclass definition type '" + newRet + "'.");
            }
        }

        for (Node m: methods)
            m.typeCheck();

        return null;
    }

    @Override
    public String codeGeneration() {
        String classCode = id + ":\n";

        // viene chiamata la cgen per ogni metodo definito nella classe
        for (int i = 0; i < methods.size(); i++) {
            Node method = methods.get(i);
            // il self è il nome della classe in cui è dichiarato
            String selfName = ((ClassIdNode) ((FunNode) method).getSelf()).getClassId();

            //id : nome della classe
            // quindi il self deve essere in effetti uguale al nome della classe
            if (id.equals(selfName))
                method.codeGeneration();

            String label = FOOLlib.freshLabel();

            classCode += "lmo\n" +
                         "push " + i + "\n" +
                         "beq " + FOOLlib.getMethodLabel(selfName, ((FunNode) method).getId()) + "\n";
        }

        FOOLlib.putCode(classCode);
        return "";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        env.setClassEnvironment(id);

        // siamo all'interno della dichiarazione di una classe
        // si sta accedendo a un nuovo scope, allora bisogna incrementare il nesting level a 1
        env.incNestingLevel();

        // nuova hp per nl 1 nella symbol table
        env.addSymTableHMtoNL();

        env.addObjectEnvHMtoNL();

        ArrayList<SemanticError> res = new ArrayList<>();

        //controllare ID
        // se il nome della classe è uguale al nome della superclasse
        if (id.equals(superclass)) {
            // si lancia un errore semantico
            res.add(new SemanticError(id + " cannot extend itself."));
        } else {

            // la classe estende una superclasse oppure no
            boolean extendsSomething = !superclass.equals("");

            // se sì
            // inheritance e overriding dei campi
            if (extendsSomething) {

                 /*
                    attributi
                 */

                // si recupera il class layout della superclasse
                superClassLayout = env.getClassLayout(superclass);

                // si prendono i metodi della superclasse
                ArrayList<Node> supFields = new ArrayList<>(superClassLayout.getFields());

                // si cicla sugli attributi della classe corrente
                boolean override = false;
                for (Node field : fields) {
                    for (int j = 0; j < supFields.size(); j++) {
                        // se l'attributo fa override dell'attributo della superclasse
                        if (((VarDecNode) supFields.get(j)).getId().equals(((VarDecNode) field).getId())) {
                            // si fa l'override
                            supFields.set(j, field);
                            override = true;
                        }
                    }

                    // se non fa override, si aggiunge l'attributo extra della classe corrente
                    if (!override) 
                        supFields.add(field);

                    override = false;
                }

                // alla fine si ha che l'object layout della classe corrente è uguale a quello della
                // superclasse a cui sono stati però sostituiti gli attributi di cui si fa ovverride
                // e a cui sono stati aggiunti i campi extra della classe corrente.
                fields = supFields;
            }

            //checksemantics field e methods classe attuale
            env.setOffset(0);

            // dopo il controllo dell'override
            // si ciclano gli attributi e ricorsivamente si chiama su di essi la checksemantics
            for (Node field : fields) {
                res.addAll(field.checkSemantics(env));
            }

            /*
            metodi
             */

            // processing di tutti i nomi dei metodi ==> uso prima delle dichiarazioni è possibile
            String methodName;

            // si ciclano i metodi dichiarati all'interno della classe
            // nota. funNode si usa sia per i metodi che per le funzioni semplici
            for (Node method : methods) {
                //Imposto il self all'inizio dei parametri nel FunNode.
                // il self non è altro che un classid node corrispondente alla classe correntr
                ((FunNode) method).setSelf(new ClassIdNode(id));

                // nome del metodo
                methodName = ((FunNode) method).getId();

                // si prende da hm al level 1
                // al hm bisogna aggiungere tutte i metodi
                HashMap<String, STentry> hm = env.getSymTable().get(env.getNestingLevel());

                env.decOffset();

                // st entry per il metodo
                STentry entry = new STentry(env.getNestingLevel(), env.getOffset());

                env.incOffset();  // ?

                // si aggiunge il metodo alla hm nl 1
                // se la st contiene già l'id ==> error
                if (hm.put(methodName, entry) != null)
                    // si lancia un errore semantico
                    res.add(new SemanticError("Method id " + methodName + " already declared"));
            }

            // processing effettivo ==> essendo gia' presenti tutti i nomi possiamo fare mutua ricorsione
            // si ciclano i metodi e ricorsivamente si chiama su di essi la checksemantics
            env.setOffset(0);
            for (Node method : methods) {
                res.addAll(method.checkSemantics(env));
            }

            // inheritance e overriding dei metodi
            if (extendsSomething) {
                superClassLayout = env.getClassLayout(superclass);
                ArrayList<Node> supMethods = new ArrayList<>(superClassLayout.getMethods());

                boolean override = false;
                for (int i = 0; i < methods.size(); i++) {
                    Node method = methods.get(i);
                    for (int j = 0; j < supMethods.size(); j++) {
                        if (((FunNode) supMethods.get(j)).getId().equals(((FunNode) method).getId())) {
                            supMethods.set(j, method);
                            override = true;
                        }
                    }

                    if (!override)
                        supMethods.add(method);

                    override = false;
                }
                methods = supMethods;
            }


            for (int i = 0; i < methods.size() ; i++)
                ((FunNode) methods.get(i)).setMethodOffset(i);
        }

        // rimossa la hp per il nl corrente
        env.getSymTable().remove(env.getNestingLevel());

        // rimossa la hp per il nl corrente
        env.getObjectEnvironment().remove(env.getNestingLevel());

        // decrementare nl
        // ricorda: va fatto dopo aver rimosso la hp dalla symbol table
        env.decNestingLevel();

        return res;
    }

    public String getId() {
        return id;
    }

    public String getSuperclass() {
        return superclass;
    }

    public ArrayList<Node> getFields() {
        return fields;
    }

    public ArrayList<Node> getMethods() {
        return methods;
    }

    public Node getMethod(String methodName) {
        String ownMethodName;

        for (Node method: methods) {
            ownMethodName = ((FunNode) method).getId();
            if (ownMethodName.equals(methodName))
                return method;
        }

        return null;
    }

}