package Misc.sorting;

import static org.junit.Assert.*;

import org.junit.Test;
import heap.Heap;

public class HeapSortTest {

	@Test
	public void testSort() {
		String[] TestArray = new String[]{"Bat", "Turtle", "Ranch", "Ant"};
		String[] ExpectedSorted = new String[]{"Ant", "Bat", "Ranch", "Turtle"};
		
		Heap<String> heap = HeapSort.sort(TestArray);
		
		assertArrayEquals(heap.heap.toArray(), ExpectedSorted);
	}
	
	@Test
	public void testHeapSortOnSmallSortedArray() {
		String[] TestArray = new String[]{"Bat", "Ranch"};
		String[] ExpectedSorted = new String[]{"Bat", "Ranch"};
		
		HeapSort.sort(TestArray);
		
		Heap<String> heap = HeapSort.sort(TestArray);
		
		assertArrayEquals(heap.heap.toArray(), ExpectedSorted);
	}
	
	@Test
	public void testHeapSortOnSmallUnsortedArray() {
		String[] TestArray = new String[]{"Ranch", "Bat"};
		String[] ExpectedSorted = new String[]{"Bat", "Ranch"};
		
		Heap<String> heap = HeapSort.sort(TestArray);
		
		assertArrayEquals(heap.heap.toArray(), ExpectedSorted);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testHeapSortOnEmptyArray() {
		String[] TestArray = new String[10];		
		HeapSort.sort(TestArray);
	}
	
	@Test(expected=NullPointerException.class)
	public void testHeapSortOnNullArray() {
		String[] TestArray = null;		
		HeapSort.sort(TestArray);
	}
	
	@Test
	public void testHeapSortOnIntegerArray() {
		Integer[] TestArray = new Integer[]{1, 34, 5, 99, 12};
		Integer[] ExpectedSorted = new Integer[]{1, 5, 12, 34, 99};
		
		Heap<Integer> heap = HeapSort.sort(TestArray);
		
		assertArrayEquals(heap.heap.toArray(), ExpectedSorted);
	}
}
