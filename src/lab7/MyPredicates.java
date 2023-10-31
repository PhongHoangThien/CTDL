package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T tmp = iter.next();
			if (!p.test(tmp)) {
				iter.remove();
			}
		}
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T tmp = iter.next();
			if (p.test(tmp)) {
				iter.remove();
			}
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj) is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> result = new HashSet<T>();
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T tmp = iter.next();
			if (p.test(tmp)) {
				result.add(tmp);
			}
		}
		return result;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		for (int i = 0; iter.hasNext(); i++) {
			T tmp = iter.next();
			if (p.test(tmp)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		List<Integer> test = new ArrayList<Integer>();
		test.add(1);
		test.add(-3);
		test.add(3);
		test.add(2);
		test.add(-4);
		test.add(6);
		List<Integer> test2 = new ArrayList<Integer>(test);
		List<Integer> test3 = new ArrayList<Integer>(test);
		List<Integer> test4 = new ArrayList<Integer>(test);
		
		Predicate<Integer> testPredicate = new Even();
		
		MyPredicates.remove(test, testPredicate);
		System.out.println(test);
		
		MyPredicates.retain(test2, testPredicate);
		System.out.println(test2);
		
		System.out.println(MyPredicates.collect(test3, testPredicate));
		
		System.out.println(MyPredicates.find(test4, testPredicate));
	}
	
}
