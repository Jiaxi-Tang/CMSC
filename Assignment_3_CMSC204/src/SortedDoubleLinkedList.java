import java.util.Comparator;
import java.util.ListIterator;

/**
 * This program is used to represent a sorted list
 * @author Administrator
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	private Comparator<T> comparator;
	private int numOfEntries;
	
	/**
	 * parameterized constructor 
	 * @param comparator comparator used to order the list
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}
	
	/**
	 * not supported operation
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * not supported operation
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * add to the sorted list in ascending order
	 * @param data desired data to be added
	 * @return the whole list
	 */
	public SortedDoubleLinkedList<T> add(T data){
		Node current = super.getFirstNode();
		Node newNode = new Node(data);
		Node before = new Node();
		
		if(super.getFirstNode() == null && super.getLastNode() == null) {
			super.setFirstNode(newNode);
			super.setLastNode(newNode);
			numOfEntries++;
			return this;
		}
		else if(super.getFirstNode() == super.getLastNode()) {
			if(comparator.compare(data, current.getData()) < 0) {
				super.setLastNode(current);
				super.setFirstNode(newNode);
				current.setPrevious(newNode);
				newNode.setNext(current);
			}
			else {
				super.setLastNode(newNode);
				super.setFirstNode(current);
				current.setNext(newNode);
				newNode.setPrevious(current);
			}
			numOfEntries++;
			return this;
		}
		else if(current != null) {
			while(current != null && comparator.compare(current.getData(), data) < 0) {
				before = current;
				current = current.getNext();
			}
			if(current == super.getFirstNode()) {
				newNode.setNext(current);
				current.setPrevious(newNode);
				super.setFirstNode(newNode);
			}
			else if(before.getNext() == null) {
				before.setNext(newNode);
				newNode.setPrevious(before);
				super.setLastNode(newNode);
			}
			else {
				newNode.setNext(current);
				before.setNext(newNode);
				current.setPrevious(newNode);
				newNode.setPrevious(before);
			}
			numOfEntries++;
		}
		return this;
	}
	
	/**
	 * @return the size of sorted list
	 */
	public int getSize() {
		return numOfEntries;
	}
	
	/**
	 * @return list iterator for the sorted list
	 */
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	/**
	 * remove the desired object
	 * @param targetData desired object to be removed
	 * @param comparator used to find the object in the list
	 * @return the whole sorted list
	 */
	public SortedDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		super.remove(targetData,comparator);
		numOfEntries--;
		return this;
	}
}
