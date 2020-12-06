import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**
 * This progrm represent a town and consist of the name of the town and a list of near by 
 * towns
 * @author Jiaxi Tang
 *
 */
public class Town implements Comparable<Town>{
	private String name;
	private Set<Town> nearTowns;
	private boolean visit;
	private Town predecessor;
	private int pathCost;
	
	/**
	 * parameterized constructor
	 * @param name name of the town
	 */
	public Town(String name) {
		this.name = name;
		nearTowns = new HashSet<Town>();
		visit = false;
	}
	
	/**
	 * parameterized constructor
	 * @param t template town object used for deep copy
	 */
	public Town(Town t) {
		this.name = t.name;
		this.nearTowns = t.nearTowns;
	}

	@Override
	/**
	 * normal compareTo method based on name of the town
	 * @param o town object used for comparison
	 * @return 0 if two object is the same, positive or negative
	 * value otherwise.
	 */
	public int compareTo(Town o) {
		return this.name.compareTo(o.name);
	}
	
	/**
	 * return whether the two objects are equal or not
	 * @param o object used for comparison
	 * @return whether the two objects are equal or not
	 */
	public boolean equals(Object o) {
		if(o instanceof Town) {
			Town newO = (Town)o;
			return this.name.equals(newO.name);
		}
		else {
			return false;
		}
	}
	
	/**
	 * Override hashCode method based on name of the town
	 */
	public int hashCode() {
		return this.name.hashCode();
	}
	
	/**
	 * return the name of the town
	 * @return name of the town
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * toString method
	 * @return the name of the town
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * mark the town as visited
	 */
	public void visited() {
		visit = true;
	}
	
	/**
	 * mark the town as unvisited
	 */
	public void unvisit() {
		visit = false;
	}
	
	/**
	 * return if the town is visited or not.
	 * @return if the town is visited or not.
	 */
	public boolean isVisited() {
		return visit;
	}
	
	/**
	 * add one near by town to the list
	 * of near by towns
	 * @param t town object 
	 */
	public void addNearTown(Town t) {
		nearTowns.add(t);
	}
	
	/**
	 * remove one near by town object 
	 * @param t town object going to be removed
	 */
	public void removeNearTown(Town t) {
		nearTowns.remove(t);
	}
	
	/**
	 * clear all the near by towns
	 */
	public void clearNearTown() {
		nearTowns = null;
	}
	
	/**
	 * return an iterator that goes through the 
	 * list of near by towns
	 * @return an iterator
	 */
	public Iterator<Town> neighborIterator(){
		return nearTowns.iterator();
	}
	
	/**
	 * sets he predecessor to this town
	 * for shortestPath algorithm purpose
	 * @param t predecessor town object
	 */
	public void setPredecessor(Town t) {
		predecessor = t;
	}
	
	/**
	 * get the predecessor to this town object
	 * @return the predecessor
	 */
	public Town getPredecessor() {
		return predecessor;
	}
	
	/**
	 * set the cost the the path from some certain town
	 * for shortestPath algorithm purpose
	 * @param c cost
	 */
	public void setPathCost(int c) {
		pathCost = c;
	}
	
	/**
	 * get the path cost
	 * @return path cost
	 */
	public int getPathCost() {
		return pathCost;
	}
}
