package hashtables;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomHashTableTest {

	@Test
	public void testCustomHashTable() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutAndGet() {
		CustomHashTable cht = new CustomHashTable(10);
		cht.put("apple", "apple pie with custard");
		cht.put("orange", "apple pie with custard");
		String val = cht.get("apple");
		assertEquals("Check that getting and setting works", 
				"apple pie with custard", 
				val);
	}

	@Test
	public void testPut() {
		fail("Not yet implemented");
	}

}
