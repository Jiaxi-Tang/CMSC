import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * This program mimic a doubly linked list
 * @author Jiaxi Tang
 *
 * @param <T> generic type
 */
public class BasicDoubleLinkedList<T>{
	private Node firstNode;
	private Node lastNode;
	private int numOfEntries;

	/**
	 * default constructor
	 */
	public BasicDoubleLinkedList() {
		firstNode = null;
		lastNode = null;
		numOfEntries = 0;
	}

	/**
	 * Gets the size of list
	 * @return the size of list
	 */
	public int getSize() {
		return numOfEntries;
	}

	/**
	 * return the reference to first node in the list 
	 * @return reference to first node in the list 
	 */
	protected Node getFirstNode() {
		return firstNode;
	}
	
	/**
	 * sets the reference to first node in the list 
	 * @param n reference to new node
	 */
	protected void setFirstNode(Node n) {
		firstNode = n;
	}
	
	/**
	 * return the reference to last node in the list 
	 * @return reference to last node in the list 
	 */
	protected Node getLastNode() {
		return lastNode;
	}
	
	/**
	 * sets the reference to last node in the list 
	 * @param n reference to new node
	 */
	protected void setLastNode(Node n) {
		lastNode = n;
	}
	
	/**
	 * return a iterator for the list
	 * the iterator class is implemented as an inner class.
	 * @return iterator for the list
	 */
	public ListIterator<T> iterator() {
		return new Iterator();
	}

	/**
	 * add to the front of the list
	 * @param data the desired object
	 * @return the whole list 
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		Node newNode = new Node(data);
		if(firstNode == null && lastNode == null) {
			firstNode = newNode;
			lastNode = newNode;
			numOfEntries++;
		}
		else if(firstNode == lastNode) {
			firstNode = newNode;
			firstNode.setNext(lastNode);
			lastNode.setPrevious(firstNode);
			numOfEntries++;
		}
		else {
			newNode.setNext(firstNode);
			firstNode = newNode;
			firstNode.getNext().setPrevious(firstNode);
			numOfEntries++;
		}
		return this;
	}

	/**
	 * Add to the end of the list
	 * @param data desired object to be added
	 * @return the whole list
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		Node newNode = new Node(data);
		if(firstNode == null && lastNode == null) {
			firstNode = newNode;
			lastNode = newNode;
			numOfEntries++;
		}
		else if(firstNode == lastNode) {
			lastNode = newNode;
			lastNode.setPrevious(firstNode);
			firstNode.setNext(lastNode);
			numOfEntries++;
		}
		else {
			newNode.setPrevious(lastNode);
			lastNode = newNode;
			lastNode.getPrevious().setNext(lastNode);
			numOfEntries++;
		}
		return this;
	}

	/**
	 * return the first element
	 * @return the first element
	 */
	public T getFirst() {
		T result = null;
		if(firstNode != null) {
			result = firstNode.getData();
		}
		return result;
	}

	/**
	 * return the last element
	 * @return the last element
	 */
	public T getLast() {
		T result = null;
		if(lastNode != null) {
			result = lastNode.getData();
		}
		return result;
	}

	/**
	 * remove and return the first element 
	 * @return the first element
	 */
	public T retrieveFirstElement() {
		T result = null;
		if(firstNode != null) {
			result = firstNode.getData();
			firstNode = firstNode.getNext();
			firstNode.setPrevious(null);
			numOfEntries--;
		}
		return result;
	}

	/**
	 * return and remove the last element
	 * @return the last element
	 */
	public T retrieveLastElement() {
		T result = null;
		if(lastNode != null) {
			result = lastNode.getData();
			lastNode = lastNode.getPrevious();
			lastNode.setNext(null);
			numOfEntries--;
		}
		return result;
	}

	/**
	 * remove the desired object in the list
	 * @param targetData desired object
	 * @param comparator used to compare the objects in list
	 * @return the whole list
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		Node current = firstNode;
		while(current != null) {
			if(comparator.compare(targetData, current.getData()) == 0) {
				Node pre = current.getPrevious();
				Node next = current.getNext();
				if(pre == null) {
					System.out.println("1");
					System.out.println(pre);
					System.out.println(next.getData());
					
					next.setPrevious(null);
					firstNode = next;
				}
				else if(next == null){
					pre.setNext(null);
					lastNode = pre;
				}
				else {
					pre.setNext(next);
					next.setPrevious(pre);
				}
				numOfEntries--;
				break;
			}
			current = current.getNext();
			
			System.out.println(current.getData());
		}
		return this;
	}

	/**
	 * transform the list into arraylist
	 * @return arraylist contining all the objects in the list.
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> arr = new ArrayList<>();
		Node current = firstNode;
		while(current != null) {
			arr.add(current.getData());
			current = current.getNext();
		}
		return arr;
	}

	//--------------------------------------------------------------------
	//--------------------------------------------------------------------
	/**
	 * this program is used to encapsulate the information in each object of the list
	 * @author Jiaxi
	 *
	 */
	protected class Node{
		private T data;
		private Node next;
		private Node previous;

		/**
		 * default constructor
		 */
		public Node() {
			data = null;
			next = null;
		}

		/**
		 * parameterized constructor
		 * @param data desired object
		 */
		public Node(T data) {
			this.data = data;
		}

		/**
		 * 
		 * @return data of the node
		 */
		public T getData() {
			return data;
		}

		/**
		 * set data of the node
		 * @param data desired object
		 */
		public void setData(T data) {
			this.data = data;
		}

		/**
		 * 
		 * @return reference to next node
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * set reference to next node
		 * @param next next node
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/**
		 *@return reference to previous next node
		 */
		public Node getPrevious() {
			return previous;
		}

		/**
		 * set reference to previous node
		 * @param previous node
		 */
		public void setPrevious(Node previous) {
			this.previous = previous;
		}
	}

	//-----------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------
	/**
	 * This program returns an iterator for the list
	 * @author Jiaxi
	 *
	 */
	private class Iterator implements ListIterator<T>{
		private Node nextNode;
		private Node previousNode;

		/**
		 * default constructor
		 */
		public Iterator() {
			nextNode = firstNode;
			previousNode = null;
		}

		@Override
		/**
		 * return if the list has next element or not
		 */
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		/**
		 * return the next element in the list
		 */
		public T next() {
			T result = null;
			if(hasNext()) {
				result = nextNode.getData();
				previousNode = nextNode;
				nextNode =nextNode.getNext();
			}
			else {
				throw new NoSuchElementException();
			}
			return result;
		}

		@Override
		/**
		 * return if the list has previous element or not
		 */
		public boolean hasPrevious() {
			return previousNode != null;
		}

		@Override
		/**
		 * return the previous element
		 */
		public T previous() {
			T result = null;
			if(hasPrevious()) {
				result = previousNode.getData();
				nextNode = previousNode;
				previousNode = previousNode.getPrevious();
			}
			else {
				throw new NoSuchElementException();
			}
			return result;
		}

		@Override
		/**
		 * not supported operation
		 */
		public void add(T data) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		/**
		 * not supported operation
		 */
		public int nextIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		/**
		 * not supported operation
		 */
		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		/**
		 * not supported operation
		 */
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		/**
		 * not supported operation
		 */
		public void set(Object e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

	}
}
