package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ast.Node;
import ast.STentry;

public class Environment {
	
	//THESE VARIABLES SHOULDN'T BE PUBLIC
	//THIS CAN BE DONE MUCH BETTER
	
	public ArrayList<HashMap<String,STentry>>  symTable = new ArrayList<HashMap<String,STentry>>();
	public HashMap<String, CTentry> classTable = new HashMap<String, CTentry>();
	public HashMap<String, List<Node>> dispatchTable = new HashMap<String, List<Node>>();
	public int nestingLevel = -1;
	public int offset = 0;
	//livello ambiente con dichiarazioni piu' esterno � 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle � symTable.get(nestingLevel)
	
	
	
}
