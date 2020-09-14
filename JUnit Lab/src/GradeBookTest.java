import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	GradeBook grade1, grade2;
	
	@BeforeEach
	void setUp() throws Exception {
		grade1 = new GradeBook(5);
		grade1.addScore(100);
		grade1.addScore(98);
		grade1.addScore(87);
		
		grade2 = new GradeBook(5);
		grade2.addScore(76);
		grade2.addScore(90);
	}

	@AfterEach
	void tearDown() throws Exception {
		grade1=grade2=null;
	}

	@Test
	void testGetScoreSize() {
		assertEquals(grade1.getScoreSize(),3);
		assertEquals(grade2.getScoreSize(),2);
	}

	@Test
	void testAddScore() {
		assertTrue(grade1.toString().equals("100.0 98.0 87.0 "));
		assertEquals(grade1.getScoreSize(),3);
		assertTrue(grade2.toString().equals("76.0 90.0 "));
		assertEquals(grade2.getScoreSize(),2);
	}

	@Test
	void testSum() {
		assertEquals(grade1.sum(), 285);
		assertEquals(grade2.sum(), 166);
	}

	@Test
	void testMinimum() {
		assertEquals(grade1.minimum(), 87);
		assertEquals(grade2.minimum(), 76);
	}

	@Test
	void testFinalScore() {
		assertEquals(grade1.finalScore(), 198);
		assertEquals(grade2.finalScore(), 90);
	}

	@Test
	void testToString() {
		assertTrue(grade1.toString().equals("100.0 98.0 87.0 "));
		assertTrue(grade2.toString().equals("76.0 90.0 "));
	}

}
