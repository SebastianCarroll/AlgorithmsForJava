package graphs;

import base.Colour;

public class GraphNode {
	Integer value;
	Colour colour;
	GraphNode parent;
	GraphNode[] children;
	
	public GraphNode(Integer v){
		value = v;
		parent = null;
		children = null;
	}
	
	public GraphNode(Integer v, GraphNode p){
		value = v;
		parent = p;
		children = null;
	}
	
	public GraphNode(Integer v, GraphNode p, GraphNode[] c){
		value = v;
		parent = p;
		children = c;
	}
}
