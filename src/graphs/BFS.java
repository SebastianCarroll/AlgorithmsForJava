package graphs;

import base.Colour;

/**
 * Perform Breadth-First Search on a graph.
 * Only works on graphs which hold Intgers
 * 
 * @author sjc
 *
 */
public class BFS {
	GraphNode[] nodes;
	Integer[][] edges;
	Integer start;
	
	public BFS (GraphNode[] ns, Integer[][] es, Integer sn) {
		nodes = ns;
		edges = es;
		start = sn;
	}
	
	public void search(){
		initialiseStartNode();
	}
	
	private void initialiseStartNode(){
		GraphNode startnode = nodes[start];
		startnode.colour = Colour.GREY;
		startnode.d = 0;
	}
}
