package lib;

import ast.*;
import util.TypeError;
import util.TypeTreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class FOOLlib {

    private static TypeTreeNode root = new TypeTreeNode("",null,null);

    private static int labCount = 0;
    private static int objCount = 0;
    private static int funLabCount = 0;

    private static String funCode = "";

    private static ArrayList<TypeError> typeErrors = new ArrayList<>();

    //valuta se il tipo "a" è <= del tipo "b", dove "a" e "b" sono tipi di base: int o bool
    public static boolean isSubtype(Node a, Node b) {
        if (a instanceof ClassIdNode && b instanceof ClassIdNode){
            return FOOLlib.isSubtype(((ClassIdNode) a).getClassId(), ((ClassIdNode) b).getClassId());
        }
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
            return typeOfB.isSubtype(typeOfA) ;
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

    //TODO: controllare se serve
    public static int freshObjLabel() { return objCount++; }

    public static String getMethodLabel(String className, String methodName) {
        return methodName + methodName.length() + className + className.length();
    }

    public static void reset() {
        funCode = "";
        labCount = 0;
        objCount = 0;
        funLabCount = 0;

        typeErrors = new ArrayList<>();
    }

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

    public static ArrayList<TypeError> getTypeErrors() {
        return typeErrors;
    }

    public static void addTypeError(String msg) {
        typeErrors.add(new TypeError(msg));
    }
}