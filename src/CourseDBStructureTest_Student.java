

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * @author Professor Kartchner
 */
public class CourseDBStructureTest_Student {
	CourseDBStructure cds, test;

	@Before
	public void setUp() throws Exception {
		cds = new CourseDBStructure(10);
		test = new CourseDBStructure("Testing", 10);
	}

	@After
	public void tearDown() throws Exception {
		cds = test = null;
	}
	
	
	@Test
	public void testGetTableSize()
	{
		assertEquals(10, cds.getTableSize());
		assertEquals(10, test.getTableSize());		
	}
	
	
	@Test
	public void testHashTable()
	{
		//CourseDBStructure cds = new CourseDBStructure(500);
		assertEquals(10, cds.hashTable.length);
		CourseDBElement cde =  new CourseDBElement("CMSC401", 26314, 5, "SC105", "Jerular Basky"); 
		cds.add(cde);
		LinkedList<CourseDBElement> list = cds.hashTable[cde.hashCode()%cds.getTableSize()];
		assertEquals(26314, list.get(0).getCRN());
	}
	
	@Test
	public void testGet()
	{
		CourseDBElement cde1 = new CourseDBElement("CMSC203", 26061, 4, "SC211", "Josepth Jotaro"); 
		CourseDBElement cde2 = new CourseDBElement("CMSC404", 30112, 3, "SC111", "Sora Hikayaki"); 
		cds.add(cde1);
		cds.add(cde2);
		try {
			assertEquals(26061,cds.get(26061).getCRN());
			assertEquals(30112,cds.get(30112).getCRN());
		} catch (IOException e) {
			fail("Should not have thrown an exception");
		}
	}
}