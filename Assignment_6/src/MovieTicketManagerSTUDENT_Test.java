

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTicketManagerSTUDENT_Test {
	private MovieTicketManager ticketList;
	

	@Before
	public void setUp() throws Exception {
		ticketList = new MovieTicketManager();
		
		//addTicket(String movie, String rating, int day, int time, String type, String customer, int id)
		
		//Student add adult tickets
		ticketList.addTicket("Sky War", "G", 10, 10, "NONE", "Adult", 0);
		//Student add children tickets
		ticketList.addTicket("Sky War II", "PG", 10, 18, "3D", "Child", 0);
		//Student add employee tickets
		ticketList.addTicket("Sky War II", "PG", 10, 18, "IMAX", "Employee", 11111);
		//Student add MoviePass member tickets
		ticketList.addTicket("Sky War II", "PG", 10, 18, "NONE", "MoviePass", 33344);
	}

	@After
	public void tearDown() throws Exception {
		//Student set ticketList to null;
		ticketList = null;
	}

	/**
	 * Student Test the number of visits to the theater within the month
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumVisits() {
		//Student test Employees' number of visits
		assertEquals(1,ticketList.numVisits(11111));
		//Student test MoviePass members' number of visits
		assertEquals(1,ticketList.numVisits(33344));
	}

	/**
	 * Student Test the number of times this movie has been viewed
	 * This only applied to those who have id numbers - Employees or MoviePass members
	 */
	@Test
	public void testNumThisMovie() {
		//Student test Employees' number of views
		assertEquals(1,ticketList.numThisMovie(11111, "Sky War II"));
		//Student test MoviePass members' number of views
		assertEquals(1,ticketList.numThisMovie(33344, "Sky War II"));
	}

}