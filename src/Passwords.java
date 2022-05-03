import java.util.ArrayList;
import java.util.Scanner;

public class Passwords {

	public static Scanner scnr = new Scanner(System.in);
	public static ArrayList<String> passwordList = new ArrayList<String>();

	public static void main(String[] args) {

		String in = userInput();
		System.out.println(addPassword(in));

		scnr.close();
	}

	public static String userInput() {
		System.out.println(
				"Please enter a password that has:\n\n - Between 7-12 characters\n - At least 1 number, it cannot contain a 6\n - It connot contain spaces\n - Has two uppercase Vowels\n - \'mod\' and \'admin\' are acceptable passowords\n");
		String in = scnr.nextLine();
		return in;
	}

	public static boolean addPassword(String in) {
		if (alreadyExists(in) == false && validException(in) == true) {
			passwordList.add(in);
			System.out.println(in + " is a valid password");
			return true;
		} else if (alreadyExists(in) == false && validException(in) == false && checkLength(in) == true
				&& validNumber(in) == true && noSpaces(in) == true && checkVowels(in) == true) {
			passwordList.add(in);
			System.out.println(in + " is a valid password");
			return true;
		} else {
			System.out.println(in + " is NOT a valid password");
			return false;
		}

	}

	// false = does not exist
	public static boolean alreadyExists(String in) {
//		System.out.println(in + " already exists, its not valid");
		return passwordList.contains(in);
	}

	// true = valid length
	public static boolean checkLength(String in) {
		return in.length() > 7 && in.length() < 12;

	}

	// true = password has at least 1 number and its not 6
	public static boolean validNumber(String in) {

		// if the input string has a 6 the condition returns true
		if (in.matches(".*[0-9].*")) {
			if (in.matches(".*6.*")) {
//				System.out.println(in + " contains a 6, it is invalid");
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	// true = password has no space.
	public static boolean noSpaces(String in) {
		if (in.matches(".*[ ].*")) {
//			System.out.println(in +"Contains a SPACE, it is invalid");
			return false;
		}
		return true;
	}

	// true = contains 2 capital vowels
	public static boolean checkVowels(String in) {
		int vowelCount = 0;
		for (int i = 0; i < in.length(); i++) {
			char ch = in.charAt(i);
			if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'Y') {
				vowelCount += 1;
			}
		}
		if (vowelCount >= 2) {
			return true;
		} else {
			return false;
		}
	}

	// true = password is either "admin" or "mod"
	public static boolean validException(String in) {
		String inLower = in.toLowerCase();
		if (inLower.toString() == "admin" || inLower.toString() == "mod") {
			return true;
		} else {
			return false;
		}

	}
}
