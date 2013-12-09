package Misc.heap;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

public class MinHeapTest {

	@Test
	public void TestInitialMinHeapConstructionDoesntFail() {
		ArrayList<String> input = new ArrayList<String>();
		input.add("Rat");
		input.add("Cat");
		input.add("Bat");
		input.add("Tat");
		
		new MinHeap<String>(input);
	}
	
	@Test
	public void TestInitialMinHeapConstructionIsCorrect() {
		ArrayList<String> input = new ArrayList<String>();
		input.add("Rat");
		input.add("Bat");
		input.add("Tat");
		
		String[] expected = new String[]{"Bat", "Rat", "Tat"};
		
		MinHeap<String> H = new MinHeap<String>(input);
		
		assertArrayEquals(expected, H.heap.toArray());
	}
	
	@Test
	public void TestAdjustKey() {
		ArrayList<String> input = new ArrayList<String>();
		input.add("Rat");
		input.add("Bat");
		input.add("Tat");
		
		String[] expected = new String[]{"Aat", "Bat", "Tat", "Rat"};
		
		MinHeap<String> H = new MinHeap<String>(input);
		H.adjustKey(4, "Aat");
	}
}
