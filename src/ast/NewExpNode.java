package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * Created by crist on 14/06/2017.
 */
public class NewExpNode implements Node {
    private String classId;
    private ArrayList<Node> args;
    private ClassNode classEntry;

    public NewExpNode(String classId, ArrayList<Node> args) {
        this.classId = classId;
        this.args = args;
    }

    public String getClassId() {
        return classId;
    }

    @Override
    public String toPrint(String indent) {
        return "";
    }

    @Override
    public Node typeCheck() {
        for (int i = 0; i < classEntry.getFields().size(); i++){
            Node arg = args.get(i).typeCheck();
            Node varNodeType = ((VarDecNode) classEntry.getFields().get(i)).getType();

            if (!FOOLlib.isSubtype(arg, varNodeType))
                FOOLlib.addTypeError("Incompatible parameter at position " + i + " during instantiation of class " + classId);
        }

        return new ClassIdNode(classId);
    }

    @Override
    public String codeGeneration() {
        String code = "";
        String saveToHPThenIncHP =  "lhp\n" +
                                    "sw\n"  +       //store all'indirizzo del hp il valore pushato precedentemente //fa 2 pop
                                    "push 1\n" +
                                    "lhp\n" +
                                    "add\n" +       //vado all'indirizzo successivo
                                    "shp\n";        //modifico l'hp //fa già la pop

        if (args.size() > 0){

            for (int i = args.size() - 1; i >= 0; i--)
                code += args.get(i).codeGeneration() + saveToHPThenIncHP;

            // salviamo la dimensione arg.size() + 1
            int size = args.size() + 1;
            code += "push " + size + "\n" + saveToHPThenIncHP;

        }
        // salviamo indirizzo iniziale dell'oggetto = top heap sullo stack
        code += "lhp\n";

        return code;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();

        // controllare che la classe esista
        classEntry = env.getClassLayout(classId);

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
        for (int i = 0; i < args.size(); i++){
            res.addAll(args.get(i).checkSemantics(env));
            if (args.get(i) instanceof NewExpNode){
                String argClass = ((NewExpNode) args.get(i)).getClassId();

                ClassNode cn = env.getClassLayout(classId);
                String id = ((VarDecNode) cn.getFields().get(i)).getId();

                ArrayList<IdNode> nodes = new ArrayList<>();
                if (env.getFieldTypes().get(classId) != null){
                     nodes = env.getFieldTypes().get(classId);
                }
                for (IdNode idn : nodes){
                    if (idn.getId().equals(id)){
                        idn.getEntry().setType(new ClassIdNode(argClass));
                    }
                }
            }
        }

        return res;
    }
}
