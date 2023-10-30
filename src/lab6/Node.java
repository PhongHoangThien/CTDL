package lab6;

public class Node<E> {// Generic
	private E data;
	private Node<E> next;

	public Node(E data) {
		this.data = data;
	}

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public void setData(E data) {
		this.data = data;
	}

	public E getData() {
		return this.data;
	}
	
	public String toString() {
		return (String) this.data;
	}
}
