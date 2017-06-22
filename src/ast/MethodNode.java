package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * Created by crist on 22/06/2017.
 */
public class MethodNode extends FunNode {

    // TODO: sistemare sta roba del self quando ci servirà vedremo come fare sta roba del self che è da fare quando servirà
    Node self;

    public MethodNode(String i, Node t) {
        super(i, t);
    }
}
