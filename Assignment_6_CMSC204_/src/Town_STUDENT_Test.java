import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Town_STUDENT_Test {
	Town t1 ;
	  
	@Before
	public void setUp() throws Exception {
		  t1 = new Town("A");
		 
	}

	@After
	public void tearDown() throws Exception {
		t1 = null;
	}

	@Test
	public void testCompareTo() {
		Town n = new Town("A");
		assertEquals(0,n.compareTo(t1));
	}
	
	@Test
	public void testEquals() {
		Town n = new Town("A");
		assertTrue(n.equals(t1));
	}
	
	@Test
	public void testHashCode() {
		assertEquals("A".hashCode(),t1.hashCode());
	}
	
	@Test
	public void testGetName() {
		assertEquals("A", t1.getName());
	}
	
	@Test
	public void testVisit() {
		t1.visited();
		assertTrue(t1.isVisited());
		t1.unvisit();
		assertFalse(t1.isVisited());
	}
	
	@Test
	public void testAddNearTowns() {
		Town near = new Town("B");
		t1.addNearTown(near);
		Iterator<Town> i = t1.neighborIterator();
		assertTrue(i.next().equals(near));
	}
	
	@Test
	public void testPathCost() {
		t1.setPathCost(50);
		assertEquals(50, t1.getPathCost());
	}
	
	@Test
	public void testPredecessor() {
		Town y = new Town("B");
		t1.setPredecessor(y);
		assertEquals(y,t1.getPredecessor());
	}
}