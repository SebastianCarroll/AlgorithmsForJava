package sorting;

public class MergeSort {
	public static <E> void sort(E[] elements){
		mergeSort(elements, 0, elements.length-1);
	}
	
	private static <E> void mergeSort(E[] elements, int start, int end){
		if(start < end){
			int middle = (start + end)/2;
			mergeSort(elements, start, middle);
			mergeSort(elements, middle+1, end);
			merge(elements, start, middle, end);
		}
	}
	
	private static <E> void merge(E[] elements, int start, int middle, int end){
		
	}
	
}
