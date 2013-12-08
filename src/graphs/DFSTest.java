package graphs;

import static org.junit.Assert.*;
import base.Colour;

import org.junit.Test;

public class DFSTest {
	
	@Test
	public void checkDFS() {
		Integer[][] graph = new Integer[][]{
				{0,1,0,0},
				{0,0,0,1},
				{0,1,0,0},
				{0,0,1,0}
		};
		Graph G = new Graph(graph);
		
        GraphNode[] nodes = G.DFS(0);
        assertEquals(nodes[0].parent, null);
        assertEquals(nodes[1].parent.value, new Integer(0));
        assertEquals(nodes[2].parent.value, new Integer(3));
        assertEquals(nodes[3].parent.value, new Integer(1));
	}
	
	@Test
	public void checkDFS_SelfPointingNode() {
		Integer[][] graph = new Integer[][]{
				{0,1,0,0},
				{0,1,0,1},
				{0,1,1,0},
				{0,0,1,0}
		};
		Graph G = new Graph(graph);
		
        GraphNode[] nodes = G.DFS(0);
        assertEquals(nodes[0].parent, null);
        assertEquals(nodes[1].parent.value, new Integer(0));
        assertEquals(nodes[2].parent.value, new Integer(3));
        assertEquals(nodes[3].parent.value, new Integer(1));
	}
	
	@Test
	public void checkDFS_UnreachableNode() {
		Integer[][] graph = new Integer[][]{
				{0,1,0,0},
				{0,1,0,1},
				{0,1,1,0},
				{0,0,1,0}
		};
		Graph G = new Graph(graph);
		
        GraphNode[] nodes = G.DFS(1);
        assertNull(nodes[0].parent);
        assertEquals(nodes[0].colour, Colour.BLACK);
        assertNull(nodes[1].parent);
        assertEquals(nodes[2].parent.value, new Integer(3));
        assertEquals(nodes[3].parent.value, new Integer(1));
	}
	
	@Test
	public void checkDFS_SingleNode() {
		Integer[][] graph = new Integer[][]{
				{1}
		};
		Graph G = new Graph(graph);
		
        GraphNode[] nodes = G.DFS(0);
        assertNull(nodes[0].parent);
        assertEquals(nodes[0].colour, Colour.BLACK);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void checkDFS_InvalidInput() {
		Integer[][] graph = new Integer[][]{
				{1, 0, 0}
		};
		new Graph(graph);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void checkDFS_StartNodeOutOfBounds() {
		Integer[][] graph = new Integer[][]{
				{1}
		};
		Graph G = new Graph(graph);
		G.DFS(1);
	}

}
