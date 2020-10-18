//package _solution;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedList_STUDENT_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	StringComparator comparator;
	DoubleComparator comparatorD;

	
	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
	}

	
	@Test
	public void testIteratorSuccessfulStringPreviousI() {
		sortedLinkedString.add("e");
		sortedLinkedString.add("c");
		sortedLinkedString.add("b");
		sortedLinkedString.add("d");

		
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("b", iterator.next());
		assertEquals("c", iterator.next());
		assertEquals("d", iterator.next());
		assertEquals("e", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("e", iterator.previous());
		assertEquals("d", iterator.previous());
		assertEquals("c", iterator.previous());
	}
	
	
	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		sortedLinkedString.add("e");
		sortedLinkedString.add("c");
		sortedLinkedString.add("b");
		sortedLinkedString.add("d");

		
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("b", iterator.next());
		assertEquals("c", iterator.next());
		assertEquals("d", iterator.next());
		assertEquals("e", iterator.next());
		assertEquals(false, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPreviousII() {
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add(new Double(1));
		sortedLinkedDouble.add(new Double(3));
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(7));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(1), iterator.next());
		assertEquals(new Double(3), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(true, iterator.hasNext());	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add(new Double(1));
		sortedLinkedDouble.add(new Double(3));
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(7));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		
		assertEquals(new Double(1), iterator.next());
		assertEquals(new Double(3), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		//assertEquals(new Double(10), iterator.previous());
		assertEquals(new Double(5), iterator.previous());
		assertEquals(true, iterator.hasPrevious());
		
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		try{
			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorUnsupportedOperationExceptionString() {
		
		ListIterator<String> iterator = sortedLinkedString.iterator();
		
		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	


	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	
}