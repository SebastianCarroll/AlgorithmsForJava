package Misc.heap;

import java.util.ArrayList;

public abstract class Heap<E extends Comparable<E>> {
	public ArrayList<E> heap = new ArrayList<E>();
	public Integer heapsize = 0;
	
	public Heap(ArrayList<E> initialElements){
		heap = initialElements;
		heapsize = initialElements.size();
		buildHeap();
	}
	
	public Heap(E[] initialElements){
		heapsize = initialElements.length;
		mapToArrayList(initialElements);
		buildHeap();
	}
	
	private void mapToArrayList(E[] initialElements){
		for(E elem : initialElements){
			heap.add(elem);
		}
	}
	
	private void buildHeap(){
		for(int i = heapsize/2; i > 0; i--){
			heapify(i);
		}
	}
	
	public void heapify(Integer root){
		Integer l = left(root);
		Integer r = right(root);
		
		Integer largest = findLargest(l, r, root); 
		
		if(largest != root){
			exchange(root, largest);
			heapify(largest);
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
	protected abstract Boolean inOrder(Integer l, Integer r);
}
