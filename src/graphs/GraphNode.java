package graphs;

import base.Colour;

public class GraphNode {
	Integer value;
	Colour colour;
	Integer d;
	GraphNode parent;
	
	public GraphNode(Integer v){
		value = v;
		parent = null;
	}
	
	public GraphNode(Integer v, GraphNode p){
		value = v;
		parent = p;
	}
}
