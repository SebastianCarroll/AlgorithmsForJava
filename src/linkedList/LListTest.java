package linkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class LListTest {

	@Test
	public void testInsert_NullList() {
		LList cll =  new LList();

		assertEquals("Empty List", cll.stringify(), "");
	}
	
	@Test
	public void testInsert_SingleElementList() {
		LList cll =  new LList();
		cll.insert("key1", "value1");
		assertEquals("Single Element List", cll.stringify(), "(key1, value1)");
	}
	
	@Test
	public void testInsert_ManyElementList() {
		LList cll =  new LList();
		cll.insert("key5", "value5");
		cll.insert("key4", "value4");
		cll.insert("key3", "value3");
		cll.insert("key2", "value2");
		cll.insert("key1", "value1");
		assertEquals("Many element List", 
				cll.stringify(), 
				"(key1, value1)(key2, value2)(key3, value3)(key4, value4)(key5, value5)");
	}

	@Test
	public void testFetch() {
		LList cll =  new LList();
		cll.insert("key5", "value5");
		cll.insert("key4", "value4");
		cll.insert("key3", "value3");
		cll.insert("key2", "value2");
		cll.insert("key1", "value1");
		assertEquals("Last Key inserted", 
				cll.fetch("key1"), 
				"value1");
		assertEquals("First Key inserted", 
				cll.fetch("key5"), 
				"value5");
	}
	
	@Test
	public void testRemove() {
		LList cll =  new LList();
		cll.insert("key5", "value5");
		cll.insert("key4", "value4");
		cll.insert("key3", "value3");
		cll.insert("key2", "value2");
		cll.insert("key1", "value1");
		
		cll.remove("key1");
		assertEquals("Last Key inserted", 
				cll.stringify(), 
				"(key2, value2)(key3, value3)(key4, value4)(key5, value5)");
		
		cll.remove("key5");
		assertEquals("First Key inserted", 
				cll.stringify(), 
				"(key2, value2)(key3, value3)(key4, value4)");
	}

}
