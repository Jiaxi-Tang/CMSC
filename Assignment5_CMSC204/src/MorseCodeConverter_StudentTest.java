import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverter_StudentTest {
	File inputFile;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrintTree()
	{
		//Note the extra space between j and b - that is because there is an empty string that
		//is the root, and in the LNR traversal, the root would come between the right most
		//child of the left tree (j) and the left most child of the right tree (b).
		String correctResult = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		String s = MorseCodeConverter.printTree();
		s = s.trim(); // take off preceding or succeeding spaces
		assertEquals(correctResult, s);
	}
	
	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish(".- -... -.-. -.. ");
		assertEquals("abcd",converter1);
			
		String converter2 = MorseCodeConverter.convertToEnglish("--- -. . / - .-- --- / - .... .-. . . ");
		assertEquals("one two three", converter2);
	}

	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		String test1="give me your answer do";		
		File f = new File("normal.txt");
		try {
		FileWriter out = new FileWriter(f);
		out.write(".- -... -.-. / --- -. . / - .-- --- / - .... .-. . . ");
		out.close();
		assertEquals("abc one two three", MorseCodeConverter.convertToEnglish(f));
		}
		catch(Exception e) {
			fail("Shouldn't have errors");
		}


	}
	

}