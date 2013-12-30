package Misc.heap;

import java.util.ArrayList;

public abstract class ArrayForHeap<E extends Comparable<E>> {
	private ArrayList<E> heap = new ArrayList<E>();
	private Integer heapsize = 0;
	
	protected ArrayForHeap(E[] initialElements){
		mapToArrayList(initialElements);
		heapsize = heap.size();
	}
	
	private void mapToArrayList(E[] initialElements){
		for(E elem : initialElements){
			heap.add(elem);
		}
	}
	
	protected Integer heapsize(){
		return heapsize;
	}
	
	protected E get(int index){
		if(index-1 >= heapsize){
			throw new IndexOutOfBoundsException();
		}
		return heap.get(index-1);
	}
	
	protected E set(int index, E element){
		return heap.set(index-1, element);
	}
	
	protected void remove(int index){
		heap.remove(index-1);
		heapsize--;
	}
	
	protected void add(E newElement){
		heap.add(newElement);
		heapsize++;
	}
	
	/**
	 * Attempts to find the specified element in the heap.
	 * TODO: This is a heap and thus this compare can be more efficient
	 * @param toCompare Item to find
	 * @return True if found, false otherwise
	 */
	public Boolean contains(E toCompare){
		for(E element : heap){
			if(element.equals(toCompare)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if there are elements in the heap
	 * @return True if heap is not empty
	 */
	public boolean isEmpty() {
		return heapsize() < 1;
	}
	
	/**
	 * Decreases the use-able size of the heap, without removing those elements
	 */
	public void decrementSize(){
		heapsize--;
	}
}
