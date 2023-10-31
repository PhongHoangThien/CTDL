package lab7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
//	 public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() throws IOException {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Returns a set of WordCount objects that represents the number of times each
	// unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> result = new ArrayList<WordCount>();
		for (String str : words) {
			int count = 0;
			for (String str2 : words) {
				if (str.equals(str2)) {
					count++;
				}
			}
			WordCount current = new WordCount(str, count);
			if (!result.contains(current)) {
				result.add(current);
			}
		}
		return result;
	}

	// Returns the words that their appearances are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		List<WordCount> getWordCounts = getWordCounts();
		Set<String> result = new HashSet<String>();
		for (WordCount word : getWordCounts) {
			if (word.getCount() == 1) {
				result.add(word.getWord());
			}
		}
		return result;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> result = new HashSet<>(words);
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		Set<WordCount> result = new HashSet<>(getWordCounts());
		for (WordCount word : result) {
			System.out.print(word.toString() + ", ");
		}
		System.out.println();
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> exportWordCounts() {
		Set<WordCount> result = new TreeSet<>(new Comparator<WordCount>() {
			
			@Override
			public int compare(WordCount o1, WordCount o2) {
				return o1.getWord().compareTo(o2.getWord());
			}
			
		});
		result.addAll(getWordCounts());
		for (WordCount word : result) {
			System.out.print(word.toString() + ", ");
		}
		System.out.println();
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsOrderByOccurence() {
		Set<WordCount> result = new TreeSet<>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				if ((o2.getCount() - o1.getCount()) == 0) {
					return o1.getWord().compareTo(o2.getWord());
				}
				return o2.getCount() - o1.getCount();
			}
			
		});
		result.addAll(getWordCounts());
		for (WordCount word : result) {
			System.out.print(word.toString() + ", ");
		}
		System.out.println();
		return result;
	}

	// delete words beginning with the given pattern (i.e., delete words begin
	// with 'A' letter
	public Set<WordCount> filterWords(String pattern) {
		List<WordCount> wordCounts = getWordCounts();
		Set<WordCount> result = new HashSet<WordCount>();
		for (WordCount str : wordCounts) {
			// vì trong file hamlet.txt có những từ chỉ có 1 < pattern.length() nên không thể dùng subString()
			int check = str.getWord().indexOf(pattern.charAt(0));
			if (check == -1) {
				result.add(str);
			}
			else {
				// vì str có thể ít kí tự hơn hoặc pattern ít kí tự hơn 
				// nên chạy for từ index 0 --> min(2 length)
				for (int i = 1; i < Math.min(str.getWord().length(), pattern.length()); i++) {
					if (str.getWord().charAt(i) != pattern.charAt(i)) {
							result.add(str);
							break;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		MyWordCount test = new MyWordCount();

		System.out.println(test.getWordCounts());
		System.out.println(test.getUniqueWords());
		System.out.println(test.getDistinctWords());
		test.printWordCounts();
		test.exportWordCounts();
		test.exportWordCountsOrderByOccurence();
		System.out.println(test.filterWords("ho"));
		
	}
}
