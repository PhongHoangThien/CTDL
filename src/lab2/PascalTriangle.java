package lab2;

import java.util.Arrays;

public class PascalTriangle {
	// This method is used to display a Pascal triangle based on the parameter n.
	// Where n represents the number of rows
	public static void printPascalTriangle(int row) {
		if (row == 0)
			return;
		// TODO
		int[] rowArray = getPascalTriangle(row);

		printPascalTriangle(row - 1);
		for (int i = 0; i < rowArray.length; i++) {
			System.out.print(rowArray[i] + "  ");
		}
		System.out.println();
	}

	// get the nth row.
	// For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	public static int[] getPascalTriangle(int n) {
		if (n <= 0)
			return null;
		if (n == 1)
			return new int[]{1};
		else {
			int[] prevRow = getPascalTriangle(n-1);
			return generateNextRow(prevRow);
		}
	}

	// generate the next row based on the previous row
	// Ex. prevRow = {1} ==> nextRow = {1, 1}
	// Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	public static int[] generateNextRow(int[] prevRow) {
		int[] result = new int[prevRow.length+1];
		result[0] = 1;
		result[prevRow.length] = 1;
		for (int i = 1; i < prevRow.length; i++) {
			result[i] = prevRow[i] + prevRow[i-1];
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] arr = {1,3,3,1};
		System.out.println(Arrays.toString(generateNextRow(arr)));
		System.out.println(Arrays.toString(getPascalTriangle(8)));
		printPascalTriangle(8);
	}

}
