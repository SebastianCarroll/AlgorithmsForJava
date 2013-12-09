package Misc.heap;

import java.util.ArrayList;

public class MinHeap<E extends Comparable<E>> extends Heap<E> {
	
	public MinHeap(ArrayList<E> initialElements){
		super(initialElements);
	}
	
	public MinHeap(E[] initialElements){
		super(initialElements);
	}
	
	// Use -1 to account for mandatory 1th indexed heap
	protected Boolean inOrder(Integer l, Integer r){
		// True if left < right
		E left = heap.get(l-1);
		E right = heap.get(r-1);
		return left.compareTo(right) >= 0;
	}
}