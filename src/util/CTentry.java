package util;

import ast.ClassNode;

/**
 * Created by Gianluca on 14/06/2017.
 */
public class CTentry {

    private ClassNode clnode;

    private ClassNode superClass;

    private int Offset;

    public CTentry(ClassNode clnode) {
        this.clnode = clnode;
    }

    public void setSuperClass(ClassNode superClass) {
        this.superClass = superClass;
    }

    public ClassNode getClassNode() {
        return clnode;
    }

    public ClassNode getSuperClass() {
        return superClass;
    }

}
