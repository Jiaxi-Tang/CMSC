
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Graph_STUDENT_Test {
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@Before
	public void setUp() throws Exception {
		 graph = new Graph();
		  town = new Town[4];
		  
		  for (int i = 0; i < 4; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		  }
		  
		  graph.addEdge(town[0], town[1], 2, "Road_1");
		  graph.addEdge(town[0], town[2], 4, "Road_2");
		  graph.addEdge(town[1], town[2], 3, "Road_3");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	 @Test
	  public void testTown0ToTown_2() {
		  String beginTown = "Town_0", endTown = "Town_2";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {
			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_0 via Road_2 to Town_2 4 mi",path.get(0).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[2]));
		graph.removeVertex(town[2]);
		assertEquals(false, graph.containsVertex(town[2]));
	}
	
	@Test
	public void testGetEdge() {
		assertEquals(new Road(town[0], town[1],2, "Road_1"), graph.getEdge(town[0], town[1]));
		assertEquals(new Road(town[1], town[2],3, "Road_3"), graph.getEdge(town[1], town[2]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[0], town[3]));
		graph.addEdge(town[0], town[3], 1, "Road_4");
		assertEquals(true, graph.containsEdge(town[0], town[3]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Town_5");
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[0], town[1]));
		assertEquals(false, graph.containsEdge(town[0], town[3]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_2")));
		assertEquals(false, graph.containsVertex(new Town("Town_12")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_2", roadArrayList.get(1));
		assertEquals("Road_3", roadArrayList.get(2));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = graph.edgesOf(town[0]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_2", roadArrayList.get(1));
	}
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[0], town[1]));
		graph.removeEdge(town[0], town[1], 2, "Road_1");
		assertEquals(false, graph.containsEdge(town[0], town[1]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[0]));
		assertEquals(true, roads.contains(town[1]));
		assertEquals(true, roads.contains(town[2]));
	}
}
