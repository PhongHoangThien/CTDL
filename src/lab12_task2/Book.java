package lab12_task2;

public abstract class Book {
	protected String title;
	protected int numOfPage;
	protected int yearOfRepublic;
	protected String author;
	protected double price;

	public Book(String title, int numOfPage, int yearOfRepublic, String author, double price) {
		super();
		this.title = title;
		this.numOfPage = numOfPage;
		this.yearOfRepublic = yearOfRepublic;
		this.author = author;
		this.price = price;
	}
}
