package Misc.heap;

import java.util.ArrayList;

public abstract class ArrayForHeap<E extends Comparable<E>> {
	private ArrayList<E> heap = new ArrayList<E>();
	private Integer heapsize = 0;
	
	public ArrayForHeap(E[] initialElements){
		mapToArrayList(initialElements);
		heapsize = heap.size();
	}
	
	public Integer heapsize(){
		return heapsize;
	}
	
	private void mapToArrayList(E[] initialElements){
		for(E elem : initialElements){
			heap.add(elem);
		}
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
	
	
	
}
