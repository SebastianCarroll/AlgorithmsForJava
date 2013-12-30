package Misc.stacksAndQueues;

import Misc.heap.*;

/**
 * TODO: This class seems redundant. All it does is wrap the MinHeap class and pass the methods through
 * @author sjc
 *
 * @param <E>
 */
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
		return heap.isEmpty();
	}
	
	public boolean contains(E toCompare){
		return heap.contains(toCompare);
	}
}
