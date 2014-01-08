package Misc.stacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueRushedTest {

	@Test
	public void commonUsage() {
		QueueRushed<Integer> qr = new QueueRushed<Integer>(5);
		qr.enqueue(10);
		qr.enqueue(11);
		Integer firstIn = qr.dequeue();
		Integer secondIn = qr.dequeue();
		
		assertEquals(firstIn, new Integer(10));
		assertEquals(secondIn, new Integer(11));
	}
	
	@Test
	public void testWrap() {
		QueueRushed<Integer> qr = new QueueRushed<Integer>(3);
		qr.enqueue(10);
		qr.enqueue(11);
		Integer firstIn = qr.dequeue();
		Integer secondIn = qr.dequeue();
		qr.enqueue(12);
		qr.enqueue(13);
		Integer thirdIn = qr.dequeue();
		Integer fourthIn = qr.dequeue();
		
		assertEquals(firstIn, new Integer(10));
		assertEquals(secondIn, new Integer(11));
		assertEquals(thirdIn, new Integer(12));
		assertEquals(fourthIn, new Integer(13));
	}
	
	@Test
	public void testFullAndEmpty() {
		QueueRushed<Integer> qr = new QueueRushed<Integer>(3);
		assertTrue(qr.isEmpty());
		qr.enqueue(10);
		qr.enqueue(11);
		qr.enqueue(12);
		
		assertTrue(qr.isFull());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testOverFlow() {
		QueueRushed<Integer> qr = new QueueRushed<Integer>(3);
		qr.enqueue(10);
		qr.enqueue(11);
		qr.enqueue(12);
		qr.enqueue(13);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testUnderFlow() {
		QueueRushed<Integer> qr = new QueueRushed<Integer>(3);
		qr.dequeue();
	}

}
