package util;

import ast.FunNode;
import ast.MethodNode;
import ast.Node;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by crist on 22/06/2017.
 */
public class DispatchTable {
    private HashMap<String, Node> methods;

    public DispatchTable() {
        methods = new HashMap<>();
    }

    public void buildDispatchTable(ArrayList<Node> currentMethods) {
        for (Node mn: currentMethods)
            methods.put(((FunNode) mn).getId(), mn); //override or add new methods
    }

    public void buildDispatchTable(ArrayList<Node> currentMethods, DispatchTable superclassDT) {
        if (superclassDT != null)
            this.methods = superclassDT.getMethods();   //inherit

        buildDispatchTable(currentMethods);
    }

    public HashMap<String, Node> getMethods() {
        return methods;
    }
}
