package ast;

import util.DispatchTable;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * Created by Stefano on 06/06/2017.
 */
public class ClassNode implements Node {

    private String id;
    private String superclass;
    private ArrayList<Node> fields;
    private ArrayList<MethodNode> methods;

    public ClassNode(String id, String superclass, ArrayList<Node> fields, ArrayList<MethodNode> methods) {
        this.id = id;
        this.superclass = superclass;
        this.fields = fields;
        this.methods = methods;
    }

    public String getId() { return id; }

    public ArrayList<Node> getFields(){
        return fields;
    }

    public ArrayList<MethodNode> getMethods(){
        return methods;
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

        STentry entry = new STentry(env.nestingLevel,env.offset--);
        System.out.println("Il nesting level in questa classe è: " + env.nestingLevel);

        ArrayList<SemanticError> res = new ArrayList<>();
        //controllare ID
        if (id.equals(superclass)) {
            res.add(new SemanticError(id + " cannot extend itself."));
        }
        else {
            //checksemantics field e methods classe attuale
            for (Node field : fields)
                res.addAll(field.checkSemantics(env));

            for (Node method : methods)
                res.addAll(method.checkSemantics(env));

            // all class names are at nesting level 0
            if ((env.symTable.get(0).put(id, entry)) != null) {
                res.add(new SemanticError("Class " + id + " has been already declared"));
            }

            DispatchTable classDT = new DispatchTable();
            //controllare ID superclasse
            if (!superclass.equals("")) {
                STentry superClassEntry = (env.symTable.get(0)).get(superclass);
                if (superClassEntry == null) {
                    res.add(new SemanticError("Extended class " + superclass + " has not been declared"));
                } else {
                    // crea dispatch table usando anche la tabella della superclasse
                    DispatchTable superclassDT = env.dispatchTables.get(superclass);
                    classDT.buildDispatchTable(methods, superclassDT);

                }
            } else {
                classDT.buildDispatchTable(methods);
            }
        }

        return res;
    }
}