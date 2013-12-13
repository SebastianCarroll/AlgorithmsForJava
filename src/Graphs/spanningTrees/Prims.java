package Graphs.spanningTrees;

import java.util.ArrayList;

import Graphs.graphs.*;
import Misc.stacksAndQueues.PriorityQueue;;

public class Prims extends Search{
	
	PriorityQueue<GraphNode> pQ;
	
	public Prims (GraphNode[] ns, Integer[][] es, Integer sn) {
		super(ns, es, sn);
	}

	@Override
	public GraphNode[] search() {
		resetNodes();
		nodes[start].key = 0;
		pQ = new PriorityQueue<GraphNode>(nodes);
		
		return traverseGraph();
	}
	
	private GraphNode[] traverseGraph(){
		GraphNode u;
		while(!pQ.isEmpty()){
			u = pQ.extractHead();
			iterateAdjacent(u);
		}
		return pQ.toArray();
	}
	
	private void iterateAdjacent(GraphNode current){
		ArrayList<GraphNode> adj = getAdjacent(current);
		for(GraphNode next: adj){
			int weight = weight(current, next);
			if( (pQ.contains(next)) && (weight < next.key) ){
				next.parent = current;
				next.key = weight;
			}
		}
	}
	
	private int weight(GraphNode c, GraphNode n){
		int current = c.value;
		int next = n.value;
		return edges[current][next];
	}
	
	private void resetNodes(){
		for(GraphNode node : nodes){
			node.parent =null;
			node.key = Integer.MAX_VALUE;
		}
	}
	
}
