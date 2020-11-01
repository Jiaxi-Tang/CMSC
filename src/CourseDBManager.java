import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This program manage the data in the hash table of CourseDBStructure
 * @author Jiaxi
 *
 */
public class CourseDBManager implements CourseDBManagerInterface{

	private CourseDBStructure cds;
	
	/**
	 * default constructor
	 */
	public CourseDBManager() {
		cds = new CourseDBStructure(20);
	}
	
	/**
	 * parameterized constructor
	 * @param size size of the hash table
	 */
	public CourseDBManager(int size) {
		cds = new CourseDBStructure(size);
	}
	
	@Override
	/**
	 * add a CourseDBElement object by provideing the basic information of the course 
	 * @param courseID id of the course
	 * @param crn crn of the course
	 * @param credit credit of the course
	 * @param roomNum location of the course
	 * @param instructor instructor of the course
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement cde = new CourseDBElement(id, crn, credits, roomNum, instructor);
		cds.add(cde);
	}

	@Override
	/**
	 * get the CourseDBElement object by providing its crn
	 * @return the object itself if it's found, null if otherwise
	 */
	public CourseDBElement get(int crn) {
		CourseDBElement result;
		try {
			result = cds.get(crn);
		} catch (IOException e) {
			result = null;
		}
		return result;
	}

	@Override
	/**
	 * read in the information in the file to the hash table of CourseDBStructure
	 * @param input the file object
	 * @throws FileNotFoundException thrown if the file isn't found
	 */
	public void readFile(File input) throws FileNotFoundException {
		if(input.canRead()) {
			Scanner in = new Scanner(input);
			String str = "", name = "";
			String[] arr, hold;
			while(in.hasNext()) {
				str += in.nextLine();
				str += "\n";
			}
			in.close();
			arr = str.split("\n");
			for(String e : arr) {
				hold = e.split(" ");
				for(int i = 4; i<hold.length; i++)
					name+=hold[i] + " ";
				name = name.substring(0, name.length()-1);
				add(hold[0],Integer.parseInt(hold[1]),Integer.parseInt(hold[2]),hold[3],name);
				name = "";
			}
		}
		else {
			throw new FileNotFoundException();
		}
	}

	@Override
	/**
	 * transform the hash table of CourseDBStructure into arrayList
	 * @return array list of strings containing the data of CourseDBStructure
	 */
	public ArrayList<String> showAll() {
		ArrayList<String> result = new ArrayList<>();
		for(LinkedList<CourseDBElement> ll : cds.hashTable) {
			if(ll != null) {
				for(CourseDBElement cde : ll) {
					result.add("Course:" + cde.getID() + " CRN:" + cde.getCRN() + " Credits:" + cde.getCredit() + 
							" Instructor:" + cde.getInstructor() + " Room:" + cde.getRoom());
				}
			}
		}
		return result;
	}

}
