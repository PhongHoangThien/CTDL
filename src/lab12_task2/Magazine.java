package lab12_task2;

public class Magazine extends Book {
	private String name;

	public Magazine(String title, int numOfPage, int yearOfRepublic, String author, double price, String name) {
		super(title, numOfPage, yearOfRepublic, author, price);
		this.name = name;
	}
	
}
