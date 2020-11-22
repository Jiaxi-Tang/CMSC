import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTree_StudentTest {
	MorseCodeTree m;
	@Before
	public void setUp() throws Exception {
		m = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		m = null;
	}

	@Test
	public void testAddNode_and_toArrayList() {	
		ArrayList<String> t = m.toArrayList();
		String s = "";
		for(String str: t) {
			s += str + " ";
		}
		s = s.substring(0,s.length()-1);
		assertEquals(s,"h s v i f u e l r a p w j  b d x n c k y t z g q m o");
	}

}