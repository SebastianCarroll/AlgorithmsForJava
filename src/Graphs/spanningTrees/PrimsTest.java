package Graphs.spanningTrees;

import static org.junit.Assert.*;

import Graphs.graphs.*;

import org.junit.Test;

import Graphs.graphs.Graph;

public class PrimsTest {

	@Test
	public void testSearch() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrims() {
		Integer[][] edges = new Integer[][]{
				{0,1,2,3},
				{0,0,0,1},
				{0,0,0,0},
				{0,0,0,0}
		};
		
		GraphNode[] nodes = new GraphNode[]{
				new GraphNode(0, 0),
				new GraphNode(1, 1),
				new GraphNode(2, 2),
				new GraphNode(3, 3)
		};
		
		Graph G = new Graph(edges, nodes);
		
		GraphNode[] mst = G.Prims(0);
		
		assertNull(mst[0].parent);
		assertEquals(mst[1].parent.key, new Integer(0));
		assertEquals(mst[2].parent.key, new Integer(0));
		assertEquals(mst[3].parent.key, new Integer(1));
	}

}
