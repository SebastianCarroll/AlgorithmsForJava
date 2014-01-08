package Misc.stacksAndQueues;

public class QueueRushed<E> {
	private E[] elements;
	private int head = 0;
	private int tail = 0;
	

	@SuppressWarnings("unchecked")
	public QueueRushed(int size){
		elements = (E[]) new Object[size + 1];
	}
	
	public boolean isEmpty(){
		return head == tail;
	}
	
	public boolean isFull(){
		return tail + 1 == head || (head == 0 && tail == elements.length -1);
	}
	
	public void enqueue(E value){
		if(isFull()){
			throw new IndexOutOfBoundsException("Queue is full.");
		}
		elements[tail] = value;
		tail = incrementOrWrap(tail);
	}
	
	public E dequeue(){
		if(isEmpty()){
			throw new IndexOutOfBoundsException("Queue is empty.");
		}
		E element = elements[head];
		head = incrementOrWrap(head);
		return element;
	}
	
	private int incrementOrWrap(int in){
		if(in == elements.length -1){
			return 0;
		} else {
			return in +1;
		}
	}
	
}
