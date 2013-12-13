package Misc.stacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;
import Graphs.graphs.GraphNode;

public class PriorityQueueTest {

	@Test
	public void testInsertAndExtract() {
		String[] elems = new String[]{"Bat", "Tat", "Mat", "Aat"};
		PriorityQueue<String> pQ = new PriorityQueue<>(elems);
		String head = pQ.extractHead();
		assertEquals("Aat", head);
	}
	
	@Test
	public void testInsertAndExtractWithGraphNode() {
		GraphNode[] elems = new GraphNode[4];
		
		for(int i=0; i<elems.length; i++){
			elems[i] = new GraphNode(10-i, 10-i);
		}
		PriorityQueue<GraphNode> pQ = new PriorityQueue<>(elems);
		
		assertEquals("(7)",  pQ.extractHead().stringify());
		pQ.insert(new GraphNode(11, 11));
		assertEquals("(8)",  pQ.extractHead().stringify());
		assertEquals("(9)",  pQ.extractHead().stringify());
		assertEquals("(10)",  pQ.extractHead().stringify());
		assertEquals("(11)",  pQ.extractHead().stringify());
	}

}
