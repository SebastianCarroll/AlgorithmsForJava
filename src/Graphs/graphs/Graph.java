package Graphs.graphs;

import Graphs.spanningTrees.*;

public class Graph {
	GraphNode[] nodes;
	Integer[][] edges;
	
	public Graph(Integer[][] inputEdges){
		checkEdgesAreValid(inputEdges);
		edges = inputEdges;
		mapIntegersToNodes();
	}
	
	public Graph(Integer[][] inputEdges, GraphNode[] inputNodes){
		checkEdgesAreValid(inputEdges);
		edges = inputEdges;
		nodes = inputNodes;
	}
	
	public GraphNode[] Prims(Integer start){
		Prims primsRunner = new Prims(edges, nodes, start);
		return primsRunner.search();
	}
	
	public GraphNode[] BFS(Integer start){
		BFS bfs = new BFS(nodes, edges, start);
		return bfs.search();
	}
	
	public GraphNode[] DFS(Integer start){
		DFS dfs = new DFS(nodes, edges, start);
		return dfs.search();
	}
	
	public String traverse(Integer start, TraversalOrder order){
		DFSTraverse dfst = new DFSTraverse(nodes, edges, start, order);
		dfst.search();
		return dfst.getTraversal();
	}
	
	private void mapIntegersToNodes(){
		for(int i=0; i<edges.length; i++){
			if(graphIsntInitialised()){
				initialiseGraph();
			}
			nodes[i] = new GraphNode(i, i);
		}
	}
	
	private Boolean graphIsntInitialised(){
		return nodes == null;
	}
	
	private void checkEdgesAreValid(Integer[][] inputEdges)
			throws IllegalArgumentException {
		if(inputEdges == null){
			throw new IllegalArgumentException("Edges graph must be initialised");
		}
		Integer rows = inputEdges.length;
		if(rows == 0){
			throw new IllegalArgumentException("Graph contains no edges");
		}
		
		// Loop through as Java allows each row to be a different size
		for(int i=0; i<inputEdges.length; i++){
			Integer[] row = inputEdges[i];
			if(row.length != inputEdges.length){
				throw new IllegalArgumentException(
						"When a graph is represented as an adjacency matrix that matrix must be square"
						);
			}
		}
	}
	
	private void initialiseGraph(){
		nodes = new GraphNode[edges.length];
	}
}
