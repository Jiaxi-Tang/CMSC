import java.util.ArrayList;

/**
 * Program that represents a stack 
 * @author Jiaxi Tang
 * @param <T> Generic type of T
 */
public class NotationStack<T> implements StackInterface<T>{

	private T[] stackArray;
	private final static int DEFAULT_SIZE = 25;
	private int topIndex;
	
	/**
	 * default constructor, creating stack with default size of 25
	 */
	public NotationStack() {
		this(DEFAULT_SIZE);
	}
	
	/**
	 * parameterized constructor
	 * @param size the size of the stack
	 */
	public NotationStack(int size) {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[size];
		stackArray = tempStack;
		topIndex = -1;
	}
	
	/**
	 * parameterized constructor, the entries in list will be pushed to stack.
	 * @param list arraylist containing entries
	 */
	public NotationStack(ArrayList<T> list) {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[list.size()];
		stackArray = tempStack;
		topIndex = -1;
		for(T i : list) {
			stackArray[topIndex+1] = i;
			topIndex++;
		}
	}
	
	/**
	 * return if stack is empty or not
	 * @return true if stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return topIndex < 0;
	}

	@Override
	/**
	 * return if stack is full or not
	 * @return true if stack is full, false otherwise
	 */
	public boolean isFull() {
		return topIndex == stackArray.length - 1;
	}

	@Override
	/**
	 * This method remove the top entry 
	 * @return the removed entry
	 * @throws StackUnderflowException thrown when stack is empty 
	 */
	public T pop() throws StackUnderflowException {
		T result = null;
		if(!isEmpty()) {
			result = stackArray[topIndex];
			stackArray[topIndex] = null;
			topIndex--;
			return result;
		}
		throw new StackUnderflowException();
	}

	@Override
	/**
	 * This method returns the top entry
	 * @return the top entry 
	 * @throws StackUnderflowException thrown when stack is empty
	 */
	public T top() throws StackUnderflowException {
		return peek();
	}

	/**
	 * This method returns the top entry
	 * @return the top entry 
	 * @throws StackUnderflowException thrown when stack is empty
	 */
	public T peek() throws StackUnderflowException {
		if(!isEmpty()) {
			return stackArray[topIndex];
		}
		else
			throw new StackUnderflowException();
	}
	
	@Override
	/**
	 * This method returns the size of the stack
	 * @return the size of the stack
	 */
	public int size() {
		return topIndex + 1;
	}

	@Override
	/**
	 * This method adds a new entry to the stack
	 * @param e new entry that will be added to the stack
	 * @return true if the entry is added successfully
	 * @throws StackOverflowException thrown when stack is full
	 */
	public boolean push(T e) throws StackOverflowException {
		if(topIndex < (stackArray.length - 1)) {
			stackArray[topIndex+1] = e;
			topIndex++;
			return true;
		}
		throw new StackOverflowException();
	}

	@Override
	/**
	 * this method returns a string containing the entries in stack divided by delimiter
	 * @param delimiter a string that separates each entry in stack
	 * @return a string containing the entries in stack divided by delimiter 
	 * with the head of the string being the bottom of the stack
	 */
	public String toString(String delimiter) {
		String str = "";
		for (int i = 0; i <= topIndex; i++) {
			str += stackArray[i] + delimiter;
		}
		if(delimiter.length() > 0 && str.length()-delimiter.length()>0) {
			str = str.substring(0, str.length()-delimiter.length());
		}
		return str;
	}
	
	/**
	 * this method returns a string containing the entries in stack divided by delimiter
	 * @param delimiter a string that separates each entry in stack
	 * @return a string containing the entries in stack 
	 * with the head of the string being the bottom of the stack
	 */
	public String toString() {
		return toString("");
	}

}
