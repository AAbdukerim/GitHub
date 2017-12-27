package password;

import java.util.Random;

/**
 * Develop a utility class that can be used to generate random passwords. It can
 * also be used to encrypt/decrypt texts, passwords
 */

public class PasswordGenerator {

	/**
	 * METHODS MENU: getRandomUppercaseLetters getRandomLowercaseLetters
	 * getRandomSpecialChars getRandomNumbers generatePassword encryptText
	 * decryptText
	 */

	public static void main(String[] args) {
		PasswordGenerator pg = new PasswordGenerator();
		System.out.println("------getRandomUppercaseLetters-----");
		System.out.println(pg.getRandomUppercaseLetters(3));

		System.out.println("------getRandomLowercaseLetters-----");
		System.out.println(pg.getRandomLowercaseLetters(3));

		System.out.println("------getRandomSpecialChars-----");
		System.out.println(pg.getRandomSpecialChars(3));

		System.out.println("------getRandomNumbers-----");
		System.out.println(pg.getRandomNumbers(3));

		System.out.println("------generatePassword-----");
		System.out.println(pg.generatePassword(2, 5, 2, 3));

		System.out.println("------encryptText-----");
		System.out.println(pg.encryptText("HELLO"));

		System.out.println("------decryptText-----");
		System.out.println(pg.decryptText("HELLO"));

	}

	String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	String specialChars = "!@#$%^&*(_";
	String numbers = "0123456789";

	String upperCipherAlphabet = "PHQGIUMEAYLNOFDXJKRCVSTZWB";
	String lowerCipherAlphabet = "phqgiumeaylnofdxjkrcvstzwb";

	NumbersUtil numsUtil = new NumbersUtil();

	/**
	 * Method that accepts a number and returns that many random letters taken from
	 * upperCaseLetters variable above
	 * 
	 * @param count
	 * @return String
	 */
	public String getRandomUppercaseLetters(int count) {

		String randomUpperstr = "";
		for (int i = 1; i <= count; i++) {

			int index = numsUtil.getRandomInt(25);
			randomUpperstr += upperCaseLetters.charAt(index) + "";
		}
		return randomUpperstr;

	}

	/**
	 * Method that accepts a number and returns that many random letters taken from
	 * lowerCaseLetters variable above
	 * 
	 * @param count
	 * @return String
	 */

	public String getRandomLowercaseLetters(int count) {

		String randomLowerstr = "";
		for (int i = 1; i <= count; i++) {

			int index = numsUtil.getRandomInt(25);
			randomLowerstr += lowerCaseLetters.charAt(index) + "";
		}
		return randomLowerstr;
	}

	/**
	 * Method that accepts a number and returns that many random characters taken
	 * from specialChars variable above
	 * 
	 * @param count
	 * @return String
	 */
	public String getRandomSpecialChars(int count) {
		String randomChars = "";
		for (int i = 1; i <= count; i++) {
			int index = numsUtil.getRandomInt(specialChars.length() - 1);
			randomChars += specialChars.charAt(index);

		}
		return randomChars;
	}

	/**
	 * Method that accepts a number and returns that many random numbers taken from
	 * numbers variable above
	 * 
	 * @param count
	 * @return String
	 */

	public String getRandomNumbers(int count) {
		String randomnum = "";

		for (int r = 1; r <= count; r++) {
			int index = numsUtil.getRandomInt(10);
			randomnum += numbers.charAt(index);
		}
		return randomnum;
	}

	/**
	 * Write a method that returns a password which is mix of uppercase and
	 * lowercase letters and special characters,numbers. This method calls 4 other
	 * methods.
	 * 
	 * @param upper
	 *            - how many uppercase letters -> pass to getRandomUppercaseLetters
	 * @param lower
	 *            - how many lowercase letters -> pass to getRandomLowercaseLetters
	 * @param special
	 *            - how many special characters -> pass to getRandomSpecialChars
	 * @param num
	 *            - how many numbers -> pass to getRandomNumbers
	 * @return String - generated password by using methods above
	 */
	public String generatePassword(int upper, int lower, int special, int num) {

		return getRandomUppercaseLetters(upper) + getRandomLowercaseLetters(lower) + getRandomSpecialChars(special)
				+ getRandomNumbers(num);
	}

	/**
	 * Accepts a character and returns encrypted version. Take a character and
	 * covert to corresponding character by index upperCaseLetters ->
	 * upperCipherAlphabet lowerCaseLetters -> lowerCipherAlphabet specialChars ->
	 * numbers numbers -> specialChars
	 * 
	 * 
	 * @param sChar
	 *            - character to encrypt
	 * @return
	 */
	public String encryptChar(String sChar) {
		String encrypted = "";
		if (upperCaseLetters.contains(sChar)) {
			int pos = upperCaseLetters.indexOf(sChar);
			return upperCipherAlphabet.charAt(pos) + "";
		} else if (lowerCaseLetters.contains(sChar)) {
			int pos = lowerCaseLetters.indexOf(sChar);
			encrypted += lowerCipherAlphabet.charAt(pos);
		} else if (specialChars.contains(sChar)) {
			int pos = specialChars.indexOf(sChar);
			encrypted += numbers.charAt(pos);
		} else if (numbers.contains(sChar)) {
			int pos = numbers.indexOf(sChar);
			encrypted += specialChars.charAt(pos);
		} else if (sChar.equals(" ")) {
			encrypted = " ";
		} else {
			encrypted = sChar;

		}

		return encrypted;
	}

	/**
	 * Accepts a text and returns encrypted version. Take each character and covert
	 * to corresponding character by index upperCaseLetters -> upperCipherAlphabet
	 * lowerCaseLetters -> lowerCipherAlphabet specialChars -> numbers numbers ->
	 * specialChars
	 * 
	 * 
	 * @param password
	 * @return
	 * 
	 */

	public String decryptChar(String sChar) {
		String decrypt = "";

		if (upperCipherAlphabet.contains(sChar)) {
			int position = upperCipherAlphabet.indexOf(sChar);

			decrypt = upperCaseLetters.charAt(position) + "";

		} else if (lowerCipherAlphabet.contains(sChar)) {
			int position = lowerCipherAlphabet.indexOf(sChar);

			decrypt = lowerCaseLetters.charAt(position) + "";

		} else if (numbers.contains(sChar)) {
			int position = numbers.indexOf(sChar);

			decrypt = specialChars.charAt(position) + "";

		} else if (specialChars.contains(sChar)) {
			int position = specialChars.indexOf(sChar);

			decrypt = numbers.charAt(position) + "";
		} else if (sChar.equals(" ")) {

			decrypt = "";
		} else {
			return decrypt;
		}
		return decrypt;
	}

	public String encryptText(String text) {
		String encrypted = "";
		for (int i = 0; i < text.length(); i++) {
			String sinlgeCh = text.charAt(i) + "";
			encryptChar(sinlgeCh);
			encrypted += encryptChar(sinlgeCh);
		}

		return encrypted;
	}
	/**
	 * Accepts a text and returns decrypted version. Take each character and covert
	 * to corresponding character by index upperCipherAlphabet -> upperCaseLetters
	 * lowerCipherAlphabet -> lowerCaseLetters numbers -> specialChars specialChars
	 * -> numbers
	 * 
	 * 
	 * @param encryptedText
	 *            - characters to decrypt
	 * @return
	 */
	public String decryptText(String encryptedText) {
		String deccrypted = "";

		for (int i = 0; i < encryptedText.length(); i++) {
			String sinlgeCh = encryptedText.charAt(i) + "";
			decryptChar(sinlgeCh);
			deccrypted += decryptChar(sinlgeCh);
		}
			return deccrypted;
		

	
	}
}
