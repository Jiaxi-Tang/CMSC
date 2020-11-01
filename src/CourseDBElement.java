/**
 * This program serves as the basic data element of the list of available course
 * @author Jiaxi Tang
 *
 */
public class CourseDBElement implements Comparable<CourseDBElement>{

	private String courseID;
	private int crn;
	private int credit;
	private String roomNum;
	private String instructor;
	
	/**
	 * default constructor
	 */
	public CourseDBElement() {
		courseID = "";
		crn = 0;
		credit = 0;
		roomNum = "";
		instructor = "";
	}
	
	/**
	 * parameterized constructor
	 * @param courseID id of the course
	 * @param crn crn of the course
	 * @param credit credit of the course
	 * @param roomNum location of the course
	 * @param instructor instructor of the course
	 */
	public CourseDBElement(String courseID, int crn, int credit, String roomNum, String instructor) {
		this.courseID = courseID;
		this.crn = crn;
		this.credit = credit;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	
	/**
	 * return crn
	 * @return crn number of the course
	 */
	public int getCRN() {
		return crn;
	}
	
	/**
	 * return number of credits the course have
	 * @return credit
	 */
	public int getCredit() {
		return credit;
	}
	
	/**
	 * return the name of the course
	 * @return name of the course
	 */
	public String getID() {
		return courseID;
	}
	
	/**
	 * return the room number of the course
	 * @return location of the course
	 */
	public String getRoom() {
		return roomNum;
	}
	
	/**
	 * return the name of the instructor 
	 * @return instructor's name
	 */
	public String getInstructor() {
		return instructor;
	}
	
	/**
	 * set the name of the course
	 * @param ID name of the course
	 */
	public void setID(String ID) {
		courseID = ID;
	}
	
	/**
	 * set the number of credits the course have
	 * @param credit number of credits
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	/**
	 * set the location of the course
	 * @param room room number 
	 */
	public void setRoom(String room) {
		this.roomNum = room;
	}
	
	/**
	 * set the instructor name of the course
	 * @param teacher name of instructor
	 */
	public void setInstructor(String teacher) {
		this.instructor = teacher;
	}
	
	@Override
	/**
	 * compare two course by their CRN
	 * @param o1 another CourseDBElement object
	 */
	public int compareTo(CourseDBElement o1) {
		if(this.crn == o1.crn)
			return 0;
		else
			return 1;
	}
	
	/**
	 * get the hashcode of the course by its crn number
	 * @return hashcode of this CourseDBElement object
	 */
	public int hashCode() {
		String temp = crn + "";
		return temp.hashCode();
	}
	

}
