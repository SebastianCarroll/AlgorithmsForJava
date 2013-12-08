package stacksAndQueues;

public class Stack<E> {
	E[] elements;
	int top = 0;
	
	@SuppressWarnings("unchecked")
	public Stack(int startSize){
		elements = (E[]) new Object[startSize];
	}
	
	@SuppressWarnings("unchecked")
	public Stack(){
		elements = (E[]) new Object[10];
	}
	
	public void push(E in){
		if(top == elements.length){
			resizeStack();
		}
		elements[top] = in;
		top++;
	}
	
	public E pop(){
		if(top == 0){
			return null;
		}
		top--;
		E toReturn = elements[top];
		return toReturn;
	}
	
	@SuppressWarnings("unchecked")
	private void resizeStack(){
		E[] moreElements = (E[]) new Object[elements.length*2];
		for(int i=0; i<elements.length; i++){
			moreElements[i] = elements[i];
		}
		elements = moreElements;
	}
	
}
