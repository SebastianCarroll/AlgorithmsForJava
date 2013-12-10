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
}
