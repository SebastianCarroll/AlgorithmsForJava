package hashtables;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomHashTableTest {

	@Test
	public void testCustomHashTable() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		CustomHashTable cht = new CustomHashTable(10);
		cht.put("apple", "apple pie with custard");
		cht.put("orange", "apple pie with custard");
		String val = cht.get("apple");
		assertEquals("Check that getting and setting works", 
				"apple pie with custard", 
				val);
	}
	
	@Test
	public void testResize() {
		CustomHashTable cht = new CustomHashTable(5);
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
	public void testPut() {
		fail("Not yet implemented");
	}

}
