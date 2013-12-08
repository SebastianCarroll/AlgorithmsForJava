package graphs;

import java.util.ArrayList;

public abstract class Search {
	GraphNode[] nodes;
	Integer[][] edges;
	Integer start;
	
	protected Search(GraphNode[] ns, Integer[][] es, Integer sn) {
		nodes = ns;
		edges = es;
		start = sn;
		checkNodesContainsStartNode();
	}
	
	public abstract GraphNode[] search();
	
	protected void checkNodesContainsStartNode() 
			throws IllegalArgumentException{
		if(start >= nodes.length){
			throw new IllegalArgumentException(
					"Specified Start node is not in available nodes");
		}
	}
	
	protected ArrayList<GraphNode> getAdjacent(GraphNode current){
		ArrayList<GraphNode> adj = new ArrayList<GraphNode>();
		Integer[] edgesFromCurrent = edges[current.value];
		for(int i=0; i<edgesFromCurrent.length; i++){
			Integer edge = edgesFromCurrent[i];
			if(edge == 1){
				adj.add(nodes[i]);
			}
		}
		return adj;
	}
}
