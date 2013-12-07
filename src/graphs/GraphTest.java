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
		GraphNode[][] input = G.matrixGraph;
		for(int i=0; i<input.length; i++){
			GraphNode[] row = input[i];
			for(int j=0; j<row.length; j++){
				GraphNode curnode = input[i][j];
				assertEquals(curnode.value, graph[i][j]);
				assertNotNull(curnode.d);
				assertEquals(curnode.colour, Colour.WHITE);
			}
		}
	}

}
