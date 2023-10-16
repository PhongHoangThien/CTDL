package lab4;

import java.util.Arrays;
import java.util.Random;

public class Task2 {

	// task 2.1: merge sort by descending order
	// recursive way
	public static void mergeSortRecursive(int[] array, int l, int r) {
		if (array.length == 1) {
			return;
		}
		
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSortRecursive(array, l, mid);
			mergeSortRecursive(array, mid + 1, r);
			
			merge(array, l, mid, r);
		}
	}

	private static void merge(int[] array, int l, int mid, int r) {
		int[] leftArray = new int[mid-l+1];
		int[] rightArray = new int[r-mid];
		
		for (int i = 0; i < leftArray.length; i++) {
			leftArray[i] = array[l+i];
		}
		for (int j = 0; j < rightArray.length; j++) {
			rightArray[j] = array[mid+1+j];
		}
		
		int i = 0, j = 0, k = l;
		while (i < leftArray.length && j < rightArray.length) {
			if (leftArray[i] >= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			}
			else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		while (i < leftArray.length) {
	        array[k] = leftArray[i];
	        i++;
	        k++;
	    }
	    while (j < rightArray.length) {
	        array[k] = rightArray[j];
	        j++;
	        k++;
	    }
	}

	// task 2.2: quick sort by ascending order
	// recursive way
	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
//			int pivot = getPivot_MedianOfThree(array, low, high);
//			int pivot = getPivot_First(array, low);
			int pivot = getPivot_Last(array, high);
//			int pivot = getPivot_Random(array, low, high);
			int partitionIndex = partition(array, low, high, pivot);
			
			quickSort(array, low, partitionIndex-1);
			quickSort(array, partitionIndex+1, high);
		}
	}

	private static int partition(int[] array, int low, int high, int pivot) {
		int i = low - 1;

	    for (int j = low; j < high; j++) {
	        if (array[j] < pivot) {
	            i++;
	            swap(array, i, j);
	        }
	    }

	    swap(array, i + 1, high);

	    return i + 1;
	}
	
	// select pivot element based on the median of three strategy
	private static int getPivot_MedianOfThree(int[] array, int low, int high) {
		int mid = (low + high) / 2;

	    if (array[low] > array[mid])
	        swap(array, low, mid);
	    if (array[low] > array[high])
	        swap(array, low, high);
	    if (array[mid] > array[high])
	        swap(array, mid, high);

	    return array[mid];
	}

	// select pivot element based on the first element in the array
	private static int getPivot_First(int[] array, int low) {
		return array[low];
	}

	// select pivot element based on the last element in the array
	private static int getPivot_Last(int[] array, int high) {
		return array[high];
	}

	// select pivot element based on choosing a randomly element in the array
	private static int getPivot_Random(int[] array, int low, int high) {
		Random rand = new Random();
	    int randomIndex = rand.nextInt(high - low + 1) + low;
	    return array[randomIndex];
	}
	
	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static void main(String[] args) {
		int[] arr1 = { 3, 6, 9, 1, 7, 5, 0 };
		int[] arr2 = { 3, 6, 9, 1, 7, 5, 0 };
		
		mergeSortRecursive(arr1, 0, arr1.length-1);
		System.out.println(Arrays.toString(arr1));
		
		quickSort(arr2, 0, arr2.length-1);
		System.out.println(Arrays.toString(arr2));
	}
}
