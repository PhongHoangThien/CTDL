package lab12_task3;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {
	private String name;
	private List<Book> books;
	
	public Library() {
		
	}
	
	// trả về quyển sách được xuất bản lâu nhất
	public Book getOldestBook() {
		return null;
	}
	
	// thống kê các quyển sách theo năm, với key là năm xuất bản 
	// và value là các quyển sách xuất bản trong năm đó
	public Map<Integer, List<Book>> getBooksByYears (){
		return null;
	}
	
	// trả về các quyển sách có năm xuất bản là tham số year 
	//và tên tác giả là tham số authorName
	// sắp xếp theo thứ tự bảng chữ cái của tiêu đề
	public Set<Book> findBooks(String authorName, int year){
		return null;
	}
}
