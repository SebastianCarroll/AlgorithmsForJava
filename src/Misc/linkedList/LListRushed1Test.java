package Misc.linkedList;

import static org.junit.Assert.*;

import org.junit.Test;

import Misc.linkedList.LListRushed1;

public class LListRushed1Test {

	@Test
	public void test() {
		LListRushed1<String> list = new LListRushed1<String>(); 
		list.Insert("1");
		list.Insert("2");
		list.Delete("1");
		assertEquals("2", list.head.value);
	}
	
	@Test
	public void testManyInserts() {
		LListRushed1<String> list = new LListRushed1<String>(); 
		list.Insert("1");
		list.Insert("2");
		list.Insert("3");
		list.Insert("4");
		list.Insert("5");
		list.Insert("6");
		list.Insert("7");
		list.Insert("9");
		list.Insert("10");
		
		assertEquals("10", list.head.value);
	}

}
