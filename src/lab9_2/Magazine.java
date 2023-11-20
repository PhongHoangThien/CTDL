package lab9_2;

import java.util.List;

public class Magazine extends Book {
	private String name;

	public Magazine(String title, int numOfPage, int yearOfPublic, String author, double price, String name) {
		super(title, numOfPage, yearOfPublic, author, price);
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		return "Magazine";
	}

	@Override
	public boolean isMagazine10YearOld() {
		return (2021 - yearOfPublic) >= 10;
	}

	@Override
	public boolean isReferenceBook() {
		return false;
	}

	@Override
	public boolean isMagazine() {
		return true;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public List<Chapter> getChapters() {
		return null;
	}

	@Override
	public int getLongestChapter() {
		return 0;
	}

	@Override
	public void addChapter(Chapter chapter) {
	}

}
