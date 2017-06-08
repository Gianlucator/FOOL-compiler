package ast;

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

        STentry entry = new STentry(env.nestingLevel,env.offset--);
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();
        //controllare ID
        if (id.equals(superclass))
            res.add(new SemanticError(id + " cannot extend itself."));
        else {
            //env.nestingLevel++;

            //controllare ID superclasse
            if (!superclass.equals("") && (env.symTable.get(0)).get(superclass) == null)
                res.add(new SemanticError("Extended class " + superclass + " has not been declared"));

            if ((env.symTable.get(0).put(id, entry)) != null)
                res.add(new SemanticError("Class " + id + " has been already declared"));

            if (!superclass.equals("")){
                fields.addAll(((ClassNode)(env.symTable.get(0)).get(superclass).getType()).getFields());
                methods.addAll(((ClassNode)(env.symTable.get(0)).get(superclass).getType()).getMethods());
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
