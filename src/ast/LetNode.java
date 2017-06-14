package ast;

import util.Environment;
import util.SemanticError;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Stefano on 11/06/2017.
 */
public class LetNode implements Node {

    private ArrayList<Node> decList;

    public LetNode(ArrayList<Node> decList) {
        this.decList = decList;
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
        HashMap<String,STentry> hm = new HashMap<String,STentry> ();
        env.symTable.add(hm);

        //declare resulting list
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        //check semantics in the dec list
        if(decList.size() > 0){
            env.offset = -2;
            //if there are children then check semantics for every child and save the results
            for(Node n : decList)
                res.addAll(n.checkSemantics(env));
        }

        //clean the scope, we are leaving a let scope
        env.symTable.remove(env.nestingLevel--);

        return res;
    }
}
