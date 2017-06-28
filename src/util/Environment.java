package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ast.Node;
import ast.STentry;

public class Environment {

	private ArrayList<HashMap<String, STentry>>  symTable = new ArrayList<>();
	private HashMap<String, DispatchTable> dispatchTables = new HashMap<>();
	private int nestingLevel = -1;
	private int offset = 0;
	private String self_type = "";	//Tipo della dichiarazione di classe in cui ci troviamo

	public String getSelf_type() {
		return self_type;
	}

	public void setSelf_type(String self_type) {
		this.self_type = self_type;
	}

	private final int GLOBAL_SCOPE = 0;

	public ArrayList<HashMap<String, STentry>> getSymTable() {
		return symTable;
	}

	public void setSymTable(ArrayList<HashMap<String, STentry>> symTable) {
		this.symTable = symTable;
	}

	public HashMap<String, DispatchTable> getDispatchTables() {
		return dispatchTables;
	}

	public void setDispatchTables(HashMap<String, DispatchTable> dispatchTables) {
		this.dispatchTables = dispatchTables;
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

	//livello ambiente con dichiarazioni piu' esterno � 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle � symTable.get(nestingLevel)
	
	
	
}

// classe -> lista di metodi con offset (String, (String, Int))