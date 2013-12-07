package graphs;

public class GraphNode {
	Integer value;
	GraphNode parent;
	GraphNode[] children;
	
	public GraphNode(Integer v){
		value = v;
		parent = null;
		children = null;
	}
	
	public GraphNode(Integer v, GraphNode p){
		
	}
	
	public GraphNode(Integer v, GraphNode p, GraphNode[] c){
		
	}
}
