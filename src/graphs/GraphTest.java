package graphs;

import static org.junit.Assert.*;

import org.junit.Test;
import base.Colour;

public class GraphTest {

	@Test
	public void testConversion() {
		Integer[][] graph = new Integer[][]{
				{0,1,0,0},
				{0,0,0,1},
				{0,1,0,0},
				{0,0,1,0}
		};
		Graph G = new Graph(graph);
		GraphNode[] input = G.nodes;
		
		for(int i=0; i<input.length; i++){
			GraphNode curnode = input[i];
			assertNotNull(curnode.d);
			assertNull(curnode.parent);
			assertEquals(curnode.colour, Colour.WHITE);
		}
	}
	
	@Test
	public void checkBFS() {
		Integer[][] graph = new Integer[][]{
				{0,1,0,0},
				{0,0,0,1},
				{0,1,0,0},
				{0,0,1,0}
		};
		Graph G = new Graph(graph);
		
        GraphNode[] nodes = G.BFS(0);
        assertEquals(nodes[0].parent, null);
        assertEquals(nodes[1].parent.value, new Integer(0));
        assertEquals(nodes[2].parent.value, new Integer(3));
        assertEquals(nodes[3].parent.value, new Integer(1));
	}
	
	@Test
	public void checkBFS_SelfPointingNode() {
		Integer[][] graph = new Integer[][]{
				{0,1,0,0},
				{0,1,0,1},
				{0,1,1,0},
				{0,0,1,0}
		};
		Graph G = new Graph(graph);
		
        GraphNode[] nodes = G.BFS(0);
        assertEquals(nodes[0].parent, null);
        assertEquals(nodes[1].parent.value, new Integer(0));
        assertEquals(nodes[2].parent.value, new Integer(3));
        assertEquals(nodes[3].parent.value, new Integer(1));
	}
	
	@Test
	public void checkBFS_UnreachableNode() {
		Integer[][] graph = new Integer[][]{
				{0,1,0,0},
				{0,1,0,1},
				{0,1,1,0},
				{0,0,1,0}
		};
		Graph G = new Graph(graph);
		
        GraphNode[] nodes = G.BFS(1);
        assertNull(nodes[0].parent);
        assertEquals(nodes[0].colour, Colour.WHITE);
        assertNull(nodes[1].parent);
        assertEquals(nodes[2].parent.value, new Integer(3));
        assertEquals(nodes[3].parent.value, new Integer(1));
	}
	
	@Test
	public void checkBFS_SingleNode() {
		Integer[][] graph = new Integer[][]{
				{1}
		};
		Graph G = new Graph(graph);
		
        GraphNode[] nodes = G.BFS(0);
        assertNull(nodes[0].parent);
        assertEquals(nodes[0].colour, Colour.BLACK);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void checkBFS_InvalidInput() {
		Integer[][] graph = new Integer[][]{
				{1, 0, 0}
		};
		new Graph(graph);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void checkBFS_StartNodeOutOfBounds() {
		Integer[][] graph = new Integer[][]{
				{1}
		};
		Graph G = new Graph(graph);
		G.BFS(1);
	}

}
