package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by crist on 14/06/2017.
 */
public class NewExpNode implements Node {
    private String classId;
    private ArrayList<Node> args;

    public NewExpNode(String classId, ArrayList<Node> args) {
        this.classId = classId;
        this.args = args;
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

    // sistemare, manca:
    // - mismatch parametri ==> stesso numero (tipo si controlla dopo)
    // - ???
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        HashMap<String,STentry> hm = new HashMap<String,STentry> ();
        //env.symTable.add(hm);

        //declare resulting list
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        //if (env.classTable.get(classId) == null)
            //res.add(new SemanticError("Class " + objectId + " not declared."));

        int constructorArguments = 0; //env.classTable.get(classId).getClassNode().getFields().size();
        if (constructorArguments != args.size()) {
            String fewOrMany = (constructorArguments > args.size()) ? "few" : "many";
            res.add(new SemanticError(String.format("Too %s arguments arguments for %s constructor. Need %d, %d given.",
                    fewOrMany, classId, constructorArguments, args.size())));
        }

        for (Node arg : args)
            res.addAll(arg.checkSemantics(env));

        //hm.get(0)

        return res;
    }
}
