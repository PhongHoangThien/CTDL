package lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import lab7.WordCount;

public class TextAnalyzer {
	// <word, its positions>
//	public static final String fileName = "data/short.txt";
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	public TextAnalyzer() throws IOException {
		this.load("data/short.txt");
	}
	
	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int index = 1;
		while (true) {
			line = reader.readLine();
			
			if (line == null)
				break;
			
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				String word = tokens.nextToken();
				if (!tokens.hasMoreTokens()) {
					add(word, -index);
				}
				else {
					add(word, index);
				}
				index++;
			}
		}
		reader.close();
	}
	
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file
	public void add(String word, int position) {
		ArrayList<Integer> listPosition = new ArrayList<Integer>();
		listPosition.add(position);
		if (!map.containsKey(word)) {
			map.put(word, listPosition);
		}
		else {
			listPosition.addAll(map.get(word));
			map.put(word, listPosition);
		}
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		TreeMap<String, List<Integer>> tree = new TreeMap<String, List<Integer>>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		tree.putAll(map);
		System.out.println("Word\tWord position(s)");
		System.out.println("========================");
		for (String key : tree.keySet()) {
			System.out.println(key + "\t" + tree.get(key));
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		Map<Integer, String> result = new TreeMap<Integer, String>();
		for (String word : map.keySet()) {
			for (int i = 0; i < map.get(word).size(); i++) {
				if (map.get(word).get(i) < 0) {
					result.put(- (map.get(word).get(i)), word + "\n");
				}
				else {
					result.put(map.get(word).get(i), word + " ");
				}
			}
		}
		
		for (Integer key : result.keySet()) {
			System.out.print(result.get(key));
		}
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		Map<Integer, String> result = new TreeMap<Integer, String>();
		int tmp = 0;
		for (String word : map.keySet()) {
			result.put(map.get(word).size(), word);
			tmp = Math.max(tmp, map.get(word).size());
		}
		
		return result.get(tmp);
	}
	
	public static void main(String[] args) throws IOException {
		TextAnalyzer test = new TextAnalyzer();
		
		System.out.println(test.map);
		System.out.println();
		
		test.displayWords();
		System.out.println();
		
		test.displayText();
		System.out.println();
		
		System.out.println(test.mostFrequentWord());
	}

}
