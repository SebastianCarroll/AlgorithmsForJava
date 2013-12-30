package Misc.heap;

public class MaxHeap<E extends Comparable<E>> extends Heap<E> {
	
//	public MaxHeap(E[] initialElements){
//		super(initialElements);
//	}
	
	public MaxHeap(E[] initialElements){
		super(initialElements);
	}
	
	protected Boolean inOrder(E left, E right){
		// True if left < right
		return left.compareTo(right) >= 0;
	}
}