package hashtables;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomHashTable2Test {

	@Test
	public void testCustomHashTable2() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		CustomHashTable2 cht = new CustomHashTable2(10);
		cht.put("apple", "apple pie with custard");
		cht.put("orange", "apple pie with custard");
		String val = cht.get("apple");
		assertEquals("Check that getting and setting works", 
				"apple pie with custard", 
				val);
	}
	
	@Test
	public void testResize() {
		CustomHashTable2 cht = new CustomHashTable2(5);
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
