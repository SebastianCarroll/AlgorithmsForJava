package sorting;

import java.lang.Comparable;
import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort {
	public static <E extends Comparable<E>> void sort(E[] elements){
		checkArrayIsNotNull(elements);
		checkArrayIsFull(elements);
		mergeSort(elements, 0, elements.length-1);
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
	
	private static <E extends Comparable<E>> void mergeSort(E[] elements, int start, int end){
		if(start < end){
			int middle = (start + end)/2;
			mergeSort(elements, start, middle);
			mergeSort(elements, middle+1, end);
			merge(elements, start, middle, end);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <E extends Comparable<E>> void merge(E[] elements, int start, int middle, int end){
		// Find number of elements in left and right arrays
		int leftCount = middle-start+1;
		int rightCount = end-middle;
		
		// Initialise those arrays
		// Must use getClass and getComponent type so that array can be case to E
		E[] left = (E[]) Array.newInstance(elements.getClass().getComponentType(), leftCount+1);
		E[] right = (E[]) Array.newInstance(elements.getClass().getComponentType(), rightCount+1);
		
		fillLeftArray(left, elements, start, leftCount);
		fillRightArray(right, elements, middle, rightCount);
		
		orderedStack(elements, left, right, start, end);
	}
	
	private static <E> void fillLeftArray(E[] left, E[] elements, int offset, int end){
		int i;
		for(i = 0; i<end; i++){
			left[i] = elements[offset+i];
		}
		left[i] = null;
	}
	
	private static <E> void fillRightArray(E[] right, E[] elements, int offset, int end){
		int i;
		for(i = 0; i<end; i++){
			right[i] = elements[offset+i+1];
		}
		right[i] = null;
	}
	
	private static <E extends Comparable<E>> void orderedStack(E[] elements, E[] left, E[] right, int start, int end){
		int i = 0;
		int j = 0;
		for(int k=start; k<=end; k++){
			E leftElem = left[i];
			E rightElem = right[j];
			if(areInOrder(leftElem, rightElem)){
				elements[k] = leftElem;
				i++;
			} else {
				elements[k] = rightElem;
				j++;
			}
		}
	}
	
	private static <E extends Comparable<E>> Boolean areInOrder(E left, E right){
		if(left == null){
			return false;
		}else if(right == null){
			return true;
		} else {
			return (left.compareTo(right) <= 0 );
		}
	}
	
}
