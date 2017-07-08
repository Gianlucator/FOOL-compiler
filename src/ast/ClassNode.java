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
                            ((VarDecNode) newField).getId(), ((VarDecNode) newField).getType().getClass(), ((VarDecNode) oldField).getType().getClass()));
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
                        FOOLlib.addTypeError("Parameter " + j + " not contravariant in definition of " + ((FunNode) methods.get(i)).getId());
                        FOOLlib.addTypeError("\tSubclass parameter is " + newType.toPrint("") + ", superclass was " + oldType.toPrint(""));
                    }
                }

                Node oldRet = ((FunNode) superMethods.get(i)).getArrowType().getRet();
                Node newRet = ((FunNode) methods.get(i)).getArrowType().getRet();

                if (!FOOLlib.isSubtype(newRet, oldRet))
                    FOOLlib.addTypeError("Return type: " + oldRet + " is not covariant wrt its superclass definition " + newRet.getClass());
            }
        }

        for (Node m: methods)
            m.typeCheck();

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

                    if (!override) 
                        supFields.add(field);

                    override = false;
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
        env.getObjectEnvironment().remove(env.getNestingLevel());
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