package util;

import java.util.ArrayList;
import java.util.HashMap;

import ast.ClassNode;
import ast.STentry;
import org.stringtemplate.v4.ST;

public class Environment {

	private ArrayList<HashMap<String, STentry>> symTable = new ArrayList<>();
	private ArrayList<HashMap<String, String>> objectEnvironment = new ArrayList<>();
	private int nestingLevel = -1;
	private int offset = 0;
	private final int GLOBAL_SCOPE = 0;
	private String classEnvironment = "";
	//private String self_type = "";	//Tipo della dichiarazione di classe in cui ci troviamo


	public ClassNode getClassLayout(String className){
		ClassNode cn = null;
		try {
			cn = (ClassNode) symTable.get(GLOBAL_SCOPE).get(className).getType();
		} catch (Exception e){
			System.err.println("Could not cast to ClassNode!");
		}
		return cn;
	}

	public HashMap<String, String> addObjectEnvHMtoNL(){
		HashMap<String, String> hm = new HashMap<>();
		objectEnvironment.add(nestingLevel, hm);
		return hm;
	}

	public HashMap<String, STentry> addSymTableHMtoNL(){
		HashMap<String, STentry> hm = new HashMap<>();
		symTable.add(nestingLevel, hm);
		return hm;
	}

	public String getClassEnvironment() {
		return classEnvironment;
	}

	public void setClassEnvironment(String classEnvironment) {
		this.classEnvironment = classEnvironment;
	}

	public ArrayList<HashMap<String, String>> getObjectEnvironment() {
		return objectEnvironment;
	}

	public ArrayList<HashMap<String, STentry>> getSymTable() {
		return symTable;
	}

	public void setSymTable(ArrayList<HashMap<String, STentry>> symTable) {
		this.symTable = symTable;
	}

	public int getNestingLevel() {
		return nestingLevel;
	}

	public void setNestingLevel(int nestingLevel) {
		this.nestingLevel = nestingLevel;
	}

	public void incNestingLevel(){
		this.nestingLevel++;
	}

	public void decNestingLevel(){
		this.nestingLevel--;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void incOffset(){
		this.offset++;
	}

	public void decOffset(){
		this.offset--;
	}

	public int getGLOBAL_SCOPE() {
		return GLOBAL_SCOPE;
	}

	public boolean isClassDeclared(String className) {
		return symTable.get(GLOBAL_SCOPE).get(className) != null;
	}

	public STentry insertClassEntry(String s, STentry e) {
		return symTable.get(GLOBAL_SCOPE).put(s, e);
	}

	public void printNestingLevel() {
		System.out.println(nestingLevel);
	}

	//livello ambiente con dichiarazioni piu' esterno � 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle � symTable.get(nestingLevel)
}

// classe -> lista di metodi con offset (String, (String, Int))