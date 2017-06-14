package ast;

import parser.FOOLBaseVisitor;
import parser.FOOLParser;
import parser.FOOLParser.*;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

// estende FOOLBaseVisitor

// src/ast contiene per ogni tipo di nodo la classe java corrispondente

// FOOLVisitorImpl contiene, per ogni tipo di nodo, un metodo che serve per visitare il contesto del nodo
// ogni metodo prende in input il contesto per il nodo
// (i context dei nodi: on FOOLParser.java)
// e restituisce un oggetto della classe del nodo del tipo corretto

public class FOOLVisitorImpl extends FOOLBaseVisitor<Node> {

	@Override
	public Node visitLetInExp(LetInExpContext ctx) {
		
		//resulting node of the right type
		ProgLetInNode res;

		//list of declarations in @res
		ArrayList<Node> declarations = new ArrayList<Node>();
		
		//visit all nodes corresponding to declarations inside the let context and store them in @declarations
		//notice that the ctx.let().dec() method returns a list, this is because of the use of * or + in the grammar
		//antlr detects this is a group and therefore returns a list
		for(DecContext dc : ctx.let().dec()){
			declarations.add( visit(dc) );
		}
		
		//visit exp context
		Node exp = visit( ctx.exp() );
		
		//build @res accordingly with the result of the visits to its content
		res = new ProgLetInNode(declarations,  exp);
		
		return res;
	}
	
	@Override
	public Node visitSingleExp(SingleExpContext ctx) {
		
		//simply return the result of the visit to the inner exp
		return visit(ctx.exp());
		
	}

	@Override
	public Node visitProgExp(ProgExpContext ctx) {
		return visit(ctx.simpleprog());
	}

	@Override
	public Node visitVarasm(VarasmContext ctx) {
		
		//visit the type
		Node typeNode = visit(ctx.vardec().type());
		
		//visit the exp
		Node expNode = visit(ctx.exp());
		
		//build the varNode
		return new VarNode(ctx.vardec().ID().getText(), typeNode, expNode);
	}

	@Override
    public Node visitVardec(VardecContext ctx) {
	    Node typeNode = visit(ctx.type());

	    return new VarDecNode(ctx.ID().getText(), typeNode);
    }

	@Override
	public Node visitLet(LetContext ctx) {

		LetNode res;

		//list of declarations in @res
		ArrayList<Node> declarations = new ArrayList<Node>();

		//visit all nodes corresponding to declarations inside the let context and store them in @declarations
		for(DecContext dc : ctx.dec()){
			declarations.add( visit(dc) );
		}

		return res = new LetNode(declarations);
	}

	@Override	//auto-generated
	public Node visitFunDeclaration(FunDeclarationContext ctx) {
		return super.visitFunDeclaration(ctx);
	}

	@Override
	public Node visitFun(FunContext ctx) {
		
		//initialize @res with the visits to the type and its ID
		FunNode res = new FunNode(ctx.ID().getText(), visit(ctx.type()));
		
		//add argument declarations
		//we are getting a shortcut here by constructing directly the ParNode
		//this could be done differently by visiting instead the VardecContext
		for(VardecContext vc : ctx.vardec())
			res.addPar( new ParNode(vc.ID().getText(), visit( vc.type() )) );
		
		//add body
		//create a list for the nested declarations
		ArrayList<Node> innerDec = new ArrayList<Node>();
		
		//check whether there are actually nested decs
		if(ctx.let() != null){
			//if there are visit each dec and add it to the @innerDec list
			for(DecContext dc : ctx.let().dec())
				innerDec.add(visit(dc));
		}
		
		//get the exp body
		Node exp = visit(ctx.exp());
		
		//add the body and the inner declarations to the function
		res.addDecBody(innerDec, exp);
		
		return res;		
		
	}
	
	@Override
	public Node visitType(TypeContext ctx) {
		if(ctx.getText().equals("int"))
			return new IntTypeNode();
		else if(ctx.getText().equals("bool"))
			return new BoolTypeNode();
		
		//this will never happen thanks to the parser
		return null;

	}
	
	@Override
	public Node visitExp(ExpContext ctx) {
		
		//this could be enhanced
		
		//check whether this is a simple or binary expression
		//notice here the necessity of having named elements in the grammar
		if(ctx.right == null){
			//it is a simple expression
			return visit( ctx.left );
		}else{
			if(ctx.term().equals(ctx.MINUS())){
				//return new MinusNode(visit(ctx.left), visit(ctx.right));
			}else if(ctx.term().equals(ctx.PLUS())){
				return new PlusNode(visit(ctx.left), visit(ctx.right));
			}
			//it is a binary expression, you should visit left and right
			return new PlusNode(visit(ctx.left), visit(ctx.right));

		}
	}
	
	@Override
	public Node visitTerm(TermContext ctx) {
		//check whether this is a simple or binary expression
		//notice here the necessity of having named elements in the grammar
		if(ctx.right == null){
			//it is a simple expression
			return visit( ctx.left );
		}else{
			//it is a binary expression, you should visit left and right
			return new MultNode(visit(ctx.left), visit(ctx.right));
		}
	}
	
	
	@Override
	public Node visitFactor(FactorContext ctx) {
		//check whether this is a simple or binary expression
		//notice here the necessity of having named elements in the grammar
		if(ctx.right == null){
			//it is a simple expression
			return visit( ctx.left );
		}else{
			//it is a binary expression, you should visit left and right
			return new EqualNode(visit(ctx.left), visit(ctx.right));
		}
	}
	
	
	@Override
	public Node visitIntVal(IntValContext ctx) {
		// notice that this method is not actually a rule but a named production #intVal
		
		//there is no need to perform a check here, the lexer ensures this text is an int
		return new IntNode(Integer.parseInt(ctx.INTEGER().getText()));
	}
	
	@Override
	public Node visitBoolVal(BoolValContext ctx) {
		
		//there is no need to perform a check here, the lexer ensures this text is a boolean
		return new BoolNode(Boolean.parseBoolean(ctx.getText())); 
	}
	
	@Override
	public Node visitBaseExp(BaseExpContext ctx) {
		
		//this is actually nothing in the sense that for the ast the parenthesis are not relevant
		//the thing is that the structure of the ast will ensure the operational order by giving
		//a larger depth (closer to the leafs) to those expressions with higher importance
		
		//this is actually the default implementation for this method in the FOOLBaseVisitor class
		//therefore it can be safely removed here
		
		return visit (ctx.exp());

	}
	
	@Override
	public Node visitIfExp(IfExpContext ctx) {
		
		//create the resulting node
		IfNode res;
		
		//visit the conditional, then the then branch, and then the else branch
		//notice once again the need of named terminals in the rule, this is because
		//we need to point to the right expression among the 3 possible ones in the rule
		
		Node condExp = visit (ctx.cond);
		
		Node thenExp = visit (ctx.thenBranch);
		
		Node elseExp = visit (ctx.elseBranch);
		
		//build the @res properly and return it
		res = new IfNode(condExp, thenExp, elseExp);
		
		return res;
	}
	
	@Override
	public Node visitVarExp(VarExpContext ctx) {
		
		//this corresponds to a variable access
		return new IdNode(ctx.ID().getText());

	}

	@Override
	public Node visitThisExp(ThisExpContext ctx) {
		return super.visitThisExp(ctx);
	}

	@Override
	public Node visitFunExp(FunExpContext ctx) {
		//this corresponds to a function invocation
		
		//declare the result
		Node res;
		
		//get the invocation arguments
		ArrayList<Node> args = new ArrayList<Node>();
		
		for(ExpContext exp : ctx.exp())
			args.add(visit(exp));
		
		//especial check for stdlib func
		//this is WRONG, THIS SHOULD BE DONE IN A DIFFERENT WAY
		//JUST IMAGINE THERE ARE 800 stdlib functions...
		if(ctx.ID().getText().equals("print"))
			res = new PrintNode(args.get(0));
		
		else
			//instantiate the invocation
			res = new CallNode(ctx.ID().getText(), args);
		
		return res;
	}

	@Override
	public Node visitMethodExp(MethodExpContext ctx) {
        String objectName;
        String methodName;
        ArrayList<Node> args = new ArrayList<>();

	    if (ctx.THIS() != null) {
	        objectName = ctx.THIS().getText();
	        methodName = ctx.ID().get(0).getText();
        } else {
            objectName = ctx.ID().get(0).getText();
            methodName = ctx.ID().get(1).getText();
        }

        for (ExpContext exp : ctx.exp())
	        args.add(visit(exp));

		return new CallMethodNode(objectName, methodName, args);
	}

	// dovevamo implementare la new
	@Override
	public Node visitNewExp(NewExpContext ctx) {
        ArrayList<Node> args = new ArrayList<>();

        for (ExpContext exp : ctx.exp())
            args.add(visit(exp));

        return new NewExpNode(ctx.ID().getText(), args);
	}

	@Override
	public Node visitClassExp(ClassExpContext ctx) {

		//list of declarations in @res
		ArrayList<Node> classes = new ArrayList<>();
		Node body;

		for (ClassdecContext cd : ctx.classdec()) {
			classes.add(visit(cd));
		}

		body = visit(ctx.simpleprog());

		return new ClassExpNode(classes, body);
	}


	@Override
	public Node visitClassdec(ClassdecContext ctx) {

		String id = ctx.ID(0).getText();
		String inherited = "";
		if (ctx.ID(1) != null)
			inherited = ctx.ID(1).getText();

		ArrayList<Node> fields = new ArrayList<>();
		ArrayList<Node> methods = new ArrayList<>();
		for (VardecContext vardec : ctx.vardec()) {
			fields.add(visit(vardec));
		}
		for (FunContext fc: ctx.fun()) {
			methods.add(visit(fc));
		}

		return new ClassNode(id, inherited, fields, methods);
	}
}
