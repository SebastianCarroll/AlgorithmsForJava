package Graphs.graphs;

public class DFSTraverse extends DFS {
	
	String traversal = "";
	TraversalOrder order;

	public DFSTraverse(GraphNode[] ns, Integer[][] es, Integer sn, TraversalOrder o) {
		super(ns, es, sn);
		order = o;
	}
	
	@Override
	protected void DFSVisit(GraphNode node){
		time++;
		addToTraversal(TraversalOrder.Preorder, node);
		markDiscovered(node);
		exploreNeighbours(node);
		markExplored(node);
		addToTraversal(TraversalOrder.Postorder, node);
	}
	
	private void addToTraversal(TraversalOrder expected, GraphNode node){
		if(expected == order){
			traversal += node.stringify();
		}
	}
	
	public String getTraversal(){
		return traversal;
	}
	

}
