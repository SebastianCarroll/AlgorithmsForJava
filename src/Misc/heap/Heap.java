package Misc.heap;

public abstract class Heap<E extends Comparable<E>> {
	
	private ArrayForHeap<E> heap;
	private HeapLogic logic = new HeapLogic();
	
	public Heap(E[] initialElements){
		heap = new ArrayForHeap<E>(initialElements);
		buildHeap();
	}
	
	// Internal State changes == voids
	// TODO: Fix this method
	public void adjustKey(Integer index, E newElement){
		if( indexInRange(index) && inOrder(newElement, heap.get(index)) ){
			heap.set(index, newElement);
			while(index > 1 && !inOrder(heap.get(logic.parent(index)), heap.get(index))){
				exchange(index, logic.parent(index));
				index = logic.parent(index);
			}
		}
	}
	
	private void buildHeap(){
		for(int i = heap.heapsize()/2; i > 0; i--){
			heapify(i);
		}
	}
	
	public void heapify(Integer root){
		Integer l = logic.left(root);
		Integer r = logic.right(root);
		
		Integer largest = findLargest(l, r, root); 
		
		if(largest != root){
			exchange(root, largest);
			heapify(largest);
		}
	}
	
	public void decrementSize(){
		heap.decrementSize();
	}
	
	// Use -1 to account for mandatory 1th indexed heap
	public void exchange(Integer l, Integer r){
		E left = heap.get(l);
		E right = heap.get(r);
		
		heap.set(l, right);
		heap.set(r, left);
	}
	
	// Setters == voids
	public void insert(E newElement){
		heap.add(newElement);
		adjustKey(heap.heapsize(), newElement);
	}
	
	// Tests == Bools	
	private Boolean indexInRange(Integer index){
		return index-1  < heap.heapsize();
	}
	
	private Integer findLargest(Integer l, Integer r, Integer root){
		Integer largest;
		if(l <= heap.heapsize() && inOrder(heap.get(l), heap.get(root))){
			largest = l;
		} else {
			largest = root;
		}
		if(r <= heap.heapsize() && inOrder(heap.get(r), heap.get(largest))){
			largest = r;
		}
		return largest;
	}
	
	public Boolean isEmpty(){
		return heap.isEmpty();
	}
	
	public Boolean contains(E toCompare){
		return heap.contains(toCompare);
	}
	
	protected abstract Boolean inOrder(E l, E r);
	
	// Accessors == E's	
	public E getHead(){
		return heap.get(1);
	}
	
	public E extractHead(){
		if(heap.heapsize() < 1){
			//TODO: Error - heap underflow
		}
		E head = heap.get(1);
		exchange(1, heap.heapsize());
		heap.remove(heap.heapsize());
		heapify(1);
		return head;
	}
	
	public E[] getHeap(){
		return heap.toArray();
	}
}
