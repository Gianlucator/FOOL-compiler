package util;

import java.util.ArrayList;

/**
 * Created by crist on 26/06/2017.
 */
public class TypeTreeNode {
    private String currentType;
    private TypeTreeNode parentSuperType;
    private ArrayList<TypeTreeNode> superTypes; // contains all ancestors ==> MAXIMUM SPEED, FULL MOMENTUM, HIGH EFFICIENCY
    private ArrayList<TypeTreeNode> subTypes;

    public TypeTreeNode(String currentType, TypeTreeNode parentSuperType) {
        this.currentType = currentType;
        this.parentSuperType = parentSuperType;
        this.superTypes = new ArrayList<>();

        this.superTypes.add(parentSuperType);
        if (parentSuperType != null)
            this.superTypes.addAll(parentSuperType.superTypes);

        this.subTypes = new ArrayList<>();
    }

    public ArrayList<TypeTreeNode> getSuperTypes() {
        return superTypes;
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
}
