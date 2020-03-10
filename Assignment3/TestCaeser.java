import java.util.Scanner;

public class TestCaeser {
	public static void main(String[] args) {
		String str, enStr, deStr;
		int key = 50;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		str = sc.nextLine();
		System.out.println("The key is "+key);
		str = str.toUpperCase();
		if(!CryptoManager.stringInBounds(str))
			System.out.println("String not in range");
		else {
			System.out.println("The key is "+key);
			enStr = CryptoManager.encryptCaesar(str, key);
			System.out.println("The encrypted string is "+enStr);
			deStr = CryptoManager.decryptCaesar(enStr, key);
			System.out.println("The decrypted string is "+deStr);
		}
	}
}
