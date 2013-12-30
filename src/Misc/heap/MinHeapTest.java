package Misc.heap;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

public class MinHeapTest {

	@Test
	public void TestInitialMinHeapConstructionDoesntFail() {
		String[] input = new String[]{"Rat", "Bat", "Tat"};
		
		new MinHeap<String>(input);
	}
	
	@Test
	public void TestInitialMinHeapConstructionIsCorrect() {
		String[] input = new String[]{"Rat", "Bat", "Tat"};
		
		String[] expected = new String[]{"Bat", "Rat", "Tat"};
		
		MinHeap<String> H = new MinHeap<String>(input);
		
		assertArrayEquals(expected, input);
	}
	
	@Test
	public void TestInsert() {
	
		String[] input = new String[]{"Rat", "Bat", "Tat"};
		
		String[] expected = new String[]{"Aat", "Bat", "Tat", "Rat"};
		
		MinHeap<String> H = new MinHeap<String>(input);
		H.insert("Aat");
		
		assertArrayEquals(expected, input);
	}
	
	@Test
	public void TestAdjustKey() {
		String[] input = new String[]{"Rat", "Bat", "Tat"};
		
		String[] expected = new String[]{"Aat", "Bat", "Tat"};
		
		MinHeap<String> H = new MinHeap<String>(input);
		H.adjustKey(2, "Aat");
		
		assertArrayEquals(expected, input);
	}
	
	@Test
	public void TestExtractMin() {
		String[] input = new String[]{"Rat", "Bat", "Tat"};
		
		String[] expected = new String[]{"Rat", "Tat"};
		
		MinHeap<String> H = new MinHeap<String>(input);
		String min = H.extractHead();
		assertEquals(min, "Bat");
		assertArrayEquals(expected, input);
		assertEquals(H.extractHead(), "Rat");
	}
}
