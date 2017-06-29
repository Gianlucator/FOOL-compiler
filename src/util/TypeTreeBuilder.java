package util;

import ast.ClassNode;
import ast.Node;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Stef@no on 29/06/2017.
 */
public class TypeTreeBuilder {
    private static ArrayList<String> nodeNames;

    public TypeTreeBuilder() {
        nodeNames = new ArrayList<>();
        nodeNames.add("");
    }

    public static TypeTreeNode buildTypeTree(ArrayList<Node> cls) {
        ArrayList<Node> classes = new ArrayList<>();
        classes.addAll(cls);
        TypeTreeNode rootNode = new TypeTreeNode("", null);
        nodeNames = new ArrayList<>();
        nodeNames.add("");

        int lastSize = -1;
        while (classes.size() > 0) {
            for (Iterator<Node> it = classes.iterator(); it.hasNext();) {
                ClassNode cl = ((ClassNode) it.next());
                String superClass = cl.getSuperclass();
                String className = cl.getId();


                if (nodeNames.contains(superClass)) {
                    nodeNames.add(className);

                    TypeTreeNode parentNode = rootNode.findNode(superClass);
                    parentNode.addSubtype(new TypeTreeNode(className, parentNode));

                    it.remove();
                }
            }

            if (lastSize == classes.size())
                return null;
            else
                lastSize = classes.size();
        }
        return rootNode;
    }
}
