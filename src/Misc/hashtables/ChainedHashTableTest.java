package Misc.hashtables;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChainedHashTableTest {

	@Test
	public void testGet() {
		ChainedHashTable cht = new ChainedHashTable(10);
		cht.put("apple", "apple pie with custard");
		cht.put("orange", "apple pie with custard");
		String val = cht.get("apple");
		assertEquals("Check that getting and setting works", 
				"apple pie with custard", 
				val);
	}
	
	@Test
	public void testGetDoesntExist() {
		ChainedHashTable cht = new ChainedHashTable(10);
		cht.put("apple", "apple pie with custard");
		cht.put("orange", "apple pie with custard");
		String val = cht.get("fred");
		assertEquals("Check that getting returns null if element doesnt exist in the table", 
				null,
				val);
	}
	
	@Test
	public void testResize() {
		ChainedHashTable cht = new ChainedHashTable(5, 0.6);
		cht.put("apple", "1");
		cht.put("orange", "2");
		cht.put("green", "3");
		cht.put("red", "4");
		cht.put("tuttle", "5");
		cht.put("purple", "6");
		cht.put("proof", "7");
		cht.put("jim", "8");
		cht.put("slow", "9");
		String val = cht.get("tuttle");
		assertEquals("Check that array correclty resizes", 
				"5", 
				val);
	}
	
	@Test
	public void testDelete() {
		ChainedHashTable cht = new ChainedHashTable(5, 0.6);
		cht.put("apple", "1");
		cht.put("orange", "2");
		cht.put("green", "3");
		cht.put("red", "4");
		cht.put("tuttle", "5");
		
		cht.delete("tuttle");
		assertEquals("Deleted element should not be accessible", 
				null, 
				cht.get("tuttle"));
		
		cht.delete("red");
		assertEquals("Deleted element should not be accessible", 
				null, 
				cht.get("red"));
		
		cht.delete("green");
		assertEquals("Deleted element should not be accessible", 
				null, 
				cht.get("green"));
		
		cht.delete("orange");
		assertEquals("Deleted element should not be accessible", 
				null, 
				cht.get("orange"));
		
		cht.delete("apple");
		assertEquals("Deleted element should not be accessible", 
				null, 
				cht.get("apple"));
	}

}
