package lab11_tree;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public void add(E e) {
//		if (data == null) {
//			data = e;
//			return;
//		}
		
		int compare = e.compareTo(data);
		if (compare < 0) {
			if (left == null) 
				left = new BNode<E>(e);
			else 
				left.add(e);
		} else if (compare > 0) {
			if (right == null)
				right = new BNode<E>(e);
			else
				right.add(e);
		}
	}
	
	public int depthOfNode(E node, int starter) {
		if (data == null) {
			return -1;
		}
		
		int compare = node.compareTo(data);
		if (compare == 0) {
			return starter;
		}
		if (compare < 0) {
			return left.depthOfNode(node, starter + 1);
		}
		if (compare > 0) {
			return right.depthOfNode(node, starter + 1);
		}
		
		return starter;
	}
	
	public int height() {
		if (left == null && right == null) {
			return 0;
		}
		
		int leftHeight = 0;
		int rightHeight = 0;
		if (left != null) {
			leftHeight = left.height();
		}
		if (right != null) {
			rightHeight = right.height();
		}
		
		return Math.max(leftHeight, rightHeight) + 1;
		
	}
	
	public int size() {
		int size = 1;
		if (!haveLeft() && !haveRight()) {
			return size;
		}
		
		if (haveLeft()) {
			size += left.size();
		}
		if (haveRight()) {
			size += right.size();
		}
		
		return size;
	}
	
	public boolean contains(E e) {
		int compare = e.compareTo(data);
		if (compare == 0) {
			return true;
		} else if (compare < 0) {
			return ((left == null) ? false : left.contains(e));
		} else {
			return ((right == null) ? false : right.contains(e));
		}
	}
	
	public E findMin() {
		if (!haveLeft()) {
			return data;
		}
		
		return left.findMin();
	}
	
	public E findMax() {
		if (!haveRight()) {
			return data;
		}
		
		return right.findMax();
	}
	
	public List<E> descendants(E e) {
		int compare = e.compareTo(data);
		List<E> result = new ArrayList<E>();
		
		if (compare == 0) {
			addDescendant(left, result);
			addDescendant(right, result);
		}
		
		if (compare < 0) {
			if (haveLeft()) {
				result.addAll(left.descendants(e));
			}
		} else if (compare > 0) {
			if (haveRight()) {
				result.addAll(right.descendants(e));
			}
		}
		
        return result;
    }
	public void addDescendant(BNode<E> node, List<E> list) {
		if (node == null) {
			return;
		}
		
		list.add(node.data);
		addDescendant(node.getLeft(), list);
		addDescendant(node.getRight(), list);
	}
	
    public List<E> ancestors(E e) {
    	int compare = e.compareTo(data);
    	List<E> result = new ArrayList<E>();
    	
		if (compare == 0) {
			return result;
		}
		else {
			result.add(data);
		}
		
		if (left != null) {
			if (left.contains(e)) {
				result.addAll(left.ancestors(e));
			}
		}
		if (right != null) {
			if (right.contains(e)) {
				result.addAll(right.ancestors(e));
			}
		}
		return result;
	}
    
    public boolean remove(E e) {
        BNode<E> parent = null;
        BNode<E> current = this;

        while (current != null) {
            int compare = e.compareTo(current.data);

            if (compare < 0) {
                parent = current;
                current = current.left;
            } else if (compare > 0) {
                parent = current;
                current = current.right;
            } else {
                // Node found, remove it
                if (current.left != null && current.right != null) {
                    // Node has two children
                    BNode<E> successor = current.right;
                    while (successor.left != null) {
                        parent = successor;
                        successor = successor.left;
                    }

                    current.data = successor.data;
                    current = successor;
                }

                // Node has one child or no child
                BNode<E> child = (current.left != null) ? current.left : current.right;

                if (parent == null) {
                    // Removing root node
                    return false; // You might want to handle this case accordingly
                }

                if (parent.left == current) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }

                return true;
            }
        }

        return false; // Node not found
    }
    
	public void displayInorder() {
		if (isLeaf()) {
			System.out.print(data + " ");
			return;
		}
		
		if (haveLeft()) {
			left.displayInorder();
		}
		System.out.print(data.toString() + " ");
		if (haveRight()) {
			right.displayInorder();
		}
	}
	public void displayPreorder() {
		if (isLeaf()) {
			System.out.print(data + " ");
			return;
		}

		System.out.print(data.toString() + " ");
		if (haveLeft()) {
			left.displayPreorder();
		}
		if (haveRight()) {
			right.displayPreorder();
		}
	}
	
	public void displayPostorder() {
		if (isLeaf()) {
			System.out.print(data + " ");
			return;
		}
		
		if (haveLeft()) {
			left.displayPostorder();
		}
		if (haveRight()) {
			right.displayPostorder();
		}
		System.out.print(data.toString() + " ");
	}
	
	public BNode<E> getParent(BNode<E> node, E e){
		if (node == null) {
			return null;
		}
		if (node.getLeft().getData().compareTo(e) == 0 || node.getRight().getData().compareTo(e) == 0) {
			return node;
		}
		
		int compare = e.compareTo(data);
		if (compare < 0) {
			return getParent(node.getLeft(), e);
		}
		if (compare > 0) {
			return getParent(node.getRight(), e);
		}
		return null;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}
	
	public boolean haveLeft() {
		return left != null;
	}
	public boolean haveRight() {
		return right != null;
	}
	public boolean haveOneChild() {
		return left != null || right != null;
	}
	public boolean haveTwoChild() {
		return left != null && right != null;
	}
	public boolean isLeaf() {
		return left == null && right == null;
	}
}
