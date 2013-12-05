package stacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsFull() {
		Queue<String> q = new Queue<String>(3);
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		Boolean isFull = q.isFull();
		assertTrue(isFull);
	}

	@Test
	public void testEnqueue() {
		fail("Not yet implemented");
	}

	@Test
	public void testDequeue() {
		fail("Not yet implemented");
	}

}
