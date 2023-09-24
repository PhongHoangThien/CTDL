package lab1_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	public static final char[] DIGIT = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET array
	public char encryptChar(char c) {
		// encrypt digit
		if (Character.isDigit(c)) {
			for (int i = 0; i < DIGIT.length; i++) {
				if (c == DIGIT[i]) {
					return DIGIT[(i + n) % DIGIT.length];
				}
			}
		}
		// encript alphabet
		else {
			for (int i = 0; i < ALPHABET.length; i++) {
				//encrypt uppercase
				if (Character.isUpperCase(c)) {
					if (c == ALPHABET[i]) {
						return ALPHABET[(i + n) % ALPHABET.length];
					}
				} 
				//encrypt lowercase
				else {
					if (Character.toUpperCase(c) == ALPHABET[i]) {
						return Character.toLowerCase(ALPHABET[(i + n) % ALPHABET.length]);
					}
				}

			}
		}
		return ' ';
	}

	// Decrypt a character according to the given shif steps.
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in the ALPHABET array
	public char decryptChar(char c) {
		// decrypt digit
		if (Character.isDigit(c)) {
			for (int i = 0; i < DIGIT.length; i++) {
				if (c == DIGIT[i]) {
					if (i >= n) {
						return DIGIT[(i - n) % DIGIT.length];
					} 
					else {
						return DIGIT[DIGIT.length - (n - i)];
					}
				}
			}
		}
		// decrypt alphabet
		else {
			for (int i = 0; i < ALPHABET.length; i++) {
				//decrypt uppercase
				if (Character.isUpperCase(c)) {
					if (c == ALPHABET[i]) {
						if (i >= n) {
							return ALPHABET[(i - n) % ALPHABET.length];
						} 
						else {
							return ALPHABET[ALPHABET.length - (n - i)];
						}
					}
				}
				//decrypt lowercase
				else {
					if (Character.toUpperCase(c) == ALPHABET[i]) {
						if (i >= n) {
							return Character.toLowerCase(ALPHABET[(i - n) % ALPHABET.length]);
						} 
						else {
							return Character.toLowerCase(ALPHABET[ALPHABET.length - (n - i)]);
						}
					}
				}
				
			}
		}

		return ' ';
	}

	// Encrypt a text using the above function for encrypting a charater.
	public String encrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += encryptChar(input.charAt(i));
		}
		return result;
	}

	// Decrypt a encrypted text using the above function for decrypting a charater.
	public String decrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += decryptChar(input.charAt(i));
		}
		return result;
	}

	// task 4
	public void encryptByUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("type your text to encrypt: ");
		String encryptText = sc.nextLine();
		System.out.println(encrypt(encryptText));
	}
	public void decryptByUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("type your text to decrypt: ");
		String decryptText = sc.nextLine();
		System.out.println(decrypt(decryptText));
	}
	
	//task 5
	// Encrypt a encrypted the text content in the srcfile and save it into desFile.
	public void encryptFile(String srcFile, String desFile) throws IOException {
		//read srcFile
		String text = TextFileUtils.readText(srcFile);
		
		//write the encrypted to desFile
		TextFileUtils.writeText(desFile, encrypt(text));
	}
	
	// Decrypt a encrypted the text content in the srcfile and save it into desFile.
	public void decryptFile(String srcFile, String desFile) throws IOException {
		//read srcFile
		String text = TextFileUtils.readText(srcFile);
		
		
		//write the decrypted to desFile
		TextFileUtils.writeText(desFile, decrypt(text));
	}

	public static void main(String[] args) throws IOException {
		MyCaesar myCaesar = new MyCaesar(5);

		System.out.println(myCaesar.encryptChar('z'));
		System.out.println(myCaesar.encryptChar('6'));
		System.out.println(myCaesar.encrypt("I am Groot in GOTG 1 2 3"));

		System.out.println(myCaesar.decryptChar('U'));
		System.out.println(myCaesar.decryptChar('1'));
		System.out.println(myCaesar.decrypt("N fr Lwtty ns LTYL 6 7 8"));

		// task 4
//		myCaesar.encryptByUser();
//		myCaesar.decryptByUser();
		
		//task 5
		myCaesar.encryptFile("./data/Lab1.txt", "./data/desFile1.txt");
		myCaesar.decryptFile("./data/desFile1.txt", "./data/desFile2.txt");
		System.out.println(TextFileUtils.readText("./data/Lab1.txt"));
		System.out.println(TextFileUtils.readText("./data/desFile1.txt"));
		System.out.println(TextFileUtils.readText("./data/desFile2.txt"));

	}
}
