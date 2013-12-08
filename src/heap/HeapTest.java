package heap;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

public class HeapTest {

	@Test
	public void TestInitialHeapConstructionDoesntFail() {
		ArrayList<String> input = new ArrayList<String>();
		input.add("Rat");
		input.add("Cat");
		input.add("Bat");
		input.add("Tat");
		
		new Heap<String>(input);
	}
	
	@Test
	public void TestInitialHeapConstructionIsCorrect() {
		ArrayList<String> input = new ArrayList<String>();
		input.add("Rat");
		input.add("Cat");
		input.add("Bat");
		input.add("Tat");
		
		String[] expected = new String[]{"Tat", "Rat", "Bat", "Cat"};
		
		Heap<String> H = new Heap<String>(input);
		
		assertArrayEquals(expected, H.heap.toArray());
	}

}
