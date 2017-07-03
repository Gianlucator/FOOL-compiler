package util;

import ast.FunNode;
import ast.Node;
import ast.VarDecNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by crist on 22/06/2017.
 */
public class DispatchTable {
    private HashMap<String, DTEntry> entries;

    public DispatchTable() {
        entries = new HashMap<>();
    }

    public void buildDispatchTable(ArrayList<Node> current) {
        for (Node c: current)
            if(c instanceof FunNode)
                entries.put(((FunNode) c).getId(), new DTEntry(c));
            else if(c instanceof VarDecNode)
                entries.put(((VarDecNode) c).getId(), new DTEntry(c));
    }

    public void buildDispatchTable(ArrayList<Node> currentMethods, DispatchTable superclassDT) {
        if (superclassDT != null)
            this.entries = superclassDT.getEntries();   //inherit
        buildDispatchTable(currentMethods);
    }

    public HashMap<String, DTEntry> getEntries() {
        return entries;
    }

    public String toString() {
        return entries.toString();
    }

}
