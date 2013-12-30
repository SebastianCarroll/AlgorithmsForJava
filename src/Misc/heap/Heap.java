package Misc.heap;

public abstract class Heap<E extends Comparable<E>> extends ArrayForHeap<E>{
	
//	public Heap(ArrayList<E> initialElements){
//		heap = initialElements;
//		size() = initialElements.size();
//		buildHeap();
//	}
	
	public Heap(E[] initialElements){
		super(initialElements);
		buildHeap();
	}
	
	// TODO: Fix this method
	public void adjustKey(Integer index, E newElement){
		if( indexInRange(index) && inOrder(newElement, get(index)) ){
			set(index, newElement);
			while(index > 1 && !inOrder(get(parent(index)), get(index))){
				exchange(index, parent(index));
				index = parent(index);
			}
		}
	}
	
	private Boolean indexInRange(Integer index){
		return index-1  < heapsize();
	}
	
	public E getHead(){
		return get(1);
	}
	
	public E extractHead(){
		if(heapsize() < 1){
			//TODO: Error - heap underflow
		}
		E head = get(1);
		exchange(1, heapsize());
		remove(heapsize());
		heapify(1);
		return head;
	}
	
	public void insert(E newElement){
		add(newElement);
		adjustKey(heapsize(), newElement);
	}
	
	private void buildHeap(){
		for(int i = heapsize()/2; i > 0; i--){
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
		E left = get(l);
		E right = get(r);
		
		set(l, right);
		set(r, left);
	}
	
	private Integer findLargest(Integer l, Integer r, Integer root){
		Integer largest;
		if(l <= heapsize() && inOrder(get(l), get(root))){
			largest = l;
		} else {
			largest = root;
		}
		if(r <= heapsize() && inOrder(get(r), get(largest))){
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
	
	protected abstract Boolean inOrder(E l, E r);
}
