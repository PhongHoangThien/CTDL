package lab2;

public class Fibonacci {
	// get the nth value of the Fibonacci series
	public static int getFibonacci(int n) {
		if (n == 1) return 0;
		if (n <= 3) return 1;
		else {
			int f1 = getFibonacci(n-1);
			int f2 = getFibonacci(n-2);
			return f1 + f2;
		}
	}

	// This method is used to display a Fibonaccci series based on
	//the parameter n.Ex.n=10==>0 1 1 2 3 5 8 13 21 34
	public static void printFibonacci(int n) {
		if (n <= 0) return;
		else {
			System.out.print(getFibonacci(n) + " ");
			printFibonacci(n-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getFibonacci(8));
		printFibonacci(10);
	}
}
