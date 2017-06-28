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
    private ObjectNode objectLayout;

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

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();
        //env.symTable.add(hm);

        // controllare che la classe esista
        STentry classEntry = env.getSymTable().get(env.getGLOBAL_SCOPE()).get(classId);

        if (classEntry == null || !(classEntry.getType() instanceof ClassNode))
            res.add(new SemanticError("Class " + classId + " not declared."));
        else {
            // controllare che il costruttore sia chiamato col corretto numero di argomenti
            int constructorArguments = ((ClassNode) classEntry.getType()).getFields().size();

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
