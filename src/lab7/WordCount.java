package lab7;

import java.util.ArrayList;
import java.util.List;

public class WordCount {
//	List<String> words = new ArrayList<String>();
	private String uniqueToken;
	private int numAppear = -1;
	
	
	
	public WordCount(String uniqueToken, int numAppear) {
		super();
		this.uniqueToken = uniqueToken;
		this.numAppear = numAppear;
	}

	public void count() {
		
	}
	
	public String toString() {
		return uniqueToken + ", " + numAppear + " times";
	}

	public String getUniqueToken() {
		return uniqueToken;
	}

	public void setUniqueToken(String uniqueToken) {
		this.uniqueToken = uniqueToken;
	}

	public int getNumAppear() {
		return numAppear;
	}

	public void setNumAppear(int numAppear) {
		this.numAppear = numAppear;
	}
	
	
}
