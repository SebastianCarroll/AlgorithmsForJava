package graphs;

import base.Colour;

public class Graph {
	GraphNode[] nodes;
	Integer[][] edges;
	Integer startnode;
	
	public Graph(Integer[][] inputEdges, Integer sn){
		mapIntegersToNodes(inputEdges);
		initialiseStartNode(sn);
	}
	
	private void initialiseStartNode(Integer sn){
		startnode = sn;
		GraphNode start = nodes[startnode];
		start.colour = Colour.GREY;
		start.d = 0;
	}
	
	private void mapIntegersToNodes(Integer[][] input){
		for(int i=0; i<input.length; i++){
			Integer[] row = input[i];
			for(int j=0; j<row.length; j++){
				if(graphIsntInitialised()){
					failIfMatrixIsntSquare(input.length, row.length);
					initialiseGraph(input.length);
				}
				nodes[i] = new GraphNode();
			}
		}
	}
	
	private Boolean graphIsntInitialised(){
		return nodes == null;
	}
	
	private void failIfMatrixIsntSquare(int rows, int cols) throws IllegalArgumentException {
		if(rows != cols){
			throw new IllegalArgumentException(
					"When a graph is represented as an adjacency matrix that matrix must be square"
					);
		}
	}
	
	private void initialiseGraph(int rows){
		nodes = new GraphNode[rows];
	}
}
