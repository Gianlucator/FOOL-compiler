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

    public String getClassId() {
        return classId;
    }

    @Override
    public String toPrint(String indent) {
        return null;
    }

    @Override
    public Node typeCheck() {
        return new ClassIdNode(classId);
    }

    @Override
    public String codeGeneration() {
        return null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();
        HashMap<String, STentry> hm =  env.getSymTable().get(env.getNestingLevel());

        // controllare che la classe esista
        ClassNode classEntry = env.getClassLayout(classId);

        if (classEntry == null)
            res.add(new SemanticError("Class " + classId + " not declared."));
        else {
            // controllare che il costruttore sia chiamato col corretto numero di argomenti
            int constructorArguments = classEntry.getFields().size();

            if (constructorArguments != args.size()) {
                String fewOrMany = (constructorArguments > args.size()) ? "few" : "many";
                res.add(new SemanticError(String.format("Too %s arguments arguments for %s constructor. Need %d, %d given.",
                        fewOrMany, classId, constructorArguments, args.size())));
            }
        }
        for (Node arg : args)
            res.addAll(arg.checkSemantics(env));

        return res;
    }
}
