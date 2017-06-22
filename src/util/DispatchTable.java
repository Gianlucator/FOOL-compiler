package util;

import ast.MethodNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by crist on 22/06/2017.
 */
public class DispatchTable {
    private HashMap<String, MethodNode> methods;

    public DispatchTable() {
        methods = new HashMap<>();
    }

    public void buildDispatchTable(ArrayList<MethodNode> currentMethods) {
        for (MethodNode mn: currentMethods)
            methods.put(mn.getId(), mn); //override or add new methods
    }

    public void buildDispatchTable(ArrayList<MethodNode> currentMethods, DispatchTable superclassDT) {
        if (superclassDT != null)
            this.methods = superclassDT.getMethods();   //inherit

        buildDispatchTable(currentMethods);
    }

    public HashMap<String, MethodNode> getMethods() {
        return methods;
    }

    public void setMethods(HashMap<String, MethodNode> methods) {
        this.methods = methods;
    }
}
