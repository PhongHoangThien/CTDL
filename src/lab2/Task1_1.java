package lab2;

public class Task1_1 {
	// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		if (n <= 0) return 0; 
		else {
			return  getSn1(n-1) + n * pow(-1, n+1);
		}
	}
	public static int pow(int num, int powNum) {
		if(powNum == 0) return 1;
		return num *= pow(num, powNum - 1);
	}
	
	// S(n)=1+1.2+1.2.3+…+1.2.3…n, n>0
	public static int getSn2(int n) {
		if (n <= 0) return 0;
		else {
			return factorial(n) + getSn2(n-1);
		}
	}
	public static int factorial(int n) {
		if (n < 0) return 0;
		if (n == 0) return 1;
		else 
			return n * factorial(n - 1);
		
	}

	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		if (n <= 0) return 0;
		else {
			return pow(n, 2) + getSn3(n-1);
		}
	}

	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6.2n), n>=0
	public static double getSn4(int n) {
		if (n == 0) return 1;
		else {
			return (1 / sn4Helper(n)) + getSn4(n-1);
		}
	}
	public static double sn4Helper(int n) {
		if (n <= 0) return 1;
		else {
			return 2 * n * sn4Helper(n-1);
		}
	}

	public static void main(String[] args) {
		System.out.println(getSn1(7));
		System.out.println(getSn2(4));
		System.out.println(getSn3(4));
		System.out.println(getSn4(4));
	}
}
