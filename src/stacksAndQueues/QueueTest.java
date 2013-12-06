package stacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	@Test
	public void testIsEmpty() {
		Queue<String> q = new Queue<String>(3);
		Boolean isEmpty = q.isEmpty();
		assertTrue(isEmpty);
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
		Queue<String> q = new Queue<String>(3);
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		String[] test = new String[4];
		test[0] = "1";
		test[1] = "2";
		test[2] = "3";
		assertArrayEquals(q.elements, test);
	}

	@Test
	public void testDequeue() {
		Queue<String> q = new Queue<String>(3);
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		String firstIn = q.dequeue();
		assertEquals(firstIn, "1");
		assertEquals(q.dequeue(), "2");
		assertEquals(q.dequeue(), "3");
	}
	
	@Test
	public void testResize() {
		Queue<String> q = new Queue<String>(3);
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		q.enqueue("4");
		q.dequeue();
		q.dequeue();
		q.dequeue();
		String lastIn = q.dequeue();
		assertEquals(lastIn, "4");
	}
	
	@Test
	public void testIntegers() {
		Queue<Integer> q = new Queue<Integer>(3);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		Integer firstIn = q.dequeue();
		assertTrue(firstIn == 1);
		assertTrue(q.dequeue() == 2);
		assertTrue(q.dequeue() == 3);
	}

	@Test
	public void testBooleans() {
		Queue<Boolean> q = new Queue<Boolean>(3);
		q.enqueue(true);
		q.enqueue(false);
		q.enqueue(false);
		Boolean firstIn = q.dequeue();
		assertTrue(firstIn);
		assertFalse(q.dequeue());
		assertFalse(q.dequeue());
	}
}
