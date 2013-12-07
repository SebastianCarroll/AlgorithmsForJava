package graphs;

import base.Colour;

public class GraphNode {
	Integer value;
	Colour colour;
	Integer d;
	GraphNode parent;
	
	public GraphNode(Integer v){
		value = v;
		colour = Colour.WHITE;
		d = Integer.MAX_VALUE;
		parent = null;
	}
}
