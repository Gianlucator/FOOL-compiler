package ast;

import lib.FOOLlib;
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
    public String toPrint(String s) {
        String declstr="";
        for (Node c : classes)
            declstr += c.toPrint(s+"  ");
        return s+"ClassExp\n" + declstr + body.toPrint(s+"  ") ;
    }

    @Override
    public Node typeCheck() {
        return body.typeCheck();
    }

    @Override
    public String codeGeneration() {
        String code = "";

        for (Node cls: classes)
            code += cls.codeGeneration();

        code += body.codeGeneration();

        return code;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        env.incNestingLevel(); // 0
        HashMap<String, STentry> hm = new HashMap<>();
        env.getSymTable().add(hm);

        //declare resulting list
        ArrayList<SemanticError> res = new ArrayList<>();

        FOOLlib.setRoot(TypeTreeBuilder.buildTypeTree(classes));

        if (FOOLlib.getRoot() == null) {
            res.add(new SemanticError("Cycle(s) between class definitions."));
        } else {
            classes = FOOLlib.getRoot().buildWellOrderedClassList();
        }

        // add all class names to the environment to allow subclassing before declaration
        for (Node cls : classes) {
            String clsName = ((ClassNode) cls).getId();
            String supClsName = ((ClassNode) cls).getSuperclass();

            if (!env.isClassDeclared(supClsName) && !supClsName.equals("")) {
                res.add(new SemanticError("Superclass " + supClsName + " of " + clsName + " not declared."));
            }

            STentry sTentry = new STentry(env.getGLOBAL_SCOPE(), env.getOffset());
            if (env.insertClassEntry(clsName, sTentry) != null)
                res.add(new SemanticError("Multiple declarations of class " + clsName));
        }

        for (Node cl : classes)
            res.addAll(cl.checkSemantics(env));

        env.setClassEnvironment("");

        res.addAll(body.checkSemantics(env));

        //env.getSymTable().remove(env.getNestingLevel());
        env.decNestingLevel();

        //return the result
        return res;
    }
}
