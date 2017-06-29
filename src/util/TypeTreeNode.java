package util;

import java.util.HashSet;

/**
 * Created by crist on 26/06/2017.
 */
public class TypeTreeNode {
    private String currentType;
    private TypeTreeNode parentSuperType;
    private HashSet<TypeTreeNode> superTypes; // contains all ancestors ==> MAXIMUM SPEED, FULL MOMENTUM, HIGH EFFICIENCY
    private HashSet<TypeTreeNode> subTypes;

    public TypeTreeNode(String currentType, TypeTreeNode parentSuperType) {
        this.currentType = currentType;
        this.parentSuperType = parentSuperType;
        this.superTypes = new HashSet<>();

        this.superTypes.add(parentSuperType);
        if (parentSuperType != null)
            this.superTypes.addAll(parentSuperType.superTypes);

        this.subTypes = new HashSet<>();
    }

    public HashSet<TypeTreeNode> getSuperTypes() {
        return superTypes;
    }

    public void addSubtype(TypeTreeNode subtype) {
        subTypes.add(subtype);
    }

    public TypeTreeNode findNode(String classId) {
        if (currentType.equals(classId))
            return this;
        else {
            for (TypeTreeNode st: subTypes) {
                TypeTreeNode foundNode = st.findNode(classId);
                if (foundNode != null)
                    return foundNode;
            }
        }

        return null;
    }

    public String toString() {
        return currentType + ": " + subTypes.toString() + "\n";
    }

    /*
    public boolean updateTypeTree() {
        // check for cycle
        if (superTypes.contains(this))
            return false;

        for (TypeTreeNode st: subTypes) {
            st.superTypes.addAll(superTypes);
            st.updateTypeTree();
        }

        return true;
    }
    */
}
