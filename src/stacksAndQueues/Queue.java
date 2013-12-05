package stacksAndQueues;

public class Queue<E> {
	E[] elements;
	int head = 0;
	int tail = 0;
	
	@SuppressWarnings("unchecked")
	public Queue(int initialSize){
		elements = (E[]) new Object[initialSize];
	}
	
	@SuppressWarnings("unchecked")
	public Queue(){
		elements = (E[]) new Object[10];
	}
	
	public Boolean isEmpty(){
		return head == tail;
	}
	
	public Boolean isFull(){
		return isHeadOneLessThanTail();
	}
	
	private Boolean isHeadOneLessThanTail(){
		if(tail - 1 == head){
			return true;
		}else if(tail == 0 && head == elements.length){
			return true;
		} else {
			return false;
		}
	}
	
	public void enqueue(E element){
		elements[head] = element;
		head++;
	}
	
	public E dequeue(){
		E element = elements[tail];
		tail++;
		return element;
	}
}
