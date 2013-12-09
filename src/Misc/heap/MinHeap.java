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
	protected Boolean inOrder(E left, E right){
		// True if left > right
		if(left == null){
			return true;
		}
		if(right == null){
			return false;
		}
		return left.compareTo(right) <= 0;
	}
}