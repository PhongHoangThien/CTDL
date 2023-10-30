package lab6;

import java.util.LinkedList;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	public SinglyLinkedList() {
		super();
	}

	// Returns the number of elements in the list.
	public int size() {
		return this.size;
	}
	
	// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		return this.size == 0;
	}

	// Returns (but does not remove) the first element in the list.
	public E first() {
		return this.head.getData();
	}

	// Returns (but does not remove) the last element in the list.
	public E last() {
		return this.tail.getData();
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e, head);
		if (size == 0) {
			head = newNode;
			tail = newNode;
		}
		else {
			head = newNode;
		}
		size++;
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e, null);
		if (size == 0) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		Node<E> nextNode = head.getNext();
		head.setNext(null);
		head = nextNode;
		size--;
		return first();
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		Node<E> currentNode = this.head;
		while (currentNode.getNext().getNext() != null) {
			currentNode = currentNode.getNext();
		}
		tail = currentNode;
		currentNode.setNext(null);
		size--;
		return last();
	}
	
	public String toString() {
		String result = "";
		for (Node<E> i = this.head; i != null; i = i.getNext()) {
			if (i.equals(tail)) {
				result += i.toString();
			}
			else result += i.toString() + ", ";
		}
		return result;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<String> test = new SinglyLinkedList<String>();
	
		test.addFirst("F");
		test.addFirst("D");
		test.addFirst("A");
		
		test.addLast("G");
		test.addLast("C");
		test.addLast("B");
		
		System.out.println(test.toString());
		
		System.out.println(test.removeFirst() + " remove First");
		System.out.println(test.toString());
		
		System.out.println(test.removeLast() + " remove Last");
		System.out.println(test.toString());
	}
}
