
/**
 * this program represent a road consist of starting point, ending point, 
 * distance in between, and the name of the road.
 * @author Jiaxi Tang
 *
 */
public class Road implements Comparable<Road>{
	private Town start, end;
	private int cost;
	private String name;
	
	/**
	 * parameterized constructor 
	 * @param start starting town
	 * @param end ending town
	 * @param distance distance in between 
	 * @param name name of the road 
	 */
	public Road(Town start, Town end, int distance, String name) {
		this.start = start;
		this.end = end;
		cost = distance;
		this.name = name;
	}
	
	/**
	 * parameterized constructor 
	 * @param start starting town
	 * @param end ending town
	 * @param name name of the road 
	 */
	public Road(Town start, Town end, String name) {
		this.start = start;
		this.end = end;
		this.name = name;
	}
	
	@Override
	/**
	 * normal compareTo method based on the name
	 * of the road
	 */
	public int compareTo(Road o) {
		return this.name.compareTo(o.name);
	}
	
	/**
	 * Normal equals method based on the
	 * name of the road
	 */
	public boolean equals(Object r) {
		if(r instanceof Road) {
			Road newR = (Road)r;
			return this.name.equals(newR.name);
		}
		else {
			return false;
		}
	}
	
	/**
	 * see if the road is adjacent to the given town
	 * @param t town object
	 * @return true if the road is adjacent to the 
	 * given town false if otherwise.
	 */
	public boolean contains(Town t) {
		return start.equals(t) || end.equals(t);
	}
	
	/**
	 * getters 
	 * @return the starting town
	 */
	public Town getSource() {
		return start;
	}
	
	/**
	 * getters
	 * @return the destination town
	 */
	public Town getDestination() {
		return end;
	}
	
	/**
	 * getters
	 * @return the name of the road
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * getters
	 * @return the distance of the road
	 */
	public int getDistance() {
		return cost;
	}
	
	/**
	 * toString method
	 * Format: starting town + " via " + 
	 * name of the road + " to " + destination + " " + distance + " mi" 
	 */
	public String toString() {
		return start + " via " + name + " to " + end + " " + cost + " mi";
	}
}
