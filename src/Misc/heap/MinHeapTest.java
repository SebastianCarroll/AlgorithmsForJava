package Misc.heap;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinHeapTest {

	@Test
	public void TestInitialMinHeapConstructionDoesntFail() {
		String[] input = new String[]{"Rat", "Bat", "Tat"};
		
		new MinHeap<String>(input);
	}
	
	@Test
	public void TestInsert() {
	
		String[] input = new String[]{"Rat", "Bat", "Tat"};
		
		String[] expected = new String[]{"Aat", "Bat", "Tat", "Rat"};
		
		MinHeap<String> H = new MinHeap<String>(input);
		H.insert("Aat");
		
		assertArrayEquals(expected, H.getHeap());
	}
	
	@Test
	public void TestAdjustKey() {
		String[] input = new String[]{"Rat", "Bat", "Tat"};
		
		String[] expected = new String[]{"Aat", "Bat", "Tat"};
		
		MinHeap<String> H = new MinHeap<String>(input);
		H.adjustKey(2, "Aat");
		
		assertEquals(expected[0], H.extractHead());
	}
	
	@Test
	public void TestExtractMin() {
		String[] input = new String[]{"Rat", "Bat", "Tat"};
		
		MinHeap<String> H = new MinHeap<String>(input);
		String min = H.extractHead();
		assertEquals(min, "Bat");
		assertEquals(H.extractHead(), "Rat");
		assertEquals(H.extractHead(), "Tat");
	}
}
