

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 * @author ralexander
 *
 */
public class CourseDBManagerTest_Student {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC204",26414,4,"SC450","Donkin Donuts");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC204",26414,4,"SC450","Donkin Donuts");
		dataMgr.add("CMSC205",26415,4,"SC451","Bomino's Cor");
		dataMgr.add("CMSC206",26416,4,"SC452","Jonson Jonson");
		ArrayList<String> list = dataMgr.showAll();
		//System.out.println(list);
		assertEquals(list.get(0),"Course:CMSC204 CRN:26414 Credits:4 Instructor:Donkin Donuts Room:SC450");
		assertEquals(list.get(1),"Course:CMSC205 CRN:26415 Credits:4 Instructor:Bomino's Cor Room:SC451");
		assertEquals(list.get(2),"Course:CMSC206 CRN:26416 Credits:4 Instructor:Jonson Jonson Room:SC452");
			}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 26414 4 SC450 Donkin Donuts");
			inFile.print("CMSC205 26415 4 SC451 Bomino's Cor");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			//System.out.println(dataMgr.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}