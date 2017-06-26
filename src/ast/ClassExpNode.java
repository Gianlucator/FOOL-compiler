package ast;

import util.Environment;
import util.SemanticError;

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
        env.nestingLevel++;
        HashMap<String,STentry> hm = new HashMap<> ();
        env.symTable.add(hm);

        //declare resulting list
        ArrayList<SemanticError> res = new ArrayList<>();

        STentry clsEntry;
        String clsName;

        for (Node cls: classes) {
            clsEntry = new STentry(env.nestingLevel, env.offset);
            clsName = ((ClassNode) cls).getId();

            if (env.symTable.get(env.nestingLevel).put(clsName, clsEntry) != null)
                res.add(new SemanticError("Class: " + clsName + " already declared."));
        }

        //check semantics in the dec list
        if(classes.size() > 0){
            env.offset = -1;
            //if there are children then check semantics for every child and save the results
            for(Node cl : classes)
                res.addAll(cl.checkSemantics(env));
        }

        //check semantics in the (let)? exp
        res.addAll(body.checkSemantics(env));

        //clean the scope, we are leaving a let scope
        env.symTable.remove(env.nestingLevel--);

        //return the result
        return res;
    }
}
