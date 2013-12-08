package graphs;

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
}
