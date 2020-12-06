import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * This program represents a graph consisting of towns and roads
 * @author Jiaxi Tang
 *
 */
public class Graph implements GraphInterface<Town, Road>{

	private Set<Town> towns = new HashSet<>();
	private Set<Road> roads = new TreeSet<>();

	@Override
	/**
	 * see whether there are roads between the two towns or not
	 * @return true if there is, false otherwise
	 */
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		Road r = getEdge(sourceVertex, destinationVertex);
		return r != null;
	}

	@Override
	/**
	 * see whether the the given town is in the
	 * graph or not
	 * @return true if there is, false otherwise
	 */
	public boolean containsVertex(Town v) {
		Iterator<Town> i = towns.iterator();
		while(i.hasNext()) {
			if(i.next().equals(v))
				return true;
		}
		return false;
	}

	@Override
	/**
	 * get the road between the tow towns
	 * @return road object if there is such road,
	 * null if there isn't
	 */
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		if(roads.size() == 0)
			return null;
		Road result = null;
		for(Road r: roads) {
			if((r.getSource().equals(sourceVertex) || r.getSource().equals(destinationVertex)) && 
					(r.getDestination().equals(sourceVertex) || r.getDestination().equals(destinationVertex))) {
				result = r;
				break;
			}
		}
		return result;
	}

	@Override
	/**
	 * add one road between two given towns
	 * @return the added Road
	 */
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road r = new Road(sourceVertex, destinationVertex, weight, description);
		if(containsVertex(sourceVertex) && containsVertex(destinationVertex)) {
			roads.add(r);
			sourceVertex.addNearTown(destinationVertex);
			destinationVertex.addNearTown(sourceVertex);
			return r;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	/**
	 * add one town to the graph
	 * @return true if the town is added successfully,
	 * false if such town already exist
	 */
	public boolean addVertex(Town v) {
		boolean duplicate = containsVertex(v);
		if(!duplicate)
			towns.add(v);
		return !duplicate;
	}

	@Override
	/**
	 * @return a set containing all the roads
	 */
	public Set<Road> edgeSet() {
		return roads;
	}

	@Override
	/**
	 * return a set containing all the roads that all adjacent to the same town
	 * @param vertex town object
	 * @return a set of roads
	 */
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> s = new TreeSet<>();
		for(Road r : roads) {
			if(r.getDestination().equals(vertex) || r.getSource().equals(vertex))
				s.add(r);
		}
		return s;
	}

	@Override
	/**
	 * remove one road from the graph
	 * @return the removed road
	 */
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road r = new Road(sourceVertex, destinationVertex, weight, description);
		boolean result = roads.remove(r);
		if(result) {
			sourceVertex.removeNearTown(destinationVertex);
			destinationVertex.removeNearTown(sourceVertex);
			return r;
		}
		else
			return null;
	}

	@Override
	/**
	 * remove the given town and all the roads that are adjacent
	 * to it 
	 * @return true if such action is successfully performed
	 */
	public boolean removeVertex(Town v) {
		ArrayList<Road> remove = new ArrayList<>();
		if(containsVertex(v)) {
			for(Road r : roads) {
				if(r.getDestination().equals(v) || r.getSource().equals(v)) {
					remove.add(r);
				}
			}
			for(Road r : remove){
				removeEdge(r.getSource(),r.getDestination(),r.getDistance(),r.getName());
			}
			towns.remove(v);
			return true;
		}
		return false;
	}

	@Override
	/**
	 * @return a set of existing towns
	 */
	public Set<Town> vertexSet() {
		return towns;
	}

	@Override
	/**
	 * return the shortest path between two towns
	 * @return an arraylist containing the shortest path
	 * between two towns
	 */
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		dijkstraShortestPath(sourceVertex);
		Town t = destinationVertex;
		ArrayList<String> result = new ArrayList<>();
		while(t.getPredecessor() != null) {
			Road r = getEdge(t.getPredecessor(),t);
			result.add(0, r.toString());
			t = t.getPredecessor();
		}
		return result;
	}

	@Override
	/**
	 * shortest path algorithm based on Dijkstra algorithm
	 */
	public void dijkstraShortestPath(Town sourceVertex) {
		resetTown();
		setInf(sourceVertex);
		ArrayList<Town> rank = new ArrayList<>();
		rank.add(sourceVertex);
		Town mark = new Town("text");
		mark.setPathCost(Integer.MAX_VALUE);
		rank.add(mark);
		while(!(rank.get(0).equals(mark))) {
			Town front = rank.remove(0);
			front.visited();
			Iterator<Town> i = front.neighborIterator();
			while(i.hasNext()) {
				Town neighbor = i.next();
				if(!neighbor.isVisited()) {
					Road r = getEdge(front,neighbor);
					if((front.getPathCost() + r.getDistance()) < neighbor.getPathCost()) {
						neighbor.setPathCost(front.getPathCost() + r.getDistance());
						neighbor.setPredecessor(front);
						if(rank.size() == 0)
							rank.add(neighbor);
						else {
							for(int count = 0; count < rank.size(); count++) {
								if(neighbor.getPathCost() < rank.get(count).getPathCost()) { 
									if(!(neighbor.equals(rank.get(count)))) 
										rank.add(count, neighbor);
									else
										rank.get(count).setPathCost(neighbor.getPathCost());
									break;
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * reset the town's data field except for the list of 
	 * near by towns and the name of the town
	 */
	private void resetTown() {
		Iterator<Town> i = towns.iterator();
		while(i.hasNext()) {
			Town t = i.next();
			t.setPathCost(0);
			t.setPredecessor(null);
			t.unvisit();
		}
	}

	/**
	 * set the path cost of the town objects to infinity
	 * except for the provided town
	 * @param origin town object 
	 */
	private void setInf(Town origin) {
		for(Town t: towns) {
			if(!t.equals(origin))
				t.setPathCost(Integer.MAX_VALUE);
		}
	}
}
