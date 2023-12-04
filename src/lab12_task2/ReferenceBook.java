package lab12_task2;

import java.util.List;

public class ReferenceBook extends Book {
	private String category;
	private List<Chapter> chapters;

	public ReferenceBook(String title, int numOfPage, int yearOfRepublic, String author, double price, String category,
			List<Chapter> chapters) {
		super(title, numOfPage, yearOfRepublic, author, price);
		this.category = category;
		this.chapters = chapters;
	}

}
