package util;

import ast.Node;

/**
 * Created by Stefano on 03/07/2017.
 */
public class DTEntry {

    private Node node;
    private int offset;

    public DTEntry(Node node) {
        this.node = node;
        offset = -1;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
