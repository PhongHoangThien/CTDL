package lab6;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		if (elements.length == size) {
			this.elements = Arrays.copyOf(elements, size * 2);
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return this.size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return this.size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size)
			throw new IndexOutOfBoundsException("i must between 0 and size-1");
		else
			return elements[i];
	}

	// Replaces the element at index i with e, and returns the replaced element.∗/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size)
			throw new ArrayIndexOutOfBoundsException("i must between 0 and size-1");
		else {
			elements[i] = e;
			return elements[i];
		}
	}

	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		if(elements.length == size) {
			growSize();
			elements[elements.length/2] = e;
		}
		else {
			elements[size] = e;
		}
		size++;
		return true;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) throw new IndexOutOfBoundsException("i must between 0 and size-1");
		else {
			if(i == size) {
				add(e);
			}
			else {
				for (int j = size; j >= i; j--) {
					elements[j+1] = elements[j];
				}
				elements[i] = e;
			}
		}
		size++;
	}

	// Removes and returns the element at index i, shifting subsequent elements
	// earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		E tmp = elements[i];
		if(i < 0 || i >= size) throw new IndexOutOfBoundsException("i must between 0 and size-1");
		else {
			for (int j = i; j < size; j++) {
				elements[j] = elements[j+1];
			}
		}
		size--;
		return tmp;
	}

	// It is used to clear all elements in the list.
	public void clear() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	// It is used to return the index in this list of the last occurrence of the
	// specified element, or -1 if the
	// list does not contain this element.
	public int lastIndexOf(Object o) throws IndexOutOfBoundsException {
		for (int i = size-1; i >= 0; i--) {
			if (elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	// It is used to return an array containing all of the elements in this list in
	// the correct order.
	public E[] toArray() {
		E[] result = (E[]) new Object[size];
		for (int i = 0; i < size; i++) {
			result[i] = (E) elements[i];
		}
		return result;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> result = new MyArrayList<E>();
		result.size = this.size;
		result.elements = (E[]) new Object[elements.length];
		for (int i = 0; i < size; i++) {
			result.elements[i] = this.elements[i];
		}
		return result;
	}

	// It returns true if the list contains the specified element
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	// It is used to return the index in this list of the first occurrence of the
	// specified element, or -1 if the List does not contain this element.
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	// It is used to remove the first occurrence of the specified element.
	public boolean remove(E e) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(e)) {
				for (int j = i; j < size; j++) {
					elements[j] = elements[j+1];
				}
				size--;
				return true;
			}
		}
		return false;
	}

	// It is used to sort the elements of the list on the basis of specified
	// comparator.
	public void sort(Comparator<E> c) {
		Arrays.sort((E[]) elements, 0, size, c);
	}
	
	public String toString() {
		String result = "[";
		for (int i = 0; i < size; i++) {
			if (i < size-1) result += elements[i] + ", ";
			else result += elements[i].toString();
		}
		result += "]";
		return result;
	}

	public static void main(String[] args) {
		MyArrayList<String> test = new MyArrayList<String>();
		test.add("A");
		test.add("D");
		test.add("F");
		test.add("G");
		test.add("C");
		test.add("A");
		test.add("B");
		System.out.println(test.toString() + " |begining ArrayList\n");
		
		test.add(1, "H");
		System.out.println(test.toString() + " |add 'H' index=1"); 
		
		test.remove(1);
		System.out.println(test.toString() + " |remove index=1");
		test.remove("G");
		System.out.println(test.toString() + " |remove 'G'");
		
		System.out.println(test.lastIndexOf("A") + " |last indexof 'A'");
		System.out.println(test.indexOf("A") + " |first index of 'A'");
		
		System.out.println(test.contains("E") + " |is contain 'E'");
		System.out.println(test.contains("F") + " |is contain 'F'");
		
		MyArrayList<String> testClone = test.clone();
		System.out.println(testClone.toString() + " |clone");
		testClone.add("U");
		System.out.println(testClone.toString() + " |add 'U' to clone");
		System.out.println(test.toString() + " |original");
		
		test.sort(new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(test.toString() + " |sort");
		
		test.clear();
		System.out.println(test.toString() + " |clear");
	}
}
