package util;

import ast.FunNode;
import ast.Node;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by crist on 22/06/2017.
 */
public class DispatchTable {
    private HashMap<String, FunNode> methods;

    public DispatchTable() {
        methods = new HashMap<>();
    }

    public void buildDispatchTable(ArrayList<Node> currentMethods) {
        for (Node mt: currentMethods)
            if(mt instanceof FunNode) {
                methods.put(((FunNode) mt).getId(), (FunNode) mt); //override or add new methods
            }
    }

    public void buildDispatchTable(ArrayList<Node> currentMethods, DispatchTable superclassDT) {
        if (superclassDT != null)
            this.methods = superclassDT.getMethods();   //inherit
        buildDispatchTable(currentMethods);
    }

    public HashMap<String, FunNode> getMethods() {
        return methods;
    }

    public String toString() {
        return methods.toString();
    }

}
