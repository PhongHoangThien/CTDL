package lab2;

public class Task2 {
	//Task 2_1
	public static void drawPyramid(int n) {
		drawPyramidHelper(n, 1);
	}
	public static void drawPyramidHelper(int n, int starter) {
		if (starter > n) return;
		else {
			//print spaces
			for (int i = 0; i < n-starter; i++) {
				System.out.print(" ");
			}
			
			//print X
			for (int i = 0; i < starter; i++) {
				System.out.print("X ");
			}
			
			System.out.println();
			drawPyramidHelper(n, starter+1);
		}
	}
	public static void printSpaces(int numOfSpace) {
		if (numOfSpace == 0) return;
		else {
			System.out.print(" ");
			printSpaces(numOfSpace-1);
		}
	}
	
	//Task 2_2
	//pattern 1
	public static void pyramidPattern1(int n, int numOfSpace) {
		if (n == 0) return;
		else {
			pyramidPattern1(n-1, numOfSpace+1);
			
			printSpaces(numOfSpace);
			printPattern1(n, n);
			System.out.println();
		}
	}
	public static void printPattern1(int n, int nHelper) {
		if (n == 0) return;
		else {
			printPattern1(n-1, nHelper);
			System.out.print(nHelper + " ");
		}
	}
	
	//pattern 2
	public static void pyramidPattern2(int n, int numOfSpace) {
		if(n == 0) return;
		else {
			pyramidPattern2(n-1, numOfSpace+1);
			
			printSpaces(numOfSpace);
			printPattern2(n, 1);
			System.out.println();
		}
	}
	public static void printPattern2(int n, int starter) {
		if (starter == n) return;
		else {
			System.out.print(starter + " ");
			printPattern2(n, starter+1);
		}
	}
	
	//pattern 3
	public static void pyramidPattern3(int n, int numOfSpace) {
		if (n == 0) return;
		else {
			pyramidPattern3(n-1, numOfSpace+1);
			
			printSpaces(numOfSpace);
			printPattern3(n);
			System.out.println();
		}
	}
	public static void printPattern3(int n) {
		if (n == 0) return;
		else {
			printPattern3(n-1);
			System.out.print("* ");
		}
	}
	
	//pattern 4
	public static void pyramidPattern4(int n, int numOfSpace) {
		if (n == 0) return;
		else {
			pyramidPattern4(n-1, numOfSpace+1);
			
			printSpaces(numOfSpace);
			printSpaces(numOfSpace);
			printPattern4(n, 1);
			printPattern4Reverse(n);
			System.out.println();
		}
	}
	public static void printPattern4(int n, int starter) {
		if (starter == n) return;
		else {
			System.out.print(starter + " ");
			printPattern4(n, starter+1);
		}
	}
	public static void printPattern4Reverse(int n) {
		if (n == 0) return;
		else {
			System.out.print(n + " ");
			printPattern4Reverse(n-1);
		}
	}
	
	//pattern 5
	public static void pyramidPattern5(int n, int numOfSpace) {
		pattern5Helper(n, numOfSpace, n, 1);
	}
	public static void pattern5Helper(int n, int numOfSpace, int nHelper, int starter) {
		if (nHelper == 0) return;
		else {
			pattern5Helper(n, numOfSpace+1, nHelper-1, starter+1);
			
			printSpaces(numOfSpace);
			printSpaces(numOfSpace);
			printPattern5(n, starter);
			printPattern5Reverse(n, starter);
			System.out.println();
		}
	}
	public static void printPattern5(int n, int starter) {
		if (starter > n) return;
		else {
			System.out.print(starter + " ");
			printPattern5(n, starter+1);
		}
	}
	public static void printPattern5Reverse(int n, int starter) {
		if (starter >= n) return;
		else {
			printPattern5Reverse(n, starter+1);
			System.out.print(starter + " ");
		}
	}
	
	//pattern 6
	public static void pyramidPattern6(int n, int numOfSpcae) {
		if (n == 0) return;
		else {
			printSpaces(numOfSpcae);
			printPattern6(n);
			System.out.println();
			
			pyramidPattern6(n-1, numOfSpcae+1);
		}
	}
	public static void printPattern6(int n) {
		if (n == 0) return;
		else {
			printPattern3(n-1);
			System.out.print("* ");
		}
	}
	
	//pattern 7
	public static void pyramidPattern7(int n, int numOfSpace) {
		if (n == 0) return;
		else {
			printSpaces(numOfSpace);
			printPattern7(n, n);
			System.out.println();
			
			pyramidPattern7(n-1, numOfSpace+1);
		}
	}
	public static void printPattern7(int n, int nHelper) {
		if (n == 0) return;
		else {
			printPattern7(n-1, nHelper);
			System.out.print(nHelper + " ");
		}
	}
	
	//christmas tree
	public static void drawChristmasTree(int n, int numOfSpace) {
		if (n == 0) return;
		else {
			drawChristmasTree(n-1, numOfSpace+1);
			
			printTree(n, numOfSpace);
		}
	}
	public static void printTree(int n, int numOfSpace) {
		if (n == 0) return;
		else {
			printTree(n-1, numOfSpace+1);
			
			printSpaces(numOfSpace);
			printBranch(n*2-1);
			System.out.println();
		}
	}
	public static void printBranch(int branch) {
		if (branch == 0) return;
		else {
			printBranch(branch-1);
			
			System.out.print("x");
		}
	}

	public static void main(String[] args) {
		int lab2_1 = 4;
		int lab2_2 = 9;
		int lab2_3 = 4;
		
		drawPyramid(lab2_1);
		System.out.println();
		
		pyramidPattern1(lab2_2, 0);
		pyramidPattern2(lab2_2, 0);
		pyramidPattern3(lab2_2, 0);
		pyramidPattern4(lab2_2, 0);
		pyramidPattern5(lab2_2, 0);
		pyramidPattern6(lab2_2, 0);
		pyramidPattern7(lab2_2, 0);
		System.out.println();
		
		drawChristmasTree(lab2_3, 0);
	}
}
