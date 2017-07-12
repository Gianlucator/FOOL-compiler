package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;
import util.TypeTreeBuilder;
import util.TypeTreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Stefano on 06/06/2017.
 */
public class ClassExpNode implements Node {

    private ArrayList<Node> classes;
    private Node body;

    public ClassExpNode(ArrayList<Node> classes, Node body) {
        this.classes = classes;
        this.body = body;
    }

    @Override
    public String toPrint(String s) {
        String declstr="";
        for (Node c : classes)
            declstr += c.toPrint(s+"  ");
        return s+"ClassExp\n" + declstr + body.toPrint(s+"  ") ;
    }

    @Override
    public Node typeCheck() {
        // si ciclano le classi dichiarate
        for (Node cls: classes)
            // si chiama su di essere il typecheck ricorsivamente
            cls.typeCheck();

        // typecheck sul body del programma (= sul resto del programma)
        return body.typeCheck();
    }

    @Override
    public String codeGeneration() {
        String code = "";

        // si ciclano le classi dichiarate
        for (Node cls: classes)
            // si chiama su di essere la cgen ricorsivamente
            code += cls.codeGeneration();

        // cgen sul body del programma (= sul resto del programma)
        code += body.codeGeneration();

        code += "halt\n";

        return code;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        // in questo momento il nestingLevel è = -1

        // on scope entry si incrementa il nestingLevel a 0
        // tutte le dichiarazioni di classe sono a nestingLevel 0, cioè a global scope.
        env.incNestingLevel(); // 0

        // si aggiunge un hashmap vuoto
        // per il nl 0 alla symbol table
        HashMap<String, STentry> hm = env.addSymTableHMtoNL();

        env.addObjectEnvHMtoNL();

        // declare resulting list
        ArrayList<SemanticError> res = new ArrayList<>();

        // prima di iniziare a fare il controllo semantico...
        // creazione albero di gerarchia tra classi
        FOOLlib.setRoot(TypeTreeBuilder.buildTypeTree(classes));

        if (FOOLlib.getRoot() == null) {
            // non ci possono essere cicli della dichiarazione di classi
            res.add(new SemanticError("Cycle(s) between class definitions."));
        } else {
            // vengono ordinate le classi
            classes = FOOLlib.getRoot().buildWellOrderedClassList();
        }

        // ..ora si può cominciare a fare il controllo semantico sulle dichiarazioni delle classi
        // gli errori possono essere:
        // superclasse non dichiarata
        // classe dichiarata più volte

        // add all class names to the environment to allow subclassing before declaration

        // si ciclano le classi dichiarate DOPO essere state ordinate
        for (Node cls : classes) {
            // nome classe
            // nota: ogni classe è un class node, il classnode contiene il nome della classe e il nome della superclasse
            String clsName = ((ClassNode) cls).getId();

            // node superclasse della classe
            String supClsName = ((ClassNode) cls).getSuperclass();

            // se la classe estende una classe ( allora !supClsName.equals("")) che però non è stata dichiarata
            if (!env.isClassDeclared(supClsName) && !supClsName.equals("")) {
                // si lancia un errore semantico
                res.add(new SemanticError("Superclass " + supClsName + " of " + clsName + " not declared."));
            }

            // si crea una nuova STentry da mettere nel hashmap corrispondente allo scope giusto (il global scope)
            // nota che ogni stentry contiene:
            // nestinglevel, classnode, offset
            // nome classe e stentry vanno poi nel hashmap
            STentry sTentry = new STentry(env.getGLOBAL_SCOPE(), cls, env.getOffset());

            // si mette <nomeclasse stentry> nell'hashmap del global scope (nesting level 0)
            if (env.insertClassEntry(clsName, sTentry) != null) {
                // se c'è già allora la classe con quel nome è gia stata dichiarata e si lancia errore semantico
                res.add(new SemanticError("Multiple declarations of class " + clsName));
            } else {
                System.out.println("ok"+ clsName);
            }
        }

        // per ogni classe si richiama ricorsivamente il controllo semantico
        for (Node cl : classes)
            res.addAll(cl.checkSemantics(env));

        //Esco dallo scope delle dichiarazioni di classe
        env.setClassEnvironment("");

        // si chiama il checksemantics ricorsivamente dul body del programma
        res.addAll(body.checkSemantics(env));

        //Non rimuovo la symbol table generata da questo nodo, dato che servirà nel resto del programma.
        env.getObjectEnvironment().remove(env.getNestingLevel());

        env.decNestingLevel();

        return res;
    }
}
