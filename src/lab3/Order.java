package lab3;

import java.util.Arrays;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	public double cost() {
		double result = 0;
		for (int i = 0; i < items.length; i++) {
			result += items[i].getPrice();
		}
		return result;
	}

	public boolean contains(Product p) {
		Arrays.sort(this.items);
		int low = 0;
		int high = items.length-1;
		while (low <= high) {
			int mid = (low+high)/2;
			if (p.compareTo(items[mid].getProduct()) == 0) {
				return true;
			}
			if(p.compareTo(items[mid].getProduct()) < 0) high = mid - 1;
			else low = mid + 1;
		}
		return false;
	}

	public Product[] filter(String type) {
		int count = 0;
		for (int i = 0; i < items.length; i++) {
			if(items[i].getType().equals(type)) count++;
		}
		Product[] result = new Product[count];
		for (int i = 0; i < items.length; i++) {
			if(items[i].getType().equals(type)) {
				result[--count] = items[i].getProduct();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Product p1 = new Product("001", "sua chua", 7000, "drink");
		Product p2 = new Product("002", "thit bo", 250000, "food");
		Product p3 = new Product("003", "xa lach", 5000, "vegetable");
		Product p4 = new Product("004", "cocacola", 10000, "drink");
		Product p5 = new Product("005", "thit heo", 150000, "food");
		Product p6 = new Product("006", "thit heo", 1000000000, "food");
		
		OrderItem orderItem1 = new OrderItem(p1, 9);
		OrderItem orderItem2 = new OrderItem(p2, 8);
		OrderItem orderItem3 = new OrderItem(p3, 10);
		OrderItem orderItem4 = new OrderItem(p4, 10);
		OrderItem orderItem5 = new OrderItem(p5, 7);
		
		OrderItem[] listItem = {orderItem1, orderItem2, orderItem3, orderItem4, orderItem5};
		Order order = new Order(listItem);
		
		System.out.println(order.cost());
		System.out.println(order.contains(p1));
		System.out.println(order.contains(p6));
		System.out.println(Arrays.toString(order.filter("drink")));
	}
}
