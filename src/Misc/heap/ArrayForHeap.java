package Misc.heap;

import java.util.ArrayList;

public abstract class ArrayForHeap<E extends Comparable<E>> {
	private ArrayList<E> heap = new ArrayList<E>();
	private Integer heapsize = 0;
	
	protected ArrayForHeap(E[] initialElements){
		mapToArrayList(initialElements);
		heapsize = heap.size();
	}
	
	protected Integer heapsize(){
		return heapsize;
	}
	
	private void mapToArrayList(E[] initialElements){
		for(E elem : initialElements){
			heap.add(elem);
		}
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
	
	protected Boolean contains(E toCompare){
		for(E element : heap){
			if(element.equals(toCompare)){
				return true;
			}
		}
		return false;
	}
	
}
