package lab12_task1;

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class OrderManager {
	private List<Order> orders;
	
	public OrderManager() {
		
	}
	
	// tìm ra sản phẩm có giá bán cao nhất
	public Product maxProduct() {
		return orders.stream().flatMap(order -> order.getItems().stream())
				.map(OrderItem::getItem)
				.max((product1, product2) -> (product1.getPrice() - product2.getPrice()))
				.orElse(null);
	}
	
	// trả về loại sản phẩm và số lượng bán ra cho mỗi loại
	public HashMap<String, Integer> productTypesStatistics(){
		return null;
	}
	
	// trả về danh sách các hóa đơn sắp xếp giảm 
	// dần theo giá trị của hóa đơn và ngày.
	public TreeSet<Order> ordersByCost() {
		return null;
	}
}
