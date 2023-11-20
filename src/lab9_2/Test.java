package lab9_2;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Chapter c1 = new Chapter("1", 20);
		Chapter c2 = new Chapter("2", 50);
		Chapter c3 = new Chapter("3", 100);
		Chapter c4 = new Chapter("4", 10);
		Chapter c5 = new Chapter("5", 300);
		
		Book b1 = new ReferenceBook("A", 200, 2001, "Q", 200.0, "Z", new ArrayList<Chapter>());
		b1.addChapter(c1);
		b1.addChapter(c2);
		
		Book b2 = new ReferenceBook("A", 300, 2010, "Q", 250.0, "X", new ArrayList<Chapter>());
		b2.addChapter(c3);
		b2.addChapter(c5);
		
		Book b3 = new ReferenceBook("C", 450, 2010, "W", 350.0, "C", new ArrayList<Chapter>());
		b3.addChapter(c2);
		b3.addChapter(c4);
		
		Book b4 = new ReferenceBook("D", 150, 1992, "E", 150.0, "V", new ArrayList<Chapter>());
		b4.addChapter(c1);
		b4.addChapter(c2);
		b4.addChapter(c4);
		
		Book b5 = new Magazine("F", 100, 2017, "Q", 10.0, "X");
		Book b6 = new Magazine("G", 70, 2017, "T", 20.0, "Y");
		Book b7 = new Magazine("H", 110, 2010, "Y", 20.0, "Z");
		
		Library test = new Library(new ArrayList<Book>());
		test.addBook(b1);
		test.addBook(b2);
		test.addBook(b3);
		test.addBook(b4);
		test.addBook(b5);
		test.addBook(b6);
		test.addBook(b7);
		
		//task 6
		System.out.println(b1.isReferenceBook());
		System.out.println(b1.isMagazine());
		
		//task 7
		System.out.println(b7.isMagazine10YearOld());
		System.out.println(b5.isMagazine10YearOld());
		
		//task 8
		System.out.println(b1.isSameTypeAndAuthor(b2));
		System.out.println(b1.isSameTypeAndAuthor(b5));
		
		//task 9
		System.out.println(test.sumPriceOfAllBook());
		
		//task 10
		System.out.println("task 10\n" + test.getBookHasLongestChapter()); //b2 chứa chapter c5 dài nhất: 300 trang
		
		//task 11
		System.out.println("task 11: " + test.containMagazineByName("Z") + "\n");
		
		//task 12
		System.out.println("task 12\n" + test.groupMagazineByYear(2017));
		
		//task 13
		test.sort();
		System.out.println("task 13\n" + test.toString());
		
		//task 14
		System.out.println("task 14: " + test.groupOfBookByYear());
	}
}
