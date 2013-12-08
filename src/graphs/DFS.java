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
		for(GraphNode node : nodes){
			if(node.colour == Colour.WHITE){
				DFSVisit(node);
			}
		}
		return nodes;
	}
	
	private void DFSVisit(GraphNode node){
		time++;
		markDiscovered(node);
		exploreNeighbours(node);
		markExplored(node);
	}
	
	private void exploreNeighbours(GraphNode node){
		ArrayList<GraphNode> adj = getAdjacent(node);
		for(GraphNode neighbour: adj){
			if(node.undiscovered()){
				explore(neighbour, node);
			}
		}
	}
	
	private void markExplored(GraphNode node){
		node.colour = Colour.BLACK;
		time++;
		node.f = time;
	}
	
	private void explore(GraphNode node, GraphNode parent){
		node.parent = parent;
		DFSVisit(node);
	}
	
	private void markDiscovered(GraphNode node){
		node.d= time;
		node.colour = Colour.GREY;
	}
}
