package Misc.hashtables;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProbedHashTableTest {

	@Test
	public void testGetAndPut() {
		ProbedHashTable pht = new ProbedHashTable();
		pht.put("key1", "value1");
		pht.put("key2", "value2");
		pht.put("key3", "value3");
		pht.put("key4", "value4");
		pht.put("key5", "value5");
		String value = pht.get("key5");
		assertEquals("Check last key inserted", 
				"value5", 
				value);
		assertEquals("Check first key inserted", 
				"value1", 
				pht.get("key1"));
	}
	
	@Test
	public void testResizing() {
		ProbedHashTable pht = new ProbedHashTable(5);
		pht.put("key1", "value1");
		pht.put("key2", "value2");
		pht.put("key3", "value3");
		pht.put("key4", "value4");
		pht.put("key5", "value5");
		pht.put("key11", "value11");
		pht.put("key21", "value21");
		pht.put("key31", "value31");
		pht.put("key41", "value41");
		pht.put("key51", "value51");
		
		assertEquals("Check last key inserted", 
				"value51", 
				pht.get("key51"));
		assertEquals("Check first key inserted", 
				"value1", 
				pht.get("key1"));
		assertEquals("Check table size", 
				20, 
				pht.elements.length);
	}

	@Test
	public void testContainsKey() {
		ProbedHashTable pht = new ProbedHashTable();
		pht.put("key1", "value1");
		pht.put("key2", "value2");
		pht.put("key3", "value3");
		pht.put("key4", "value4");
		pht.put("key5", "value5");
		assertEquals("Check last key inserted", 
				true, 
				pht.containsKey("key5"));
		assertEquals("Check first key inserted", 
				true, 
				pht.containsKey("key1"));
		assertEquals("Check key never inserted", 
				false, 
				pht.containsKey("keeet"));
	}

	@Test
	public void testDelete() {
		ProbedHashTable pht = new ProbedHashTable();
		pht.put("key1", "value1");
		pht.put("key2", "value2");
		pht.put("key3", "value3");
		pht.put("key4", "value4");
		pht.put("key5", "value5");
		pht.delete("key4");
		assertEquals("Check last key inserted", 
				false, 
				pht.containsKey("key4"));
		assertEquals("Check first key inserted", 
				null, 
				pht.get("key4"));
		assertEquals("Check last key inserted", 
				"value3", 
				pht.get("key3"));
		assertEquals("Check first key inserted", 
				true, 
				pht.containsKey("key3"));
	}

}
