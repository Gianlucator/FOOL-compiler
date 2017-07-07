package lib;

import ast.*;
import util.TypeTreeNode;

public class FOOLlib {

    private static TypeTreeNode root = new TypeTreeNode("",null,null);

    private static int labCount = 0;
    private static int objCount = 0;
    private static int funLabCount = 0;

    private static String funCode = "";

    //valuta se il tipo "a" è <= del tipo "b", dove "a" e "b" sono tipi di base: int o bool
    public static boolean isSubtype(Node a, Node b) {
        if (a instanceof ClassIdNode && b instanceof ClassIdNode)
            return !FOOLlib.isSubtype(((ClassIdNode) a).getClassId(), ((ClassIdNode) b).getClassId());
        else if (a instanceof ClassIdNode || b instanceof ClassIdNode)
            return false;
        else
            return a.getClass().equals(b.getClass()) ||
                ((a instanceof BoolTypeNode) && (b instanceof IntTypeNode)); //
    }

    //valuta se la classe B è sottotipo della classe A
    public static boolean isSubtype(String B, String A) {
        TypeTreeNode typeOfA = root.findNode(A);
        TypeTreeNode typeOfB = root.findNode(B);

        try { //tamarro ma funziona
            return typeOfB.isSubtype(typeOfA);
        } catch (Exception e){
            return false;
        }
    }

    public static String freshLabel() {
        return "label" + (labCount++);
    }

    public static String freshFunLabel() {
        return "function" + (funLabCount++);
    }

    public static int freshObjLabel() { return objCount++; }

    public static void resetCode() { funCode = ""; }

    public static void putCode(String c) {
        funCode += "\n" + c; //aggiunge una linea vuota di separazione prima di funzione
    }

    public static String getCode() {
        return funCode;
    }

    public static TypeTreeNode getRoot() {
        return root;
    }

    public static void setRoot(TypeTreeNode root) {
        FOOLlib.root = root;
    }
}