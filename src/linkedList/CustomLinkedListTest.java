package linkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomLinkedListTest {

	@Test
	public void testInsert() {
		CustomLinkedList cll =  new CustomLinkedList();
		cll.insert("key1", "value1");
		String list = cll.stringify();
		assertEquals(list, "(key1, value1)");
	}

	@Test
	public void testFetch() {
		fail("Not yet implemented");
	}

}
