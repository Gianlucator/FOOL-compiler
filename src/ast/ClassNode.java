package ast;

import util.CTentry;
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
    private ArrayList<Node> methods;

    public ClassNode(String id, String superclass, ArrayList<Node> fields, ArrayList<Node> methods) {
        this.id = id;
        this.superclass = superclass;
        this.fields = fields;
        this.methods = methods;
    }

    public ArrayList<Node> getFields(){
        return fields;
    }

    public ArrayList<Node> getMethods(){
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

        CTentry ctEntry = new CTentry(this);
        ArrayList<SemanticError> res = new ArrayList<>();
        //controllare ID
        if (id.equals(superclass))
            res.add(new SemanticError(id + " cannot extend itself."));
        else {
            //env.nestingLevel++;

            if ((env.classTable.put(id, ctEntry)) != null)
                res.add(new SemanticError("Class " + id + " has been already declared"));

            //controllare ID superclasse
            if (!superclass.equals("")){
                if ((env.classTable.get(superclass) == null))
                    res.add(new SemanticError("Extended class " + superclass + " has not been declared"));
                else {
                    env.classTable.get(id).setSuperClass(env.classTable.get(superclass).getClassNode());
                }
            }

            //checksemantics field e methods classe attuale
            for (Node field : fields)
                res.addAll(field.checkSemantics(env));

            for (Node method : methods)
                res.addAll(method.checkSemantics(env));

            //env.nestingLevel--;
        }

        return res;
    }
}
