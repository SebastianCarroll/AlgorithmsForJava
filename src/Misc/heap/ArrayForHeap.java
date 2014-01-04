package Misc.heap;

import java.util.ArrayList;

public class ArrayForHeap<E extends Comparable<E>> {
	private ArrayList<E> heap = new ArrayList<E>();
	private Integer heapsize = 0;
	private E[] initialElementsSaved;
	
	public ArrayForHeap(E[] initialElements){
		initialElementsSaved = initialElements;
		mapToArrayList(initialElements);
		heapsize = heap.size();
	}
	
	private void mapToArrayList(E[] initialElements){
		for(E elem : initialElements){
			heap.add(elem);
		}
	}
	
	public Integer heapsize(){
		return heapsize;
	}
	
	public E get(int index){
		if(index-1 >= heapsize){
			throw new IndexOutOfBoundsException();
		}
		return heap.get(index-1);
	}
	
	public E set(int index, E element){
		return heap.set(index-1, element);
	}
	
	public void remove(int index){
		heap.remove(index-1);
		heapsize--;
	}
	
	public void add(E newElement){
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
	
	public E[] toArray(){
		return heap.toArray(initialElementsSaved);
	}
}
