package sorting;

import java.lang.Comparable;

public class ArraySorter {
	// Method that uses generics instead
//	public <E extends Comparable<E>> void quicksort(E[] array){
//		
//	}
	
	// Standard String compare method
	public void quicksort(String[] array){
		quicksortSubArray(array, 0, array.length-1);
	}
	
	private void quicksortSubArray(String[] array, int start, int end){
		if(start < end){
			int middle = partition(array, start, end);
			quicksortSubArray(array, start, middle-1);
			quicksortSubArray(array, middle+1, end);
		}
	}
	
	private int partition(String[] array, int start, int end){
		String endElement = array[end];
		int i = start -1;
		// Use <= so that array[end-1] is also considered
		for(int j=start; j<=end-1; j++){
			if(array[j].compareTo(endElement) <= 0){
				i++;
				exchange(array, i,j);
			}
		}
		exchange(array, i+1, end);
		return i+1;
	}
	
	private void exchange(String[] array, int i, int j){
		String tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
}
