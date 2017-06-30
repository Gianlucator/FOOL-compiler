package ast;

import util.Environment;
import util.SemanticError;
import util.TypeTreeBuilder;
import util.TypeTreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Stefano on 06/06/2017.
 */
public class ClassExpNode implements Node {

    private ArrayList<Node> classes;
    private Node body;

    public ClassExpNode(ArrayList<Node> classes, Node body) {
        this.classes = classes;
        this.body = body;
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
        env.incNestingLevel(); // 0
        HashMap<String, STentry> hm = new HashMap<>();
        env.getSymTable().add(hm);

        //declare resulting list
        ArrayList<SemanticError> res = new ArrayList<>();

        String clsName;
        TypeTreeNode typesRoot = TypeTreeBuilder.buildTypeTree(classes);

        if (typesRoot == null) {
            res.add(new SemanticError("Cycle(s) between class definitions."));
        } else {
            classes = typesRoot.buildWellOrderedClassList();
        }

        // add all class names to the environment to allow subclassing before declaration
        for (Node cls : classes) {
            clsName = ((ClassNode) cls).getId();
            STentry sTentry = new STentry(env.getGLOBAL_SCOPE(), env.getOffset());
            if (env.insertClassEntry(clsName, sTentry) != null)
                res.add(new SemanticError("Multiple declarations of class " + clsName));
        }

        for (Node cl : classes)
            res.addAll(cl.checkSemantics(env));

        res.addAll(body.checkSemantics(env));

        //env.getSymTable().remove(env.getNestingLevel());
        env.decNestingLevel();

        //return the result
        return res;
    }
}
