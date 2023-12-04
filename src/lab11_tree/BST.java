package lab11_tree;

import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		if (root == null) {
			this.root = new BNode<E>(e);
		}
		else {
			root.add(e);
		}
	}
	
	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		return root.depthOfNode(node, 0);
	}
	

	// compute the height of BST
	public int height() {
		return root.height();
	}

	// Compute total nodes in BST
	public int size() {
		return root.size();
	}
	

	// Check whether element e is in BST
	public boolean contains(E e) {
		return contains(root, e);
	}
	public boolean contains(BNode<E> node, E e) {
		if (node == null) {
			return false;
		}
		if (node.getData().compareTo(e) == 0) {
			return true;
		}
		
		return contains(node.getLeft(), e) || contains(node.getRight(), e);
	}

	// Find the minimum element in BST
	public E findMin() {
		return root.findMin();
	}
	

	// Find the maximum element in BST
	public E findMax() {
		return root.findMax();
	}
	

	// Remove element e from BST
	public boolean remove(E e) {
		if (root == null) {
            return false;
        }
		
		return root.remove(e);
    }
	
	// get the descendants of a node
	public List<E> descendants(E data) {
        return root.descendants(data);
    }
    

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		return root.ancestors(data);
	}
	

	// display BST using inorder approach
	public void inorder() {
		root.displayInorder();
		System.out.println();
	}
	
	
	// display BST using preorder approach
	public void preorder() {
		root.displayPreorder();
		System.out.println();
	}

	// display BST using postorder approach
	public void postorder() {
		root.displayPostorder();
		System.out.println();
	}

	public static void main(String[] args) {
		BST<Integer> test = new BST<Integer>();
		test.add(25);
		test.add(15);
		test.add(50);
		test.add(22);
		test.add(10);
		test.add(35);
		test.add(70);
		test.add(4);
		test.add(12);
		test.add(18);
		test.add(24);
		test.add(31);
		test.add(44);
		test.add(66);
		test.add(90);
		test.add(1);
		test.remove(4);
		System.out.println(test.depth(90));
		System.out.println(test.height());
		System.out.println(test.size());
		System.out.println(test.contains(12));
		System.out.println(test.contains(11));
		System.out.println(test.findMin());
		System.out.println(test.findMax());
		System.out.println(test.descendants(15));
		test.remove(15);
		System.out.println(test.descendants(10));
		System.out.println(test.ancestors(4));
		test.inorder();
		test.preorder();
		test.postorder();
		
	}
}
