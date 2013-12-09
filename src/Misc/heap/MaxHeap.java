package Misc.heap;

import java.util.ArrayList;

public class MaxHeap<E extends Comparable<E>> extends Heap<E> {
	
	public MaxHeap(ArrayList<E> initialElements){
		super(initialElements);
	}
	
	public MaxHeap(E[] initialElements){
		super(initialElements);
	}
	
	// Use -1 to account for mandatory 1th indexed heap
	protected Boolean inOrder(E left, E right){
		// True if left < right
		return left.compareTo(right) >= 0;
	}
}