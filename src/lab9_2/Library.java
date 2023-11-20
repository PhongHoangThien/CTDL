package lab9_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import lab9_1.Course;
import lab9_1.Student;

public class Library {
	private List<Book> books;

	public Library(List<Book> books) {
		super();
		this.books = books;
	}

	public double sumPriceOfAllBook() {
		double result = 0.0;
		for (Book item : books) {
			result += item.price;
		}
		return result;
	}

	public Book getBookHasLongestChapter() {
		Book result = null;
		int max = 0;
		for (Book item : books) {
			if (item.isReferenceBook() && item.getLongestChapter() >= max) {
				max = item.getLongestChapter();
				result = item;
			}
		}
		return result;
	}

	public boolean containMagazineByName(String name) {
		for (Book item : books) {
			if (item.isMagazine() && item.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public List<Book> groupMagazineByYear(int year) {
		List<Book> result = new ArrayList<Book>();
		for (Book item : books) {
			if (item.isMagazine() && item.yearOfPublic == year) {
				result.add(item);
			}
		}
		return result;
	}

	public void sort() {
		books.sort(new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				int result = o1.title.compareTo(o2.title);
				if (result != 0) {
					return result;
				}
				else {
					return (-o1.yearOfPublic) + o2.yearOfPublic;
				}
			}

		});
	}
	
	public Map<Integer, Integer> groupOfBookByYear() {
		Map<Integer, Integer> result = new TreeMap<Integer, Integer>();
		for (Book item : books) {
			result.put(item.getYearOfPublic(), result.getOrDefault(item.getYearOfPublic(), 0)+1);
		}
		return result;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public String toString() {
		String result = "";
		for (Book item : books) {
			result += item.toString();
		}
		return result;
	}
}
