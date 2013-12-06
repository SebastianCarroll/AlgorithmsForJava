package sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void testQuicksort() {
		String[] TestArray = new String[]{"Bat", "Turtle", "Ranch", "Ant"};
		String[] ExpectedSorted = new String[]{"Ant", "Bat", "Ranch", "Turtle"};
		
		QuickSort as = new QuickSort();
		as.sort(TestArray);
		
		assertArrayEquals(TestArray, ExpectedSorted);
	}
	
	@Test
	public void testQuicksortOnSmallSortedArray() {
		String[] TestArray = new String[]{"Bat", "Ranch"};
		String[] ExpectedSorted = new String[]{"Bat", "Ranch"};
		
		QuickSort as = new QuickSort();
		as.sort(TestArray);
		
		assertArrayEquals(TestArray, ExpectedSorted);
	}
	
	@Test
	public void testQuicksortOnSmallUnsortedArray() {
		String[] TestArray = new String[]{"Ranch", "Bat"};
		String[] ExpectedSorted = new String[]{"Bat", "Ranch"};
		
		QuickSort as = new QuickSort();
		as.sort(TestArray);
		
		assertArrayEquals(TestArray, ExpectedSorted);
	}
	
	@Test
	public void testQuicksortOnSingleArray() {
		String[] TestArray = new String[]{"Bat"};
		String[] ExpectedSorted = new String[]{"Bat"};
		
		QuickSort as = new QuickSort();
		as.sort(TestArray);
		
		assertArrayEquals(TestArray, ExpectedSorted);
	}

}
