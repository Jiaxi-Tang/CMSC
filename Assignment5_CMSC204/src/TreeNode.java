/**
 * This code represent the tree node in MorseCodeTree
 * @author Jiaxi Tang
 *
 * @param <T> any class
 */
public class TreeNode<T> {
	private T data;
	public TreeNode<T> leftChild;
	public TreeNode<T> rightChild;
	
	/**
	 * parameterized constructor
	 * @param data the desired data that goes in the node
	 */
	public TreeNode(T data) {
		this.data = data;
		leftChild = null;
		rightChild = null;
	}
	
	/**
	 * parameterized constructor, perform deep copy
	 * @param node
	 */
	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.leftChild = node.leftChild;
		this.rightChild = node.rightChild;
	}
	
	/**
	 * get the data the node contains
	 * @return the data
	 */
	public T getData() {
		return data;
	}
}
