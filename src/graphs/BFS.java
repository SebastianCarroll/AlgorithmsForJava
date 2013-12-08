package graphs;

import base.Colour;
import stacksAndQueues.Queue;
import java.util.ArrayList;

/**
 * Perform Breadth-First Search on a graph. 
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
	
	public GraphNode[] search(){
		initialiseStartNode();
		Queue<GraphNode> Q = new Queue<GraphNode>(nodes.length);
		Q.enqueue(nodes[start]);
		while(!Q.isEmpty()){
			GraphNode current = Q.dequeue();
			searchAdjacentAndAddToQueue(current, Q);
		}
		return nodes;
	}
	
	private void searchAdjacentAndAddToQueue(GraphNode current, Queue<GraphNode> Q){
		ArrayList<GraphNode> adj = getAdjacent(current);
		exploreNodes(adj, current, Q);
		current.colour = Colour.BLACK;
	}
	
	private void exploreNodes(ArrayList<GraphNode> adj, GraphNode parent, Queue<GraphNode> Q){
		for(GraphNode current : adj){
			if(current.colour == Colour.WHITE){
				visitNode(current, parent);
				Q.enqueue(current);
			}
		}
	}
	
	private void visitNode(GraphNode current, GraphNode parent){
		current.colour = Colour.GREY;
		current.d = parent.d +1;
		current.parent = parent;		
	}
	
	private ArrayList<GraphNode> getAdjacent(GraphNode current){
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
	
	private void initialiseStartNode(){
		GraphNode startnode = nodes[start];
		startnode.colour = Colour.GREY;
		startnode.d = 0;
	}
}
