import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	GradeBook g1, g2;
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g1.addScore(50);
		g1.addScore(78);
		g2.addScore(90);
		g2.addScore(100);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = g2 = null;
	}

	@Test
	void testGetScoreSize() {
		assertEquals(g1.getScoreSize(), 2, "Array 1 has errors.");
		assertEquals(g2.getScoreSize(), 2, "Array 2 has errors.");
	}

	@Test
	void testToString() {
		//fail("Not yet implemented");
	}

	@Test
	void testAddScore() {
		assertEquals(g1.toString(), "The scores are: 50.0 78.0 0.0 0.0 0.0 ", "Array 1 has errors.");
		assertEquals(g2.toString(), "The scores are: 90.0 100.0 0.0 0.0 0.0 ", "Array 2 has errors.");
		assertEquals(g1.getScoreSize(), 2, "Array 1 has errors.");
		assertEquals(g2.getScoreSize(), 2, "Array 2 has errors.");
	}

	@Test
	void testSum() {
		assertEquals(g1.sum(), 128, "Array 1 has errors.");
		assertEquals(g2.sum(), 190, "Array 2 has errors.");
	}

	@Test
	void testMinimum() {
		assertEquals(g1.minimum(), 50, "Array 1 has errors.");
		assertEquals(g2.minimum(), 90, "Array 2 has errors.");
	}

	@Test
	void testFinalScore() {
		assertEquals(g1.finalScore(), 78, "Array 1 has errors.");
		assertEquals(g2.finalScore(), 100, "Array 2 has errors.");
	}

}
