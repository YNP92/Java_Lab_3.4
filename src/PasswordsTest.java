import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PasswordsTest {

	@Test
	void alreadyExistsTest() {

		Passwords.passwordList.add("admin");
		String t1 = "admin";
		String t2 = "coolbeans";
		assertEquals(true, Passwords.alreadyExists(t1));
		assertEquals(false, Passwords.alreadyExists(t2));
	}
	@Test
	void checkLengthTest() {
		String t1 = "short";
		String t2 = "reallythisislong";
		String t3 = "justright";
		assertEquals(false, Passwords.checkLength(t1));
		assertEquals(false, Passwords.checkLength(t2));
		assertEquals(true, Passwords.checkLength(t3));
	}

	@Test
	void validNumberTest() {
		String t1 = "1adfads";
		String t2 = "adasdfs6";
		String t3 = "asdfasd";
		assertEquals(true, Passwords.validNumber(t1));
		assertEquals(false, Passwords.validNumber(t2));
		assertEquals(false, Passwords.validNumber(t3));
	}

	@Test
	void noSpacesTest() {
		String t1 = " ";
		String t2 = "s  s";
		String t3 = "muppet";
		assertEquals(false, Passwords.noSpaces(t1));
		assertEquals(false, Passwords.noSpaces(t2));
		assertEquals(true, Passwords.noSpaces(t3));
	}

	@Test
	void checkVowelsTest() {
		String t1 = "ppppppp";
		String t2 = "ippppppp";
		String t3 = "iipppppp";
		String t4 = "IIpppppp";
		assertEquals(false, Passwords.checkVowels(t1));
		assertEquals(false, Passwords.checkVowels(t2));
		assertEquals(false, Passwords.checkVowels(t3));
		assertEquals(true, Passwords.checkVowels(t4));
	}

	@Test
	void validExceptionTest() {
		Passwords.passwordList.add("admin");
		Passwords.passwordList.add("mod");
		String t1 = "admin";
		String t2 = "mod";
		String t3 = "daafff";
		assertEquals(true, Passwords.validException(t1));
		assertEquals(true, Passwords.validException(t2));
		assertEquals(false, Passwords.validException(t3));
	}

	@Test
	void addPasswordTest() {
		Passwords.passwordList.add("AlrEady1hur");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("AlrEady1hur");
		expected.add("admin");
		expected.add("mod");
		expected.add("bOOk1taco");
		String t1 = "AlrEady1hur";
		String t2 = "admin";
		String t3 = "mod";
		String t4 = "bOOk1taco";
		String t5 = "book1taco";
		String t6 = "bOOk6taco";
		String t7 = "bOOk1 taco";		
		assertEquals(false,Passwords.addPassword(t1));
		assertEquals(true,Passwords.addPassword(t2));
		assertEquals(true,Passwords.addPassword(t3));
		assertEquals(true,Passwords.addPassword(t4));
		assertEquals(false,Passwords.addPassword(t5));
		assertEquals(false,Passwords.addPassword(t6));
		assertEquals(false,Passwords.addPassword(t7));
		System.out.println("\n"+ expected.toString() + "length: " + expected.size()+"\n") ;
		System.out.println("\n"+ Passwords.passwordList.toString()+ "length: "+ Passwords.passwordList.size()+"\n");
		
		assertArrayEquals(expected.toArray(), Passwords.passwordList.toArray());
		
	}
//	Passwords.passwordList.add("");
//	Passwords.passwordList.add("");
//	Passwords.passwordList.add("");
//	String t1 = "";
//	String t2 = "";
//	String t3 = "";
//	assertEquals(null, null);
//	assertEquals(null, null);
//	assertEquals(null, null);
	

}
