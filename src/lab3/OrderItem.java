package lab3;

public class OrderItem implements Comparable<OrderItem>{
	private Product p;
	private int quality;

	public OrderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quality = quality;
	}
	
	public double getPrice() {
		return this.p.getPrice();
	}
	
	public Product getProduct(){
		return this.p;
	}

	@Override
	public int compareTo(OrderItem o) {
		return this.p.compareTo(o.p);
	}
	
	public String getType() {
		return this.p.getType();
	}
	
	public String toString() {
		return this.p.toString() + " : " + quality + "\n";
	}
	
}
