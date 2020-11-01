import java.io.IOException;
import java.util.LinkedList;

/**
 * This represent a hash table of CourseDBElement, which contains the information of a course.
 * @author Jiaxi Tang
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface{

	public LinkedList<CourseDBElement>[] hashTable;
	private int numOfEntries;
	
	@SuppressWarnings("unchecked")
	/**
	 * parameterized constructor
	 * @param size size of the hash table
	 */
	public CourseDBStructure(int size) {
		hashTable = (LinkedList<CourseDBElement>[]) new LinkedList<?>[size];
	}
	
	/**
	 * constructor for testing purpose only
	 * @param str "Testing"
	 * @param size size of the hashtable
	 */
	public CourseDBStructure(String str, int size) {
		this(size);
	}
	
	@Override
	/**
	 * add a CourseDBElement object, which contains the information of a course, 
	 * to the hash table
	 * @param element the desired object to be added
	 */
	public void add(CourseDBElement element) {
		int index = element.hashCode() % hashTable.length;
		if(hashTable[index]==null) {
			hashTable[index] = new LinkedList<CourseDBElement>();
			hashTable[index].add(element);
			numOfEntries++;
		}
		else {
			boolean found = false;
			for(CourseDBElement cde : hashTable[index]) {
				if(cde.compareTo(element)==0) {
					found = true;
					cde.setCredit(element.getCredit());
					cde.setID(element.getID());
					cde.setInstructor(element.getInstructor());
					cde.setRoom(element.getRoom());
					break;
				}
			}
			if(!found) {
				hashTable[index].add(element);
				numOfEntries++;
			}
		}
	}

	@Override
	/**
	 * get the CourseDBElement object by providing its crn
	 * @return the object itself if it's found
	 * @throws IOException if the object isn't found
	 */
	public CourseDBElement get(int crn) throws IOException {
		CourseDBElement result = null;
		boolean found = false;
		String str = crn+"";
		int index = str.hashCode() % hashTable.length;
		for(CourseDBElement cde : hashTable[index]) {
			if(cde.getCRN() == crn) {
				result = cde;
				found = true;
				break;
			}
		}
		if(!found) {
			throw new IOException();
		}
		return result;
	}

	@Override
	/**
	 * return the size of the hash table
	 * @return the size of the hash table
	 */
	public int getTableSize() {
		return hashTable.length;
	}

}
