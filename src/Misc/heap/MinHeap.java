package Misc.heap;

public class MinHeap extends Heap {
	// Use -1 to account for mandatory 1th indexed heap
	private Boolean inOrder(Integer l, Integer r){
		// True if left < right
		E left = heap.get(l-1);
		E right = heap.get(r-1);
		return left.compareTo(right) >= 0;
	}
}
