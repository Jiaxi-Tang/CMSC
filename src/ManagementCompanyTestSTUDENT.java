

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany m;
	Property p1,p2,p3;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m = new ManagementCompany("Manage", "1234", 10);
		//student add three properties, with plots, to mgmt co
		p1 = new Property("AAA","RV",3000,"Hohn",2,2,2,2);
		p2 = new Property("BBB","RV",2000,"Iohn",4,4,2,2);
		p3 = new Property("CCC","RV",1000,"John",3,1,1,1);
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		m = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(3,m.addProperty("DDD", "RV", 500, "Kohn"));
		//student should add property with 8 args
		assertEquals(4,m.addProperty("EEE","RV",250,"Lohn",7,5,1,1));
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		assertEquals(-1,m.addProperty("FFF", "RV", 100, "ABC", 8, 8, 1, 1));
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(3000,m.maxRentProp(),0.01);
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(6000,m.totalRent(),0.01);
	}

 }