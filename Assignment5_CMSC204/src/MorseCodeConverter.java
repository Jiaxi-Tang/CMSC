import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program convert morse code to English
 * @author Jiaxi Tang
 *
 */
public class MorseCodeConverter {
	private static MorseCodeTree t = new MorseCodeTree();
	
	/**
	 * convert a morse code file to English
	 * @param file the file object which contains the morse code
	 * @return a string containing the translated English
	 * @throws FileNotFoundException 
	 */
	public static String convertToEnglish(File file) throws FileNotFoundException{
		String result = "", string = "";
		String[] token;
		Scanner in = new Scanner(file);
		while(in.hasNext()) {
			string+=in.nextLine();
		}
		token = string.split("\n");
		for(int i = 0; i < token.length; i++) {
			result += convertToEnglish(token[i]);
		}
		return result;
	}
	
	/**
	 * convert morse code to English
	 * @param code the string containing morse code
	 * @return string containing the translated English
	 */
	public static String convertToEnglish(String code) {
		String result = "";
		String[] word, letter;
		word = code.split("/");
		for(int i = 0; i < word.length; i++) {
			letter = word[i].split(" ");
			for(int j = 0; j<letter.length;j++) {
				if(!letter[j].equals(""))
					result += t.fetch(letter[j]);
			}
			result += " ";
		}
		return result.substring(0, result.length()-1);
	}
	
	/**
	 * convert the morse code tree into string in "in order" order
	 * @return the string containing the tree
	 */
	public static String printTree() {
		String result = "";
		ArrayList<String> str = t.toArrayList();
		for(String s : str) {
			result += s + " ";
		}
		return result.substring(0, result.length()-1);
	}
}
