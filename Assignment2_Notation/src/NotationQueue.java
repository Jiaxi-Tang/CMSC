import java.util.ArrayList;

/**
 * This program represents a queue
 * @author Jiaxi Tang
 * @param <T> Generic Type of T
 */
public class NotationQueue<T> implements QueueInterface<T>{

	private T[] queueArray;
	private final static int DEFAULT_SIZE = 25;
	private int frontIndex;
	private int backIndex;
	
	/**
	 * default constructor, creating queue with default size of 25.
	 */
	public NotationQueue() {
		this(DEFAULT_SIZE);
	}
	
	/**
	 * parameterized constructor, creating queue with specified size
	 * @param size the size of the queue
	 */
	public NotationQueue(int size) {
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Object[size];
		queueArray = tempArray;
		frontIndex = 0; 
		backIndex = -1; 
	}
	
	/**
	 * parameterized constructor, the entries in list will be equeued to queue.
	 * @param list arraylist containing entries
	 */
	public NotationQueue(ArrayList<T> list) {
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Object[list.size()];
		queueArray = tempArray;
		frontIndex = 0;
		backIndex=-1;
		for(T i : list) {
			tempArray[backIndex+1] = i;
			backIndex++;
		}
	}
	
	@Override
	/**
	 * return if queue is empty or not
	 * @return true if queue is empty false otherwise
	 */
	public boolean isEmpty() {
		return backIndex < 0;
	}

	@Override
	/**
	 * return if queue is full or not
	 * @return true if queue is full false otherwise
	 */
	public boolean isFull() {
		return backIndex == queueArray.length - 1;
	}

	@Override
	/**
	 * remove the first entry in queue
	 * @return the removed entry
	 * @throws QueueUnderflowException thrown when queue is empty
	 */
	public T dequeue() throws QueueUnderflowException {
		T result;
		if(!isEmpty()) {
			result = queueArray[frontIndex];
			queueArray[frontIndex] = null;
			for(int i =0; i < backIndex; i++) {
				queueArray[i] = queueArray[i+1];
			}
			queueArray[backIndex] = null;
			backIndex--;
			return result;
		}
		throw new QueueUnderflowException();
	}

	@Override
	/**
	 * returns the size of the queue
	 * @return the size of the queue
	 */
	public int size() {
		if(!isEmpty()) {
			return backIndex + 1;
		}
		return 0;
	}

	@Override
	/**
	 * add the entry to the back of the queue
	 * @param e the desired entry to be added
	 * @return true if entry is successfully added 
	 * @throws QueueOverflowException thrown when queue is full
	 */
	public boolean enqueue(T e) throws QueueOverflowException {
		if(!isFull()){
			queueArray[backIndex+1] = e;
			backIndex++;
			return true;
		}
		throw new QueueOverflowException();
	}

	@Override
	/**
	 * this method returns a string containing the entries in queue divided by delimiter
	 * @param delimiter a string that separates each entry in queue
	 * @return a string containing the entries in queue divided by delimiter 
	 * with the head of the string being the front of the queue
	 */
	public String toString(String delimiter) {
		String str = "";
		for(int i =0; i <= backIndex; i++) {
			str += "" + queueArray[i] + delimiter;
		}
		if(delimiter.length() > 0 && str.length()-delimiter.length()>0) {
			str = str.substring(0, str.length()-delimiter.length());
		}
		return str;
	}

	/**
	 * this method returns a string containing the entries in queue
	 * @return a string containing the entries in queue 
	 * with the head of the string being the front of the queue
	 */
	public String toString(){
		return toString("");
	}
	
	@Override
	/**
	 * fill the queue with the entries in the arraylist
	 * @param list the arraylist containing entries
	 */
	public void fill(ArrayList<T> list) {
		if(queueArray.length < list.size()) {
			@SuppressWarnings("unchecked")
			T[] temp = (T[]) new Object[list.size()];
			queueArray = temp;
		}
		backIndex = 0;
		frontIndex = 0;
		for(T i : list) {
			queueArray[backIndex] = i;
			backIndex++;
		}
		
	}

}
