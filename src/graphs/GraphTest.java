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
	public void checkStartNodeInitialised() {
		Integer[][] graph = new Integer[][]{
				{0,1,0,0},
				{0,0,0,1},
				{0,1,0,0},
				{0,0,1,0}
		};
		Graph G = new Graph(graph);
		
		G.BFS(0);
		GraphNode start = G.nodes[0];
		assertEquals(start.colour, Colour.GREY);
		assertNull(start.parent);
		assertEquals(start.d, new Integer(0));
	}

}
