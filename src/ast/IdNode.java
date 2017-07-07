package ast;

import java.util.ArrayList;

import util.Environment;
import util.SemanticError;

public class IdNode implements Node {

    private String id;
    private STentry entry;
    private int nestinglevel;
    private int fieldOffset;
    private boolean isField;

    public IdNode(String i) {
        id = i;
        isField = false;
        fieldOffset = 0;
    }

    public String toPrint(String s) {
        return s + "Id:" + id + " at nestlev " + nestinglevel + "\n" + entry.toPrint(s + "  ");
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        //create result list
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        // TODO: assegnare cmq entry
        if (!id.equals("this")) {
            int j = env.getNestingLevel();

            STentry tmp = null;
            while (j >= 0 && tmp == null) {
                tmp = (env.getSymTable().get(j--)).get(id);
            }
            if (tmp == null)
                res.add(new SemanticError("Id " + id + " not declared"));
            else {
                entry = tmp;
                nestinglevel = env.getNestingLevel();

                // controllo se e' un accesso a un campo, se si mi salvo l'offset per al codegen
                if (entry.getNestinglevel() == 1 && !env.getClassEnvironment().equals("")) {
                    ClassNode ownerCl = env.getClassLayout(env.getClassEnvironment());
                    ArrayList<Node> fields = ownerCl.getFields();

                    for (int i = 0; i < fields.size(); i++) {
                        Node fl = fields.get(i);
                        if (((VarDecNode) fl).getId().equals(id))
                            fieldOffset = -i - 3;
                    }

                    isField = true;
                }
            }
        }

        return res;
    }

    public Node typeCheck() {
        if (entry.getType() instanceof ArrowTypeNode) { //
            System.out.println("Wrong usage of function identifier");
            System.exit(0);
        }
        return entry.getType();
    }

    public String codeGeneration() {
        if (!id.equals("this")){
            if (isField) {
                return "push " + fieldOffset + "\n" +  // push offset sullo stack
                        "lop\n" +                       // carichi hp che punta all'oggetto sullo heap
                        "add\n" +                       // calcoli il ptr al campo
                        "lw\n";                         // carichi il valore del campo
            } else {
                String getAR = "";
                for (int i = 0; i < nestinglevel - entry.getNestinglevel(); i++)
                    getAR += "lw\n";
                return "push " + entry.getOffset() + "\n" + //metto offset sullo stack
                        "lfp\n" + getAR + //risalgo la catena statica
                        "add\n" +
                        "lw\n"; //carico sullo stack il valore all'indirizzo ottenuto
            }
        } else {
            return "lop\n";
        }
    }
}