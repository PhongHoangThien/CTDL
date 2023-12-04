package lab12_task1;

public class Date {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String toSting() {
		return "[" + day + "/" + month + "/" + year + "]";
	}
}
