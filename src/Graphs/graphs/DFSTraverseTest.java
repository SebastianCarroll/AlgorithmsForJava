package Graphs.graphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class DFSTraverseTest {
	
	@Test
	public void testPreorder() {
		Integer[][] graph = new Integer[][]{
				{0,0,0,0},
				{1,0,1,1},
				{0,0,0,0},
				{0,0,1,0}
		};
		Graph G = new Graph(graph);
		
        String traversal = G.traverse(1, TraversalOrder.Preorder);
        assertEquals("(1)(0)(2)(3)", traversal);
	}
	
	@Test
	public void testPostorder() {
		Integer[][] graph = new Integer[][]{
				{0,0,0,0},
				{1,0,1,1},
				{0,0,0,0},
				{0,0,1,0}
		};
		Graph G = new Graph(graph);
		
        String traversal = G.traverse(1, TraversalOrder.Postorder);
        assertEquals("(0)(2)(3)(1)", traversal);
	}
	
	@Test
	public void testPostorderUndirected() {
		Integer[][] graph = new Integer[][]{
				{0,1,0,1},
				{1,0,1,1},
				{0,1,0,0},
				{1,1,0,0}
		};
		Graph G = new Graph(graph);
		
        String traversal = G.traverse(1, TraversalOrder.Postorder);
        assertEquals("(3)(0)(2)(1)", traversal);
	}

}
