package graphs;

import base.Colour;

public class GraphNode {
	Colour colour;
	Integer d;
	GraphNode parent;
	
	public GraphNode(){
		colour = Colour.WHITE;
		d = Integer.MAX_VALUE;
		parent = null;
	}
}
