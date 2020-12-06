import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * This program is used to manage the Graph object
 * @author Jiaxi Tang
 *
 */
public class TownGraphManager implements TownGraphManagerInterface{

	private GraphInterface<Town, Road> g = new Graph();
	
	@Override
	/**
	 * add road between two town
	 @param town1 name of town 1 (lastname, firstname)
	 @param town2 name of town 2 (lastname, firstname)
	 @param roadName name of road
	 @return true if the road was added successfully
	 */
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		Road r = g.addEdge(t1, t2, weight, roadName);
		return r != null;
	}

	@Override
	/**
	 * get the road between two towns
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	public String getRoad(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		Road r = g.getEdge(t1, t2);
		return r.getName();
	}

	@Override
	/**
	 * add town to the graoh
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	public boolean addTown(String v) {
		Town t = new Town(v);
		return g.addVertex(t);
	}

	@Override
	/**
	 * get the town object by its name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	public Town getTown(String name) {
		Set<Town> s = g.vertexSet();
		Town result = null;
		for(Town t: s) {
			if(t.getName().equals(name))
				result = t;
		}
		return result;
	}

	@Override
	/**
	 * test whether the town with the given name exist in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	public boolean containsTown(String v) {
		Town t = new Town(v);
		return g.containsVertex(t);
	}

	@Override
	/**
	 * test whether there is road between this two towns
	 * @param town1 name of town 1 
	 * @param town2 name of town 2 
	 * @return true if the road is in the graph, false if not
	 */
	public boolean containsRoadConnection(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		return g.containsEdge(t1, t2);
	}

	@Override
	/**
	 * return the set of all the names of the 
	 * roads in ascending orders
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	public ArrayList<String> allRoads() {
		Set<Road> s = g.edgeSet();
		int index = 0;
		String[] result = new String[s.size()];
		for(Road r : s) {
			result[index] = r.getName();
			index++;
		}
		index = 0;
		String min = "";
		ArrayList<String> sort = new ArrayList<>();
		
		for(String str : result)
			sort.add(str);
		return sort;
	}

	@Override
	/**
	 * remove the road by using the given information from the graph
	 * @param town1 name of town 1 
	 * @param town2 name of town 2 
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		return g.removeEdge(t1, t2, 0, road) != null;
	}

	@Override
	/**
	 * remove the town with the given name from the graph
	 * @param v name of town 
	 * @return true if the town was successfully deleted, false if not
	 */
	public boolean deleteTown(String v) {
		Town t = new Town(v);
		return g.removeVertex(t);
	}

	@Override
	/**
	 * return a set of the names of existing towns in graph in 
	 * ascending order
	 * @return an arraylist of all towns in alphabetical order 
	 */
	public ArrayList<String> allTowns() {
		Set<Town> s = g.vertexSet();
		int index = 0;
		String[] result = new String[s.size()];
		for(Town r : s) {
			result[index] = r.getName();
			index++;
		}
		String min = "";
		for(int i = 0; i < result.length; i++) {
			min = result[i];
			index = i;
			for(int j = i+1; j < result.length; j++) {
				if(min.compareTo(result[j])>0) {
					min = result[j];
					index = j;
				}
			}
			result[index] = result[i];
			result[i] = min;
		}
		ArrayList<String> sort = new ArrayList<>();
		for(String str: result)
			sort.add(str);
		return sort;
	}

	@Override
	/**
	 * get the shortest path between the two towns with the given names
	 * @param town1 name of town 1 
	 * @param town2 name of town 2 
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	public ArrayList<String> getPath(String town1, String town2) {
		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		
		return g.shortestPath(t1, t2);
	}

}
