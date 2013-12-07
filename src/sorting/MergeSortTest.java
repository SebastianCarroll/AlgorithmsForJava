package sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void testSort() {
		String[] TestArray = new String[]{"Bat", "Turtle", "Ranch", "Ant"};
		String[] ExpectedSorted = new String[]{"Ant", "Bat", "Ranch", "Turtle"};
		
		MergeSort.sort(TestArray);
		
		assertArrayEquals(TestArray, ExpectedSorted);
	}
	
	@Test
	public void testMergesortOnSmallSortedArray() {
		String[] TestArray = new String[]{"Bat", "Ranch"};
		String[] ExpectedSorted = new String[]{"Bat", "Ranch"};
		
		MergeSort.sort(TestArray);
		
		assertArrayEquals(TestArray, ExpectedSorted);
	}
	
	@Test
	public void testMergesortOnSmallUnsortedArray() {
		String[] TestArray = new String[]{"Ranch", "Bat"};
		String[] ExpectedSorted = new String[]{"Bat", "Ranch"};
		
		MergeSort.sort(TestArray);
		
		assertArrayEquals(TestArray, ExpectedSorted);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMergesortOnEmptyArray() {
		String[] TestArray = new String[10];		
		MergeSort.sort(TestArray);
	}
	
	@Test(expected=NullPointerException.class)
	public void testMergesortOnNullArray() {
		String[] TestArray = null;		
		MergeSort.sort(TestArray);
	}
	
	@Test
	public void testMergesortOnIntegerArray() {
		Integer[] TestArray = new Integer[]{1, 34, 5, 99, 12};
		Integer[] ExpectedSorted = new Integer[]{1, 5, 12, 34, 99};
		
		MergeSort.sort(TestArray);
		
		assertArrayEquals(TestArray, ExpectedSorted);
	}

}
