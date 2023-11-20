package lab9_2;

import java.util.List;

public abstract class Book {
	protected String title;
	protected int numOfPage;
	protected int yearOfPublic;
	protected String author;
	protected double price;
	
	public Book(String title, int length, int yearOfPublic, String author, double price) {
		this.title = title;
		this.numOfPage = length;
		this.yearOfPublic = yearOfPublic;
		this.author = author;
		this.price = price;
	}
	
	public abstract boolean isReferenceBook();
	public abstract boolean isMagazine();
	public abstract String getType();
	public abstract boolean isMagazine10YearOld();
	public abstract String getName();
	public abstract List<Chapter> getChapters();
	public abstract int getLongestChapter();
	public abstract void addChapter(Chapter chapter);
	
	public boolean isSameTypeAndAuthor(Book b) {
		return this.getType().equals(b.getType()) && this.author.equals(b.author);
	}
	

	public String getTitle() {
		return title;
	}

	public int getNumOfPage() {
		return numOfPage;
	}

	public int getYearOfPublic() {
		return yearOfPublic;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return title + ", " + yearOfPublic + ", " + author + "\n";
	}
	
}
