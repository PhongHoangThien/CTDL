package lab12_task3;

import java.util.List;

public class Book {
	private String title;
	private String id;
	private int price;
	private String type;
	private List<Author> authors;

	public Book(String title, String id, int price, String type, List<Author> authors) {
		super();
		this.title = title;
		this.id = id;
		this.price = price;
		this.type = type;
		this.authors = authors;
	}

}
