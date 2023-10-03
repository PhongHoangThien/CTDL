package lab3;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearchHelper(target, 0);
	}
	public int recursiveLinearSearchHelper(int target, int startPos) {
		if (startPos == array.length) return -1;
		if (target == array[startPos]) {
			return startPos;
		}
		return recursiveLinearSearchHelper(target, startPos+1);
		
	}
	
	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low+high)/2;
			if (target == array[mid]) return mid;
			if (target < array[mid] ) high = mid - 1;
			else low = mid + 1;
		}
		return -1;
	}
	//descending order array
	public int iterativeBinarySearchDescendingOrder(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low+high)/2;
			if (target == array[mid]) return mid;
			if (target > array[mid] ) high = mid - 1;
			else low = mid + 1;
		}
		return -1;
	}
	
	public int recursiveBinarySearch(int target) {
		return BinarySearchHelper(target, 0, array.length-1);
	}
	public int BinarySearchHelper(int target, int low, int high) {
		if (low > high) return -1;
		int mid = (low + high)/2;
		if (target == array[mid]) return mid;
		if (target < array[mid]) {
			return BinarySearchHelper(target, low, mid-1);
		}
		else {
			return BinarySearchHelper(target, mid + 1, high);
		}
	}
	//descending order array
	public int recursiveBinarySearchDescendingOrder(int target) {
		return BinarySearchDescendingOrderHelper(target, 0, array.length-1);
	}
	public int BinarySearchDescendingOrderHelper(int target, int low, int high) {
		if (low > high) return -1;
		int mid = (low + high)/2;
		if (target == array[mid]) return mid;
		if (target > array[mid]) {
			return BinarySearchDescendingOrderHelper(target, low, mid-1);
		}
		else {
			return BinarySearchDescendingOrderHelper(target, mid+1, high);
		}
	}
	
	public static void main(String[] args) {
//		int[] arr = {9,7,6,5,4,3,1,0};
		int[] arr = {9,7,6,5,4,3,1,0};
//		int[] arr = {0,2,3,5,7,9};
		MyArray myArray = new MyArray(arr);
		System.out.println(myArray.recursiveBinarySearchDescendingOrder(1));
	}
}
