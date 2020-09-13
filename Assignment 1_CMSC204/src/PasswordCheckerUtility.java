import java.util.ArrayList;
/**
 * This program is to check the validity of passwords
 * @author Jiaxi Tang
 */
public class PasswordCheckerUtility {
	/**
	 * check if password is valid
	 * @param passwordString string containing the password
	 * @return true if password is valid, false if not.
	 * @throws LengthException Password is less than 6 characters long
	 * @throws NoUpperAlphaException Password contains no uppercase character
	 * @throws NoLowerAlphaException Password contains no lowercase character
	 * @throws NoDigitException Password contains no numeric character
	 * @throws NoSpecialCharacterException Password contains no special character
	 * @throws InvalidSequenceException Password contains more than 2 same characters in sequence.
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException,
																		NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		isValidLength(password);
		hasUpperAlpha(password);
		hasLowerAlpha(password);
		hasDigit (password);
		hasSpecialChar (password);
		hasSameCharInSequence(password);
		return true;
	}
	
	/**
	 * check if password is weak
	 * @param passwordString string containing password
	 * @return true if password length is greater than or equal to 6 and less and equal to 9.
	 */
	public static boolean isWeakPassword(String passwordString){
		if(passwordString.length()>=6&& passwordString.length()<=9)
			return true;
		return false;
	}
	
	/**
	 * return arraylist containing invalid passwords with error message.
	 * @param passwords arraylist containing password
	 * @return arraylist containing invalid passwords with error message.
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String> back = new ArrayList<>();
		for(String str : passwords) {
			try {
				isValidPassword(str);
			}
			catch(LengthException e) {
				back.add(str+" -> The password must be at least 6 characters long");
			}
			catch(NoUpperAlphaException e) {
				back.add(str+" -> The password must contain at least one uppercase alphabetic character");
			}
			catch(NoLowerAlphaException e) {
				back.add(str+" -> The password must contain at least one lower case alphabetic character");
			}
			catch(NoDigitException e) {
				back.add(str+" -> The password must contain at least one digit");
			}
			catch(NoSpecialCharacterException e) {
				back.add(str+" -> The password must contain at least one special character");
			}
			catch(InvalidSequenceException e) {
				back.add(str+" -> The password cannot contain more than two of the same character in sequence");
			}
		}
		return back;
	}
	
	/**
	 * Checks if password is valid but not between 6 -9 characters
	 * @param password string to be checked if weak password
	 * @return true if password contains 6 to 9 characters
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if(password.length()>=6&& password.length()<=9)
			return true;
		return false;
	}
	
	/**
	 * check if password is less than 5 characters long
	 * @param passwordString string containing password
	 * @return true if password length is greater than 6 false if not.
	 * @throws LengthException thrown if does not meet min length requirement
	 */
	public static boolean isValidLength(String passwordString) throws LengthException{
		if(passwordString.length()<6) 
			throw new LengthException();
		return true;
	}

	/**
	 * check if password contains uppercase character
	 * @param passwordString string containing password
	 * @return true if password contains uppercase character false if not.
	 * @throws NoUpperAlphaException thrown if does not meet alpha character requirement
	 */
	public static boolean hasUpperAlpha(String passwordString) throws NoUpperAlphaException{
		for (int i = 0; i < passwordString.length(); i++) {
			if(passwordString.charAt(i)>='A'&&passwordString.charAt(i)<='Z')
				return true;
		}
		throw new NoUpperAlphaException();
	}

	/**
	 * check if password contains lowercase character
	 * @param passwordString string containing password
	 * @return true if password contains lowercase character false if not.
	 * @throws NoLowerAlphaException thrown if does not meet lowercase requirement
	 */
	public static boolean hasLowerAlpha(String passwordString) throws NoLowerAlphaException {
		for (int i = 0; i < passwordString.length(); i++) {
			if(passwordString.charAt(i)>='a'&&passwordString.length()<='z')
				return true;
		}
		throw new NoLowerAlphaException();
	}

	/**
	 * check if password contains numeric character
	 * @param passwordString string containing password
	 * @return true if password contains numeric character false if not.
	 * @throws NoDigitException thrown if does not meet Digit requirement
	 */
	public static boolean hasDigit(String passwordString) throws NoDigitException{
		for (int i = 0; i < passwordString.length(); i++) {
			if(Character.isDigit(passwordString.charAt(i)))
				return true;
		}
		throw new NoDigitException();
	}

	/**
	 * check if password contains special character
	 * @param passwordString string containing password
	 * @return true if password contains special character
	 * @throws NoSpecialCharacterException thrown if does not meet SpecialCharacter requirement
	 */
	public static boolean hasSpecialChar (String password) throws NoSpecialCharacterException{
		//32-47, 58-64, 91-96, 123-126
		for (int i = 0; i < password.length(); i++) {
			if((int)(password.charAt(i))>=32 && (int)(password.charAt(i))<=47) {
				return true;
			}
			else if((int)(password.charAt(i))>=58 && (int)(password.charAt(i))<=64) {
				return true;
			}
			else if((int)(password.charAt(i))>=91 && (int)(password.charAt(i))<=96) {
				return true;
			}
			else if((int)(password.charAt(i))>=123 && (int)(password.charAt(i))<=126) {
				return true;
			}
		}
		throw new NoSpecialCharacterException();
	}

	/**
	 * check if password contains more than 2 same characters in sequence
	 * @param passwordString string containing password
	 * @return if password contains no more than 2 same characters in sequence, return true
	 * @throws InvalidSequenceException thrown if does not meet Sequence requirement
	 */
	public static boolean hasSameCharInSequence(String passwordString) throws InvalidSequenceException{
		for (int i = 0; i < passwordString.length()-2; i++) {
			if(passwordString.charAt(i)==passwordString.charAt(i+1)&&
					passwordString.charAt(i)==passwordString.charAt(i+2))
				throw new InvalidSequenceException();
		}
		return true;
	}
	
	/**
	 * Compare length of two passwords
	 * @param password password string to be checked for length
	 * @param passwordConfirm passwordConfirm string to be checked against password for length
	 * @throws UnmatchedException thrown if not same length
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		if(!comparePasswordsWithReturn(password, passwordConfirm))
			throw new UnmatchedException(); 
	}
	
	/**
	 * Compare length of two passwords
	 * @param password password string to be checked for length
	 * @param passwordConfirm passwordConfirm string to be checked against password for length
	 * @throws UnmatchedException thrown if not same length
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
		if(password.length()!=passwordConfirm.length())
			return false;
		for (int i =0; i<password.length(); i++) {
			if(password.charAt(i)!=passwordConfirm.charAt(i))
				return false;
		}
		return true;
	}
}
