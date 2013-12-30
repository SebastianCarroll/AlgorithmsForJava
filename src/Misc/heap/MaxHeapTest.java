package Misc.heap;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

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
		
		assertArrayEquals(expected, input);
	}

}
