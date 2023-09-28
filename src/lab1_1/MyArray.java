package lab1_1;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}
	
	public int[] mirror() {
		int[] mirrorArray = new int[this.array.length*2];
		
		for (int i = 0; i < this.array.length; i++) {
			mirrorArray[i] = array[i];
			mirrorArray[mirrorArray.length-1-i] = array[i];
		}
		return mirrorArray;
	}
	
	public int[] removeDuplicates() {
		int count = 0;
		boolean isNotDuplicate;
		int[] removeDupArray = new int[this.array.length];
		
		for (int i = 0; i < removeDupArray.length; i++) {
			isNotDuplicate = true;
			for (int j = 0; j < count; j++) { 
				if (removeDupArray[j] == this.array[i]) {
					//kiểm tra nếu số nào trùng thì chuyển qua false để không chạy if ở dưới
					isNotDuplicate = false;
					break;
				}
			}
			//nếu không trùng với phần tử nào thì phần tử thứ count sẽ được thêm vào mảng
			if (isNotDuplicate) {
				//ban đầu count=0, isNotDuplicate=true
				//count=3, isNotDuplicate=false và số 1 ở vị trí thứ 3 trong mảng sẽ ko đc thêm vào
				removeDupArray[count] = this.array[i];
				count++;
			}
		}
		
		int[] result = new int[count];
		for (int i = 0; i < result.length; i++) {
			result[i] = removeDupArray[i];
		}
		
		return result;
	}
	
	public int[] getMissingValues() {
		int count = 0;
		int[] result;
		int[] array = this.array.clone();
		
		for (int i = 0; i < array.length-1; i++) {
			if (array[i+1]== array[i] + 1) {
				count++;
			}
		}
		result = new int[array.length-count-1];
		
		for (int i = 0; i < array.length-count-1; i++) {
			for (int j = 0; j < array.length-1; j++) {
				if (array[j+1] != array[j] + 1) {
					result[i] = array[j] + 1;
					i++;
				}
			}
		}
		return result;
	}
	
	public int[] fillMissingValues(int k) {
		int[] result = array.clone();
		for (int i = 0; i < result.length-1; i++) {
			if (array[i] > result[i+1]) {
				result[i+1] = searchValueToFill(result, i+1, k) / k;
			}
		}
		
		return result;
	}
	public int searchValueToFill(int[] arr, int index, int k) {
		int result = 0;
		int count = 0;
		for (int j = Math.max(0, index - 1); j <= Math.min(index + k, arr.length - 1); j++) {
            if (j != index && count < k) {
                result += arr[j];
                count++;
            }
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] array1 = {1,2,3};
		int[] array2 = {1,3,5,1,7,3,8};
		int[] array3 = {10, 11, 12, 13, 14, 16, 17, 19, 20};
		int[] array4 = {10, 11, 12, -1, 14, 10, 17, 19, 20};
		
		MyArray myArray1 = new MyArray(array1);
		MyArray myArray2 = new MyArray(array2);
		MyArray myArray3 = new MyArray(array3);
		MyArray myArray4 = new MyArray(array4);
		
		System.out.println(Arrays.toString(myArray1.mirror()));
		System.out.println(Arrays.toString(myArray2.removeDuplicates()));
		System.out.println(Arrays.toString(myArray3.getMissingValues()));
		System.out.println(Arrays.toString(myArray4.fillMissingValues(3)));
	}
}
