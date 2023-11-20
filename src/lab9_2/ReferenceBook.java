package lab9_2;

import java.util.List;

public class ReferenceBook extends Book {
	private String category;
	private List<Chapter> chapters;

	public ReferenceBook(String title, int numOfPage, int yearOfPublic, String author, double price, 
			String type, List<Chapter> chapters) {
		super(title, numOfPage, yearOfPublic, author, price);
		this.category = type;
		this.chapters = chapters;
	}

	@Override
	public String getType() {
		return "Reference Book";
	}

	@Override
	public boolean isMagazine10YearOld() {
		return false;
	}
	
	public List<Chapter> getChaper() {
		return this.chapters;
	}

	@Override
	public boolean isReferenceBook() {
		return true;
	}

	@Override
	public boolean isMagazine() {
		return false;
	}

	@Override
	public String getName() {
		return "";
	}
	
	@Override
	public void addChapter(Chapter chapter) {
		chapters.add(chapter);
	}
	
	public int getLongestChapter() {
		int max = 0;
		for(Chapter c : chapters) {
			if (c.getLength() >= max) {
				max = c.getLength();
			}
		}
		return max;
	}

	@Override
	public List<Chapter> getChapters() {
		return this.chapters;
	}
	
	

}
