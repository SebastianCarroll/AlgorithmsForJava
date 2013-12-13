package Graphs.graphs;

import Misc.base.Colour;

public class GraphNode implements Comparable<GraphNode> {
	public Colour colour;
	public Integer d;
	public Integer f;
	public GraphNode parent;
	public Integer key;
	public Integer value;
	
	public GraphNode(Integer k, Integer v){
		key = k;
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

	@Override
	public int compareTo(GraphNode node) {
		return key.compareTo(node.key);
	}
}
