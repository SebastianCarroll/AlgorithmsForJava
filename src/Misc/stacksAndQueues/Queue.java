package Misc.stacksAndQueues;

public class Queue<E> {
	E[] elements;
	int head = 0;
	int tail = 0;
	
	@SuppressWarnings("unchecked")
	public Queue(int initialSize){
		elements = (E[]) new Object[initialSize+1];
	}
	
	@SuppressWarnings("unchecked")
	public Queue(){
		elements = (E[]) new Object[10];
	}
	
	public Boolean isEmpty(){
		return head == tail;
	}
	
	public Boolean isFull(){
		return isHeadOneMoreThanTail();
	}
	
	private Boolean isHeadOneMoreThanTail(){
		if(tail + 1 == head){
			return true;
		}else if(head == 0 && tail == elements.length-1){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Add an element to the queue
	 * @param element
	 */
	public void enqueue(E element){
		if(isFull()){
			increaseCapacity();
		}
		elements[tail] = element;
		tail = incrementOrWrap(tail);
	}
	
	public E dequeue(){
		if(isEmpty()){
			return null;
		}
		E element = elements[head];
		head = incrementOrWrap(head);
		return element;
	}
	
	private int incrementOrWrap(int position){
		if(position == elements.length-1){
			return 0;
		} else {
			return position + 1;
		}
	}
	
	private void increaseCapacity(){
		Queue<E> largerCapacity = new Queue<E>(elements.length*2);
		int oldHead = head;
		int oldTail = tail;
		while(!isEmpty()){
			E element = dequeue();
			largerCapacity.enqueue(element);
		}
		head = oldHead;
		tail = oldTail;
		elements = largerCapacity.elements;
	}
}
