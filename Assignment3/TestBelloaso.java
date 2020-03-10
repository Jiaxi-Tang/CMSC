import java.util.Scanner;

public class TestBelloaso {

	public static void main(String[] args) {
		String str, enStr, deStr;
		String key = "A";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		str = sc.nextLine();
		System.out.println("The key is "+key);
		str = str.toUpperCase();
		if(!CryptoManager.stringInBounds(str))
			System.out.println("String not in range");
		else {
			enStr = CryptoManager.encryptBellaso(str, key);
			System.out.println("The encrypted string is "+enStr);
			deStr = CryptoManager.decryptBellaso(enStr, key);
			System.out.println("The decrypted string is "+deStr);
		}
	}

}
