package stacksAndQueues;

import static org.junit.Assert.*;
import org.junit.Test;

public class StackTest {

	@Test
	public void testPush() {
		Stack<String> s = new Stack<String>();
		s.push("Test1");
		String[] expected = new String[10];
		expected[0] = "Test1";
		assertArrayEquals(expected, s.elements);
	}

	@Test
	public void testPop() {
		Stack<String> s = new Stack<String>();
		String testString = "Test1";
		s.push(testString);
		assertEquals(s.pop(), testString);
	}
	
	@Test
	public void testUnderFlow() {
		Stack<String> s = new Stack<String>();
		assertEquals(s.pop(), null);
	}
	
	@Test
	public void testResize() {
		Stack<String> s = new Stack<String>(5);
		s.push("Test1");
		s.push("Test2");
		s.push("Test3");
		s.push("Test4");
		s.push("Test5");
		s.push("Test6");
		assertEquals("Test6", s.pop());
	}
	
}
