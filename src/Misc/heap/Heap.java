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
	
//	public void adjust-key(Integer index, E newElement){
//		E current = heap.get(index-1);
//		heap.add(newElement);
//		//if(inOrder(index, r))
//	}
	
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
		E left = getAt(l);
		E right = getAt(r);
		
		setAt(l, right);
		setAt(r, left);
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
	
	protected E getAt(int index){
		return heap.get(index-1);
	}
	
	protected void setAt(int index, E element){
		heap.set(index-1, element);
	}
	
	// Use -1 to account for mandatory 1th indexed heap
	protected abstract Boolean inOrder(Integer l, Integer r);
}
