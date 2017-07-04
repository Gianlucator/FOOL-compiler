package ast;

import util.DispatchTable;
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
    private DispatchTable fieldDT;
    private DispatchTable methodDT;

    public ClassNode(String id, String superclass, ArrayList<Node> fields, ArrayList<Node> methods) {
        this.id = id;
        this.superclass = superclass;
        this.fields = fields;
        this.methods = methods;
        methodDT = new DispatchTable();
        fieldDT = new DispatchTable();
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

    public DispatchTable getMethodDT() {
        return methodDT;
    }

    public DispatchTable getFieldDT() {
        return fieldDT;
    }

    @Override
    public String toPrint(String s) {
        return s + "class: " + id + "\n";
    }

    @Override
    public Node typeCheck() {
        return null;
    }

    @Override
    public String codeGeneration() {
        StringBuilder classCode = new StringBuilder();

        int offset = 0;
        for (String field : fieldDT.getEntries().keySet())
            fieldDT.getEntries().get(field).setOffset(offset++);

        //classCode += "push " + offset + "\n";
        // il valore finale di offset è la size

        //Adesso la codegen dei metodi
        for (Node method : methods)
            classCode.append(method.codeGeneration());

        return classCode.toString();
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        env.incNestingLevel();
        env.getSymTable().add(new HashMap<> ());

        ArrayList<SemanticError> res = new ArrayList<>();
        //controllare ID
        if (id.equals(superclass)) {
            res.add(new SemanticError(id + " cannot extend itself."));
        } else {

            //checksemantics field e methods classe attuale
            env.setOffset(-2);
            for (Node field : fields) {
                res.addAll(field.checkSemantics(env));
            }

            // processing di tutti i nomi dei metodi ==> uso prima delle dichiarazioni è possibile
            String methodName;
            for (Node method: methods) {
                //Imposto il self all'inizio dei parametri nel FunNode.
                ((FunNode) method).setSelf(new ClassIdNode(id));
                methodName = ((FunNode) method).getId();

                HashMap<String, STentry> hm = env.getSymTable().get(env.getNestingLevel());
                env.decOffset();
                STentry entry = new STentry(env.getNestingLevel(), env.getOffset()); //separo introducendo "entry"
                env.incOffset();

                // se la st contiene già l'id ==> error
                if (hm.put(methodName, entry) != null)
                    res.add(new SemanticError("Method id " + methodName + " already declared"));
            }

            // processing effettivo ==> essendo gia' presenti tutti i nomi possiamo fare mutua ricorsione e boiate varie
            for (Node method : methods) {
                res.addAll(method.checkSemantics(env));
            }

            //controllare ID superclasse
            if (!superclass.equals("")) {
                ClassNode superClassLayout = env.getClassLayout(superclass);
                ArrayList<Node> supFields = superClassLayout.getFields();

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


                if (!env.isClassDeclared(superclass)) {
                    res.add(new SemanticError("Extended class " + superclass + " has not been declared"));
                } else {
                    // crea dispatch table usando anche la tabella della superclasse
                    DispatchTable superclassDT = superClassLayout.getMethodDT();
                    methodDT.buildDispatchTable(methods, superclassDT);
                    fieldDT.buildDispatchTable(fields, superclassDT);
                }
            } else {
                methodDT.buildDispatchTable(methods);
                fieldDT.buildDispatchTable(fields);
            }

            env.insertClassEntry(id, new STentry(env.getGLOBAL_SCOPE(), this, env.getOffset()));
        }

        env.getSymTable().remove(env.getNestingLevel());
        env.decNestingLevel();
        return res;
    }

}