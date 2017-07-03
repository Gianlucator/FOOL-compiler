package util;

import ast.ClassIdNode;
import ast.FunNode;
import ast.Node;
import ast.VarDecNode;
import lib.FOOLlib;

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
        DTEntry dtEntry;
        for (Node c: current)
            // metodi
            if(c instanceof FunNode) {
                // se dtEntry è diverso da null c'è override
                dtEntry = entries.put(((FunNode) c).getId(), new DTEntry(c));
                if(dtEntry != null){

                    // deve valere la controvarianza per i tipi dei parametri formali
                    ArrayList<Node> listaPar = ((FunNode) c).getArrowType().getParList();
                    for (int i = 0; i < listaPar.size(); i++) {
                        // se il parametro è un oggetto
                        if ((listaPar.get(i)).typeCheck() instanceof ClassIdNode &&
                                ((FunNode) dtEntry.getNode()).getArrowType().getParList().get(i) instanceof ClassIdNode) {
                            if (!(FOOLlib.isSubtype( ((ClassIdNode)(listaPar.get(i))).getClassId(),
                                ((ClassIdNode)((FunNode) dtEntry.getNode()).getArrowType().getParList().get(i)).getClassId()))) {
                                System.out.println("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + ((FunNode) c).getId());
                                System.exit(0);
                            }
                        } else {  // se il parametro è int o bool
                            if (!(FOOLlib.isSubtype((listaPar.get(i)),
                                ((FunNode) dtEntry.getNode()).getArrowType().getParList().get(i)))) {
                                System.out.println("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + ((FunNode) c).getId());
                                System.exit(0);
                            }
                        }
                    }


                    // deve valere la covarianza per il tipo di ritorno
                    if ( ((FunNode) c).getArrowType().getRet().typeCheck() instanceof ClassIdNode) {
                        if (!(FOOLlib.isSubtype( ((ClassIdNode)((FunNode) c).getArrowType().getRet()).getClassId(),
                            ((ClassIdNode)((FunNode) dtEntry.getNode()).getArrowType().getRet()).getClassId()))) {
                            System.out.println("Wrong return type");
                            System.exit(0);
                        }
                    } else {
                        if (!(FOOLlib.isSubtype( ((FunNode) c).getArrowType().getRet(),
                            ((FunNode) dtEntry.getNode()).getArrowType().getRet()))) {
                            System.out.println("Wrong return type");
                            System.exit(0);
                        }
                    }
                }
            }
                //entries.put(((FunNode) c).getId(), new DTEntry(c));
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
