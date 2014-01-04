package Misc.heap;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxHeapTest {

	@Test
	public void TestInitialMaxHeapConstructionDoesntFail() {
		String[] input = new String[]{"Rat", "Bat", "Tat"};
		
		new MaxHeap<String>(input);
	}
	
	@Test
	public void TestInitialMaxHeapConstructionIsCorrect() {
		String[] input = new String[]{"Rat", "Bat", "Tat"};
		
		String[] expected = new String[]{"Tat", "Rat", "Bat"};
		
		MaxHeap<String> H = new MaxHeap<String>(input);
		
		assertEquals(H.extractHead(), expected[0]);
		assertEquals(H.extractHead(), expected[1]);
	}

}
