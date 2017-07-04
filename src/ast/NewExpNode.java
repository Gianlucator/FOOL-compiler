package ast;

import jdk.nashorn.internal.ir.VarNode;
import lib.FOOLlib;
import util.DTEntry;
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
    ClassNode classEntry;

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
            Node varNodeType = ((VarDecNode) classEntry.getFields().get(i)).getType();
            Node arg = args.get(i).typeCheck();
            if ( arg instanceof ClassIdNode && varNodeType instanceof ClassIdNode) {
                if (!FOOLlib.isSubtype(((ClassIdNode) arg.typeCheck()).getClassId(), ((ClassIdNode) varNodeType).getClassId())) {
                    System.out.println("Incompatible class for parameter at position " + i);
                    System.exit(0);
                }
                if(arg != varNodeType)
                    ((VarDecNode) classEntry.getFields().get(i)).setType(arg.typeCheck());
            }
            else {
                if (!(FOOLlib.isSubtype(arg, varNodeType))) {
                    System.out.println("Incompatible value for parameter at position " + i);
                    System.exit(0);
                }
            }
        }
        return new ClassIdNode(classId);
    }

    @Override
    public String codeGeneration() {
        String saveToHPThenIncHP =  "lhp\n" +
                                    "sw\n"  +       //store all'indirizzo del hp il valore pushato precedentemente
                                    "push 1\n" +
                                    "lhp\n" +
                                    "add\n" +       //vado all'indirizzo successivo
                                    "shp\n";        //modifico l'hp

        // salviamo indirizzo iniziale della classe = top heap sullo skack
        String code = "lhp\n";

        // salviamo il tag a addr_class + 1
        code += "push " + classId.hashCode() + "\n" +
                saveToHPThenIncHP;

        // salviamo la dimensione a addr_class + 2
        int size = args.size() + 2;
        code += "push " + size + "\n" + saveToHPThenIncHP;

        for (Node arg : args){
            code += arg.codeGeneration() + saveToHPThenIncHP; //shp fa già la pop
        }
        return code;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();
        HashMap<String, STentry> hm =  env.getSymTable().get(env.getNestingLevel());

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
        for (Node arg : args)
            res.addAll(arg.checkSemantics(env));

        return res;
    }
}
