package lib;

import ast.*;
import util.TypeTreeNode;

public class FOOLlib {

    private static TypeTreeNode root = new TypeTreeNode("object", null);

    private static int labCount = 0;

    private static int funLabCount = 0;

    private static String funCode = "";

    //valuta se il tipo "a" � <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
    public static boolean isSubtype(Node a, Node b) {
        return a.getClass().equals(b.getClass()) ||
                ((a instanceof BoolTypeNode) && (b instanceof IntTypeNode)); //
    }

    public static boolean isSubtype(String A, String B) {
        TypeTreeNode typeOfA = root.findNode(A);
        TypeTreeNode typeOfB = root.findNode(B);
        return typeOfA.getSuperTypes().contains(typeOfB); // O(1)
    }

    public static String freshLabel() {
        return "label" + (labCount++);
    }

    public static String freshFunLabel() {
        return "function" + (funLabCount++);
    }

    public static void putCode(String c) {
        funCode += "\n" + c; //aggiunge una linea vuota di separazione prima di funzione
    }

    public static String getCode() {
        return funCode;
    }
}