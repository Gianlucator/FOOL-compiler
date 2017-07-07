package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Stefano on 06/06/2017.
 */
public class ClassNode implements Node {

    private String id;
    private String superclass;
    private ArrayList<Node> fields;
    private ArrayList<Node> methods;
    private ClassNode superClassLayout;

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
        // TODO: controllare overriding corretto di metodi
        //Override Fields
        for (Node newField : fields) {
            for (Node oldField : superClassLayout.getFields()) {
                if(((VarDecNode) newField).getId().equals(((VarDecNode) oldField).getId())) {
                    Node newType = ((VarDecNode) newField).getType();
                    Node oldType = ((VarDecNode) oldField).getType();
                    if(newType instanceof ClassIdNode && oldType instanceof ClassIdNode) {
                        if(!FOOLlib.isSubtype(((ClassIdNode) newType).getClassId(),((ClassIdNode) oldType).getClassId())) {
                            System.out.println("Field " + ((VarDecNode) newField).getId() + "of type" + ((VarDecNode) newField).getType()
                                                + " cannot override the old field of type " + ((VarDecNode) oldField).getType() + ".\n");
                            System.exit(0);
                        }
                    } else {
                        if(!FOOLlib.isSubtype(newType, oldType)) {
                            System.out.println("Field " + ((VarDecNode) newField).getId() + "of type" + ((VarDecNode) newField).getType()
                                    + " cannot override the old field of type " + ((VarDecNode) oldField).getType() + ".\n");
                            System.exit(0);
                        }
                    }
                }
            }
        }
        //Override Metodi
        for (Node newMethod : methods) {
            for (Node oldMethod : superClassLayout.getMethods()){
                if(((FunNode) newMethod).getId().equals(((FunNode) oldMethod).getId()) &&
                    methods.size() == superClassLayout.getMethods().size()) {

                    ArrayList<Node> oldPar = ((FunNode) oldMethod).getArrowType().getParList();
                    ArrayList<Node> newPar = ((FunNode) newMethod).getArrowType().getParList();
                    for (int i = 0; i < oldPar.size(); i++) {
                        // se il parametro è un oggetto
                        if (((ParNode) oldPar.get(i)).getType() instanceof ClassIdNode &&
                                ((ParNode) newPar.get(i)).getType() instanceof ClassIdNode) {
                            if (!FOOLlib.isSubtype(((ClassIdNode) oldPar.get(i)).getClassId(),
                                    ((ClassIdNode) newPar.get(i)).getClassId())) {
                                System.out.println("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + ((FunNode) newMethod).getId());
                                System.exit(0);
                            }
                        } else {  // se il parametro è int o bool
                            try{
                                //Nel caso in cui un parametro sia un oggetto e l'altro int va in nullpointer.
                                //Catturo dicendo che non è sottotipo.
                                if (!FOOLlib.isSubtype(oldPar.get(i), newPar.get(i))) {
                                    System.out.println("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + ((FunNode) newMethod).getId());
                                    System.exit(0);
                                }
                            } catch (Exception e){
                                System.out.println("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + ((FunNode) newMethod).getId());
                                System.exit(0);
                            }
                        }
                    }

                    Node oldRet = ((FunNode) oldMethod).getArrowType().getRet();
                    Node newRet = ((FunNode) newMethod).getArrowType().getRet();
                    // deve valere la covarianza per il tipo di ritorno
                    if (newRet instanceof ClassIdNode && oldRet instanceof ClassIdNode) {
                        if (!FOOLlib.isSubtype(((ClassIdNode) newRet).getClassId(), ((ClassIdNode) oldRet).getClassId())) {
                            System.out.println("Wrong return type");
                            System.exit(0);
                        }
                    } else {
                        try{
                            //nel caso in cui un parametro sia un oggetto e l'altro int va in nullpointer.
                            //Catturo dicendo che non è sottotipo.
                            if (!FOOLlib.isSubtype(newRet, oldRet)) {
                                System.out.println("Wrong return type");
                                System.exit(0);
                            }
                        } catch (Exception e){
                            System.out.println("Wrong return type");
                            System.exit(0);
                        }
                    }

                }
            }
        }
        return null;
    }

    @Override
    public String codeGeneration() {

        for (Node method : methods)  {
            String selfName = ((ClassIdNode) ((FunNode) method).getSelf()).getClassId();
            if (id.equals(selfName))
                method.codeGeneration();
        }
        return "";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        env.setClassEnvironment(id);
        env.incNestingLevel();
        env.addSymTableHMtoNL();
        env.addObjectEnvHMtoNL();

        ArrayList<SemanticError> res = new ArrayList<>();

        //controllare ID
        if (id.equals(superclass)) {
            res.add(new SemanticError(id + " cannot extend itself."));
        } else {

            boolean extendsSomething = !superclass.equals("");

            // inheritance e overriding dei campi
            if (extendsSomething) {
                superClassLayout = env.getClassLayout(superclass);
                ArrayList<Node> supFields = new ArrayList<>(superClassLayout.getFields());

                boolean override = false;
                for (Node field : fields) {
                    for (int j = 0; j < supFields.size(); j++) {
                        if (((VarDecNode) supFields.get(j)).getId().equals(((VarDecNode) field).getId())) {
                            supFields.set(j, field);
                            override = true;
                        }
                    }

                    if (!override) {
                        supFields.add(field);
                        override = false;
                    }
                }
                fields = supFields;
            }

            //env.insertClassEntry(id, new STentry(env.getGLOBAL_SCOPE(), this, env.getOffset()));
            //checksemantics field e methods classe attuale
            env.setOffset(0);
            for (Node field : fields) {
                res.addAll(field.checkSemantics(env));
            }

            // processing di tutti i nomi dei metodi ==> uso prima delle dichiarazioni è possibile
            String methodName;
            for (Node method : methods) {
                //Imposto il self all'inizio dei parametri nel FunNode.
                ((FunNode) method).setSelf(new ClassIdNode(id));
                methodName = ((FunNode) method).getId();

                HashMap<String, STentry> hm = env.getSymTable().get(env.getNestingLevel());
                env.decOffset();
                STentry entry = new STentry(env.getNestingLevel(), env.getOffset());
                env.incOffset();

                // se la st contiene già l'id ==> error
                if (hm.put(methodName, entry) != null)
                    res.add(new SemanticError("Method id " + methodName + " already declared"));
            }

            // processing effettivo ==> essendo gia' presenti tutti i nomi possiamo fare mutua ricorsione e boiate varie
            for (Node method : methods) {
                res.addAll(method.checkSemantics(env));
            }

            // inheritance e overriding dei metodi
            if (extendsSomething) {
                superClassLayout = env.getClassLayout(superclass);
                ArrayList<Node> supMethods = new ArrayList<>(superClassLayout.getMethods());

                boolean override = false;
                for (Node method : methods) {
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
        }

        env.getSymTable().remove(env.getNestingLevel());
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
            if (ownMethodName.equals(methodName)){
                //System.out.println(((FunNode) method).getId());
                return method;
            }
        }

        return null;
    }

}