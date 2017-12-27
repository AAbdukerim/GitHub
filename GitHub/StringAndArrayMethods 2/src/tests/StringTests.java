package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import arrays.ArraysManipulation;
import strings.StringManipulation;

public class StringTests {
	static StringManipulation stringManipulation;
	static ArraysManipulation arraysManipulation;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stringManipulation = new StringManipulation();
		arraysManipulation = new ArraysManipulation();
	}

	@Test
	public void testReverse() {
		String actual="Hello World";
		String result = stringManipulation.reverse(actual);
		StringBuilder t = new StringBuilder();
		t.append(actual);
		String s = t.reverse().toString();
		assertEquals(s, result);
	}

	
	@Test
	public void testReverse2() {
		String actual="H";
		String result = stringManipulation.reverse(actual);
		StringBuilder t = new StringBuilder();
		t.append(actual);
		String s = t.reverse().toString();
		assertEquals(s, result);
	}
	
	@Test
	public void testReverse3() {
		String actual="";
		String result = stringManipulation.reverse(actual);
		StringBuilder t = new StringBuilder();
		t.append(actual);
		String s = t.reverse().toString();
		assertEquals(s, result);
	}
	
	@Test
	public void testReverse4() {
		String actual="ab";
		String result = stringManipulation.reverse(actual);
		StringBuilder t = new StringBuilder();
		t.append(actual);
		String s = t.reverse().toString();
		assertEquals(s, result);
	}
	@Test
	public void testReverse5() {
		String actual="ab123";
		String result = stringManipulation.reverse(actual);
		StringBuilder t = new StringBuilder();
		t.append(actual);
		String s = t.reverse().toString();
		assertEquals(s, result);
	}
	@Test
	public void testPalindrome1() {
		String actual="aba";
		boolean result = stringManipulation.palindrome(actual);		
		assertTrue(result);
	}
	
	@Test
	public void testPalindrome2() {
		String actual="ab";
		boolean result = stringManipulation.palindrome(actual);		
		assertFalse(result);
	}
	
	@Test
	public void testPalindrome3() {
		String actual="a";
		boolean result = stringManipulation.palindrome(actual);		
		assertTrue(result);
	}
	
	@Test
	public void testPalindrome4() {
		String actual="aaaa";
		boolean result = stringManipulation.palindrome(actual);		
		assertTrue(result);
	}
	
	@Test
	public void testPalindrome5() {
		String actual="";
		boolean result = stringManipulation.palindrome(actual);		
		assertTrue(result);
	}
	
	@Test
	public void testPalindrome6() {
		String actual="cabac";
		boolean result = stringManipulation.palindrome(actual);		
		assertTrue(result);
	}
	
	@Test
	public void testPalindrome7() {
		String actual="1112111";
		boolean result = stringManipulation.palindrome(actual);		
		assertTrue(result);
	}
	
	
	
	
	@Test
	public void middleTwoCharsTest(){
		assertEquals("ri",stringManipulation.middleTwo("string"));
		assertEquals("od",stringManipulation.middleTwo("code"));
		assertEquals("45",stringManipulation.middleTwo("0123456789"));
	}
	
	@Test
	public void UniqueCharactersTest(){
		assertEquals("string",stringManipulation.uniqueChars("string"));
		assertEquals("jva",stringManipulation.uniqueChars("java"));
		assertEquals("123",stringManipulation.uniqueChars("112233"));
		assertEquals("a",stringManipulation.uniqueChars("a"));
	}
	
	@Test
	public void countCharsTest(){
		assertEquals(1,stringManipulation.countChars("string", 't'));
		assertEquals(3,stringManipulation.countChars("qwe@#$lk$$", '$'));
		assertEquals(3,stringManipulation.countChars("qwe@#$lk$$", '$'));
		assertEquals(2,stringManipulation.countChars("java", 'a'));
	}
	
	@Test
	public void addStringsTest(){
		assertEquals("stringjava",stringManipulation.addStrings("string", "java"));
		assertEquals("dogcat",stringManipulation.addStrings("dog", "cat"));
		assertEquals("abcat",stringManipulation.addStrings("abc", "cat"));
		assertEquals("sweetapple",stringManipulation.addStrings("sweet", "tapple"));
		assertEquals("cat",stringManipulation.addStrings("cat", ""));
	}
	
}
