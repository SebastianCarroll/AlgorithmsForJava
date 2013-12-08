package graphs;

import base.Colour;
import java.util.ArrayList;

/**
 * Perform Breadth-First Search on a graph. 
 * @author sjc
 *
 */
public class DFS extends Search{
	Integer time = 0;
	
	public DFS (GraphNode[] ns, Integer[][] es, Integer sn) {
		super(ns, es, sn);
	}

	public GraphNode[] search(){
		searchFromRoot();
		searchRemaining();

		return nodes;
	}
	
	private void searchFromRoot(){
		DFSVisit(nodes[start]);
	}
	
	private void searchRemaining(){
		for(GraphNode node : nodes){
			if(node.colour == Colour.WHITE){
				DFSVisit(node);
			}
		}
	}
	
	protected void DFSVisit(GraphNode node){
		time++;
		markDiscovered(node);
		exploreNeighbours(node);
		markExplored(node);
	}
	
	protected void exploreNeighbours(GraphNode node){
		ArrayList<GraphNode> adj = getAdjacent(node);
		for(GraphNode neighbour: adj){
			if(neighbour.undiscovered()){
				explore(neighbour, node);
			}
		}
	}
	
	protected void markExplored(GraphNode node){
		node.colour = Colour.BLACK;
		time++;
		node.f = time;
	}
	
	private void explore(GraphNode node, GraphNode parent){
		node.parent = parent;
		DFSVisit(node);
	}
	
	protected void markDiscovered(GraphNode node){
		node.d= time;
		node.colour = Colour.GREY;
	}
}
