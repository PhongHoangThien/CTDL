package lab5;

import java.util.Arrays;

public class Task1 {
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) {
			return null;
		}
		
		int[][] result = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		return result;
	}
	
	// subtract 2 matrices
	public static int[][]subtract(int[][] a, int[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) {
			return null;
		}
		
		int[][] result = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				result[i][j] = a[i][j] - b[i][j];
			}
		}
		return result;
	}
	
	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		if (a[0].length != b.length) {
			return null;
		}
		
		int[][] result = new int[a.length][b[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				for (int k = 0; k < b.length; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return result;
	}
	
	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
		int[][] result = new int[a[0].length][a.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = a[j][i];
			}
		}
		return result;
	}

	
	public static void main(String[] args) {
		int[][] matrix1 = {{1,2,3},
							{4,5,6},
							{7,8,9}};
		int[][] matrix2 = {{9,8,7},
							{6,5,4},
							{3,2,1}};
		int[][] matrix3 = {{9,8},
							{6,5},
							{3,2}};
		
		System.out.println(Arrays.deepToString(add(matrix1, matrix2)).replace("], ", "]\n"));
		System.out.println();
		System.out.println(Arrays.deepToString(subtract(matrix1, matrix2)).replace("], ", "]\n"));
		System.out.println();
		System.out.println(Arrays.deepToString(multiply(matrix1, matrix3)).replace("], ", "]\n"));
		System.out.println();
		System.out.println(Arrays.deepToString(transpose(matrix3)).replace("], ", "]\n"));
	}
}
