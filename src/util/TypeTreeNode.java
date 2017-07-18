package util;

import ast.ClassIdNode;
import ast.ClassNode;
import ast.Node;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by crist on 26/06/2017.
 */
public class TypeTreeNode {
    private String currentType;
    private ClassNode currentClassNode;
    private TypeTreeNode parentSuperType;
    private ArrayList<TypeTreeNode> superTypes; // contains all ancestors ==> MAXIMUM SPEED, FULL MOMENTUM, HIGH EFFICIENCY
    private ArrayList<TypeTreeNode> subTypes;


    public ArrayList<TypeTreeNode> getSubTypes() {
        return subTypes;
    }

    public ArrayList<TypeTreeNode> getSuperTypes(){
        return superTypes;
    }

    public ClassNode getCurrentClassNode() {
        return currentClassNode;
    }

    public TypeTreeNode(String currentType, ClassNode currentClassNode, TypeTreeNode parentSuperType) {
        this.currentType = currentType;
        this.currentClassNode = currentClassNode;
        this.parentSuperType = parentSuperType;
        this.superTypes = new ArrayList<>();

        this.superTypes.add(parentSuperType);
        if (parentSuperType != null)
            this.superTypes.addAll(parentSuperType.superTypes);

        this.subTypes = new ArrayList<>();
    }

    // this is sub of sup if this = sup or if sup is its supertype
    public boolean isSubtype(TypeTreeNode sup) {
        return this.equals(sup) || this.superTypes.contains(sup);
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

    public ArrayList<Node> buildWellOrderedClassList() {
        ArrayList<Node> classNodes = new ArrayList<>();
        return buildWellOrderedClassList(classNodes);
    }

    private ArrayList<Node> buildWellOrderedClassList(ArrayList<Node> classNodes) {

        for (TypeTreeNode st: subTypes) {
            st.buildWellOrderedClassList(classNodes);
        }

        if (currentClassNode != null)
            classNodes.add(0, currentClassNode);

        return classNodes;
    }

    public void addSubtype(TypeTreeNode subtype) {
        subTypes.add(subtype);
    }

    public String toString() {
        return currentType;
    }

    public String getCurrentType() {
        return currentType;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof TypeTreeNode)
            if (currentType.equals(((TypeTreeNode) o).getCurrentType()))
                return true;
        return false;
    }


}
