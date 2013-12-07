package graphs;

public class Graph {
	GraphNode[] nodes;
	Integer[][] edges;
	
	public Graph(Integer[][] inputEdges){
		checkEdgesAreValid(inputEdges);
		mapIntegersToNodes(inputEdges);
	}
	
	public void BFS(Integer start){
		BFS bfs = new BFS(nodes, edges, start);
		bfs.search();
	}
	
	private void mapIntegersToNodes(Integer[][] input){
		for(int i=0; i<input.length; i++){
			if(graphIsntInitialised()){
				initialiseGraph(input.length);
			}
			nodes[i] = new GraphNode(i);
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
	
	private void initialiseGraph(int rows){
		nodes = new GraphNode[rows];
	}
}
