import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Road_STUDENT_Test {
	Town t1 , t2;
	Road r;
	  
	@Before
	public void setUp() throws Exception {
		  t1 = new Town("A");
		  t2 = new Town("B");
		  r = new Road(t1,t2,5,"Road");
		 
	}

	@After
	public void tearDown() throws Exception {
		t1 = t2 = null; 
		r = null;
	}

	@Test
	public void testCompareTo() {
		Road n = new Road(t1,t2, 8, "Road");
		assertEquals(0,n.compareTo(r));
	}
	
	@Test
	public void testEquals() {
		Road n = new Road(t1,t2, 8, "Road");
		assertTrue(n.equals(r));
	}

	@Test
	public void testContains() {
		assertTrue(r.contains(t1));
	}
	
	@Test
	public void testGetSource() {
		assertTrue(t1.equals(r.getSource()));
	}
	
	@Test
	public void testGetDestination() {
		assertTrue(t2.equals(r.getDestination()));
	}
	
	@Test
	public void testGetName() {
		assertTrue("Road".equals(r.getName()));
	}
	
	@Test
	public void testGetDistance() {
		assertEquals(5,r.getDistance());
	}
}