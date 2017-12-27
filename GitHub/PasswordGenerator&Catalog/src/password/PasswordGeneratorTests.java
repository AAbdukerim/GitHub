package password;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordGeneratorTests {
	PasswordGenerator pGen = new PasswordGenerator();
	
	@Test
	public void getRandomUppercaseLettersTest1() {
		String retv = pGen.getRandomUppercaseLetters(3);
		checkIfInValidUpper(retv,3);
	}
	
	@Test
	public void getRandomUppercaseLettersTest2() {
		String retv = pGen.getRandomUppercaseLetters(10);
		checkIfInValidUpper(retv,10);
	}
	
	@Test
	public void getRandomLowercaseLettersTest1() {
		String retv = pGen.getRandomLowercaseLetters(3);
		checkIfInValidLower(retv,3);
	}
	
	@Test
	public void getRandomLowercaseLettersTest2() {
		String retv = pGen.getRandomLowercaseLetters(10);
		checkIfInValidLower(retv,10);
	}
	
	@Test
	public void getRandomSpecialCharsTest1() {
		String retv = pGen.getRandomSpecialChars(3);
		checkIfInValidChars(retv,3);
	}
	
	@Test
	public void getRandomSpecialCharsTest2() {
		String retv = pGen.getRandomSpecialChars(10);
		checkIfInValidChars(retv,10);
	}
	
	@Test
	public void getRandomNumbersTest1() {
		String retv = pGen.getRandomNumbers(3);
		checkIfInValidNums(retv,3);
	}
	
	@Test
	public void getRandomNumbersTest2() {
		String retv = pGen.getRandomNumbers(10);
		checkIfInValidNums(retv,10);
	}
	
	private void checkIfInValidNums(String retv,int count) {
		if(retv.length() != count) {
			fail("Numbers count mismatched");
			return;
		}
		
		for (char s : retv.toCharArray()) {
			if (!pGen.numbers.contains(s+"")) {
				fail(s + " is unexpected number");
			}
		}
		
	}
	
	private void checkIfInValidChars(String retv,int count) {
		if(retv.length() != count) {
			fail("Uppercase letters count mismatched");
			return;
		}
		
		for (char s : retv.toCharArray()) {
			if (!pGen.specialChars.contains(s+"")) {
				fail(s + " is unexpected char");
			}
		}
		
	}

	private void checkIfInValidUpper(String retv,int count) {
		if(retv.length() != count) {
			fail("Uppercase letters count mismatched");
			return;
		}
		
		for (char s : retv.toCharArray()) {
			if (!pGen.upperCaseLetters.contains(s+"")) {
				fail(s + " is unexpected uppercase letter");
			}
		}
		
	}
	
	private void checkIfInValidLower(String retv,int count) {
		if(retv.length() != count) {
			fail("Lowercase letters count mismatched");
			return;
		}
		
		for (char s : retv.toCharArray()) {
			if (!pGen.lowerCaseLetters.contains(s+"")) {
				fail(s + " is unexpected lowercase letter");
			}
		}
		
	}

}
