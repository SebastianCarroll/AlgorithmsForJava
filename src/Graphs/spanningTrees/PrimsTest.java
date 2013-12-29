package Graphs.spanningTrees;

import static org.junit.Assert.*;

import Graphs.graphs.*;

import org.junit.Test;

import Graphs.graphs.Graph;

public class PrimsTest {

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
		
		G.Prims(0);
		
		assertNull(nodes[0].parent);
		assertEquals(nodes[1].parent.key, new Integer(0));
		assertEquals(nodes[2].parent.key, new Integer(0));
		assertEquals(nodes[3].parent.key, new Integer(1));
	}

}
