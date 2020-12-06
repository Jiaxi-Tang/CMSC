


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[4];
		  
		  for (int i = 0; i < 4; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[0], town[1], 2, "Road_1");
		  graph.addRoad(town[0], town[2], 3, "Road_2");
		  graph.addRoad(town[1], town[2], 6, "Road_3");
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_3", roads.get(2));
		graph.addRoad(town[0], town[3], 1,"Road_4");
		roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_3", roads.get(2));
		assertEquals("Road_4", roads.get(3));
		
	}
	
	@Test
	public void testGetPath() {
		  ArrayList<String> path = graph.getPath(town[0],town[2]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_0 via Road_2 to Town_2 3 mi",path.get(0).trim());

	}

	@Test
	public void testGetRoad() {
		assertEquals("Road_1", graph.getRoad(town[0], town[1]));
		assertEquals("Road_2", graph.getRoad(town[0], town[2]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Town_12"));
		graph.addTown("Town_12");
		assertEquals(true, graph.containsTown("Town_12"));
	}
	
	@Test
	public void testDisjointGraph() {
		assertEquals(false, graph.containsTown("Town_5"));
		graph.addTown("Town_5");
		ArrayList<String> path = graph.getPath(town[1],"Town_5");
		assertFalse(path.size() > 0);
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_2"));
		assertEquals(false, graph.containsTown("Town_12"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[0], town[1]));
		assertEquals(false, graph.containsRoadConnection(town[0], town[3]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_3", roads.get(2));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[0], town[1]));
		graph.deleteRoadConnection(town[0], town[1], "Road_1");
		assertEquals(false, graph.containsRoadConnection(town[1], town[0]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_2"));
		graph.deleteTown(town[2]);
		assertEquals(false, graph.containsTown("Town_2"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		
		for(String str: roads)
			System.out.println(str);
		
		assertEquals("Town_0", roads.get(0));
		assertEquals("Town_1", roads.get(1));
		assertEquals("Town_2", roads.get(2));
		assertEquals("Town_3", roads.get(3));
	}
	
}