package Misc.heap;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

public class MaxHeapTest {

	@Test
	public void TestInitialMaxHeapConstructionDoesntFail() {
		ArrayList<String> input = new ArrayList<String>();
		input.add("Rat");
		input.add("Cat");
		input.add("Bat");
		input.add("Tat");
		
		new MaxHeap<String>(input);
	}
	
	@Test
	public void TestInitialMaxHeapConstructionIsCorrect() {
		ArrayList<String> input = new ArrayList<String>();
		input.add("Rat");
		input.add("Cat");
		input.add("Bat");
		input.add("Tat");
		
		String[] expected = new String[]{"Tat", "Rat", "Bat", "Cat"};
		
		MaxHeap<String> H = new MaxHeap<String>(input);
		
		assertArrayEquals(expected, H.heap.toArray());
	}

}
