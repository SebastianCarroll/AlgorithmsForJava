package graphs;

import base.Colour;

public class GraphNode {
	Colour colour;
	Integer d;
	GraphNode parent;
	Integer value;
	
	public GraphNode(Integer v){
		value = v;
		colour = Colour.WHITE;
		d = Integer.MAX_VALUE;
		parent = null;
	}
}
