package Graphs.graphs;

import Misc.base.Colour;

public class GraphNode {
	Colour colour;
	Integer d;
	Integer f;
	GraphNode parent;
	Integer value;
	
	public GraphNode(Integer v){
		value = v;
		colour = Colour.WHITE;
		d = Integer.MAX_VALUE;
		f = Integer.MAX_VALUE;
		parent = null;
	}
	
	public Boolean undiscovered(){
		return colour == Colour.WHITE;
	}
	
	public String stringify(){
		return "(" + value + ")";
	}
}
