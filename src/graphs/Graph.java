package graphs;

import base.Colour;

public class Graph {
	GraphNode[][] matrixGraph;
	StartNode startnode;
	
	public Graph(Integer[][] input, StartNode sn){
		mapIntegersToNodes(input);
		initialiseStartNode(sn);
	}
	
	private void initialiseStartNode(StartNode sn){
		startnode = sn;
		GraphNode start = matrixGraph[sn.row][sn.col];
		start.colour = Colour.GREY;
		start.d = 0;
	}
	
	private void mapIntegersToNodes(Integer[][] input){
		for(int i=0; i<input.length; i++){
			Integer[] row = input[i];
			for(int j=0; j<row.length; j++){
				if(graphIsntInitialised()){
					initialiseGraph(row.length, input.length);
				}
				matrixGraph[i][j] = new GraphNode(input[i][j]);
			}
		}
	}
	
	private Boolean graphIsntInitialised(){
		return matrixGraph == null;
	}
	
	private void initialiseGraph(int rows, int cols){
		matrixGraph = new GraphNode[rows][cols];
	}
}
