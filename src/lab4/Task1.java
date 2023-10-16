package lab4;

import java.util.Arrays;

public class Task1 {

	// task 1.1: selection sort sort by descending order
	// iterative way
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int maxIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[maxIndex]) {
					maxIndex = j;
				}
			}
			if (maxIndex != i) {
				swap(array, i, maxIndex);
			}
		}
	}

	// recursive way
	public static int[] selectionSortRecursive(int[] array, int stepNum) {
		if (stepNum > array.length - 1) return array;
		else {
			int maxIndex = stepNum;
			for (int i = stepNum; i < array.length; i++) {
				if (array[i] > array[maxIndex]) {
					maxIndex = i;
				}
			}
			if (maxIndex != stepNum) {
				swap(array, stepNum, maxIndex);
			}
		}
		return selectionSortRecursive(array, stepNum+1);
	}
	
	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	// task 1.2: bubble sort by descending order
	// iterative way
	public static void bubbleSort(int[] array) {
		boolean stop = true;
		for (int k = 0; k < array.length; k++) {
			for (int i = 0; i < array.length-1-k; i++) {
				if (array[i] < array[i + 1]) {
					swap(array, i, i+1);
					stop = false;
				}
			}
			if (stop) {
				break;
			}
		}
	}

	// recursive way
	public static void bubbleSortRecursive(int[] array, int n) {
		boolean stop = true;
		if (n == 1) return;
		
		for (int i = 0; i < n-1; i++) {
			if (array[i] < array[i+1]) {
				swap(array, i, i+1);
				stop = false;
			}
		}
		if (stop) {
			return;
		}
		bubbleSortRecursive(array, n-1);
	}

	// task 1.3: insertion sort by descending order
	// iterative way
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int tmp = array[i];
			int j = i;
			while (j > 0 && array[j - 1] < tmp) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = tmp;
		}
	}

	// recursive way
	public static void insertionSortRecursive(int[] array, int n) {
		if (n <= 1) return;
		
		insertionSortRecursive(array, n-1);
		int last = array[n-1];
		int j = n-2;
		while (j >= 0 && array[j] < last) {
			array[j+1] = array[j];
			j--;
		}
		array[j+1] = last;
	}

	// task 1.4: sort object


	public static void main(String[] args) {
		int[] arr1 = { 3,6,9,1,7,5,0 };
		int[] arr2 = { 3,6,9,1,7,5,0 };
		int[] arr3 = { 3,6,9,1,7,5,0 };
		int[] arr4 = { 3,6,9,1,7,5,0 };
		int[] arr5 = { 3,6,9,1,7,5,0 };
		int[] arr6 = { 3,6,9,1,7,5,0 };
		
		selectionSort(arr1);
		selectionSortRecursive(arr2, 0);
		bubbleSort(arr3);
		bubbleSortRecursive(arr4, arr4.length);
		insertionSort(arr5);
		insertionSortRecursive(arr6, arr6.length);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.toString(arr5));
		System.out.println(Arrays.toString(arr6));
	}
}
