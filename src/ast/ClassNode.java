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
    public String toPrint(String indent) {
        return null;
    }

    @Override
    public Node typeCheck() {
        return null;
    }

    @Override
    public String codeGeneration() {
        return null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        env.incNestingLevel();

        HashMap<String,STentry> hm = new HashMap<> ();
        env.getSymTable().add(hm);

        ArrayList<SemanticError> res = new ArrayList<>();
        //controllare ID
        if (id.equals(superclass)) {
            res.add(new SemanticError(id + " cannot extend itself."));
        } else {

            //checksemantics field e methods classe attuale
            for (Node field : fields) {
                res.addAll(field.checkSemantics(env));
            }

            // processing di tutti i nomi dei metodi ==> uso prima delle dichiarazioni è possibile
            for (Node method : methods) {
                res.addAll(method.checkSemantics(env));
            }

            //controllare ID superclasse
            if (!superclass.equals("")) {
                ClassNode superClassLayout = env.getClassLayout(superclass);
                if (superClassLayout == null) {
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