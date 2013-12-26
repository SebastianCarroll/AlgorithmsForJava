package Misc.stacksAndQueues;

import Misc.heap.*;

public class PriorityQueue<E extends Comparable<E>> {
	MinHeap<E> heap;
	
	public PriorityQueue(E[] initialElements){
		heap = new MinHeap<E>(initialElements);
	}
	
	public void insert(E newElement){
		heap.insert(newElement);
	}
	
	public E extractHead(){
		return heap.extractHead();
	}
	
	public boolean isEmpty(){
		return heap.heapsize < 1;
	}
	
	public boolean contains(E toCompare){
		for(E element : heap.heap){
			if(element.equals(toCompare)){
				return true;
			}
		}
		return false;
	}
	
	public E[] toArray(){
		E[] ret = (E[]) new Object[heap.heap.size()];
		for(int i=0; i<heap.heap.size(); i++){
			ret[i] = heap.heap.get(i);
		}
		return ret;
	}
}
