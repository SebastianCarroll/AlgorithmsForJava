package heap;

import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
	public ArrayList<E> heap = new ArrayList<E>();
	public Integer heapsize = 0;
	
	public Heap(ArrayList<E> initialElements){
		heap = initialElements;
		heapsize = initialElements.size();
		buildMaxHeap();
	}
	
	public Heap(E[] initialElements){
		heapsize = initialElements.length;
		mapToArrayList(initialElements);
		buildMaxHeap();
	}
	
	private void mapToArrayList(E[] initialElements){
		for(E elem : initialElements){
			heap.add(elem);
		}
	}
	
	private void buildMaxHeap(){
		for(int i = heapsize/2; i > 0; i--){
			maxHeapify(i);
		}
	}
	
	public void maxHeapify(Integer root){
		Integer l = left(root);
		Integer r = right(root);
		
		Integer largest = findLargest(l, r, root); 
		
		if(largest != root){
			exchange(root, largest);
			maxHeapify(largest);
		}
	}
	
	// Use -1 to account for mandatory 1th indexed heap
	public void exchange(Integer l, Integer r){
		E left = heap.get(l-1);
		E right = heap.get(r-1);
		
		heap.set(l-1, right);
		heap.set(r-1, left);
	}
	
	private Integer findLargest(Integer l, Integer r, Integer root){
		Integer largest;
		if(l <= heapsize && inOrder(l, root)){
			largest = l;
		} else {
			largest = root;
		}
		if(r <= heapsize && inOrder(r, largest)){
			largest = r;
		}
		return largest;
	}
	
	private Integer left(Integer node){
		return 2*node;
	}
	
	private Integer right(Integer node){
		return 2*node + 1;
	}
	
	private Integer parent(Integer node){
		return node/2;
	}
	
	// Use -1 to account for mandatory 1th indexed heap
	private Boolean inOrder(Integer l, Integer r){
		// True if left < right
		E left = heap.get(l-1);
		E right = heap.get(r-1);
		return left.compareTo(right) >= 0;
	}
}
