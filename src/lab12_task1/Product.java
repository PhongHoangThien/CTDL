package lab12_task1;

public class Product {
	private String name;
	private String type;
	private int price;
	private Date expriredDate;
	
	public Product(String name, String type, int price, Date expriredDate) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.expriredDate = expriredDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getExpriredDate() {
		return expriredDate;
	}

	public void setExpriredDate(Date expriredDate) {
		this.expriredDate = expriredDate;
	}
	
	
	
}
