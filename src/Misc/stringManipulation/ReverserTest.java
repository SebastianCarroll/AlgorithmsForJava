package Misc.stringManipulation;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverserTest {

	@Test
	public void testReverse() {
		assertEquals(Reverser.reverse("word"), new String("drow"));
		assertEquals(Reverser.reverse("word i  t"), new String("t  i drow"));
		assertEquals(Reverser.reverse("word i  t //"), new String("// t  i drow"));
		assertEquals(Reverser.reverse(""), new String(""));
	}
	
	@Test
	public void testReverseWordOrder() {
		assertEquals(Reverser.reverseWordOrder("word1 word2 word3"), new String("word3 word2 word1"));
		assertEquals(Reverser.reverseWordOrder("word1   word2 word3"), new String("word3 word2   word1"));
		assertEquals(Reverser.reverseWordOrder(""), new String(""));
	}
	
	@Test
	public void testReverseWords() {
		assertEquals(Reverser.reverseWords("word1 word2 word3"), new String("1drow 2drow 3drow"));
		assertEquals(Reverser.reverseWords("word1  word2 word3"), new String("1drow  2drow 3drow"));
		assertEquals(Reverser.reverseWords(""), new String(""));
	}

}
