package sorting;

import java.lang.Comparable;
import java.util.Arrays;
import heap.Heap;

public class HeapSort {

	/**
	 * Sorts an array of elements using HeapSort. 
	 * Elements must be comparable
	 * @param elements Array of unsorted elements
	 * @return Array of sorted elements
	 */
	public static <E extends Comparable<E>> Heap<E> sort(E[] elements){
		checkArrayIsNotNull(elements);
		checkArrayIsFull(elements);
		return heapSort(elements);
	}
	
	public static <E> void checkArrayIsNotNull(E[] elements) throws NullPointerException{
		if(elements == null){
			throw new NullPointerException("Array to sort must contain elements");
		}
	}
	
	public static <E> void checkArrayIsFull(E[] elements) throws IllegalArgumentException{
		if(Arrays.asList(elements).contains(null)){
			throw new IllegalArgumentException("Array to sort must not contain null values");
		}
	}
	
	private static <E extends Comparable<E>> Heap<E> heapSort(E[] elements){
		Heap<E> heap = new Heap<E>(elements);
		for(int i=elements.length; i > 1; i--){
			heap.exchange(1, i);
			heap.heapsize--;
			heap.maxHeapify(1);
		}
		return heap;
	}	
}
