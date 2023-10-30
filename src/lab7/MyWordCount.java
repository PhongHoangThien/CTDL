package lab7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/hamlet.txt";
	private List<String> words = new ArrayList<>();

	public MyWordCount() throws IOException {
		try {
			this.words.addAll(Utils.loadWord(fileName));
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
		
		int count = -1;
		for (int i = 0; i < words.size(); i++) {
			
		}
		return result;
	}

	// Returns the words that their appearances are 1, do not consider duplidated words
	public Set<String> getUniqueWords() {
		// TODO
		return null;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		// TODO
		return null;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> exportWordCounts() {
		// TODO
		return null;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsOrderByOccurence() {
		// TODO
		return null;
	}

	// delete words beginning with the given pattern (i.e., delete words begin
	// with 'A' letter
	public Set<WordCount> filterWords(String pattern) {
		// TODO
		return null;
	}
}
