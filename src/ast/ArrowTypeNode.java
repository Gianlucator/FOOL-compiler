package ast;

import java.util.ArrayList;

import util.Environment;
import util.SemanticError;

public class ArrowTypeNode implements Node {

    // lista parametri della funzione/metodo
    private ArrayList<Node> parlist;

    // tipo di ritorno della funzione/metodo
    private Node ret;

    public ArrowTypeNode(ArrayList<Node> p, Node r) {
        parlist = p;
        ret = r;
    }

    public String toPrint(String s) {
        String parlstr = "";
        for (Node par : parlist)
            parlstr += par.toPrint(s + "  ");
        return s + "ArrowType\n" + parlstr + ret.toPrint(s + "  ->");
    }

    public Node getRet() {
        return ret;
    }

    public void setRet(Node ret) {
        this.ret = ret;
    }

    public ArrayList<Node> getParList() { //
        return parlist;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<>();
    }

    //non utilizzato
    public Node typeCheck() {
        return null;
    }

    //non utilizzato
    public String codeGeneration() {
        return "";
    }

}  