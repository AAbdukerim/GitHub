package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import words.Words;

public class PublicTests {

	Words w; 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		w = new Words();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaddWordsToArray1() {
		w.addWordsToArray("common_names.txt");
		String result = w.getWord(4);
		String expected = "william";
		assertEquals(expected,result);
	}

	@Test
	public void testaddWordsToArray2() {
		w.addWordsToArray("names.txt");
		String result = w.getWord(2);
		String expected = "akbar";
		assertEquals(expected,result);
	}
	
	
	@Test
	public void testContains1() {
		w.addWordsToArray("names.txt");
		boolean result = w.contains("akbar");
		assertTrue(result);
	}
	
	
	@Test
	public void testContains2() {
		w.addWordsToArray("names.txt");
		boolean result = w.contains("administration");
		assertFalse(result);
	}
	
	
	@Test
	public void testContains3() {
		w.addWordsToArray("1000words.txt");
		boolean result = w.contains("administration");
		assertTrue(result);
	}
	
	
	@Test
	public void testContainsSentence1() {
		w.addWordsToArray("1000words.txt");
		boolean result = w.containsSentence("i buy book");
		assertTrue(result);
	}
	
	@Test
	public void testContainsSentence2() {
		w.addWordsToArray("1000words.txt");
		boolean result = w.containsSentence("i love you");
		assertTrue(result);
	}
	
	@Test
	public void testContainsSentence3() {
		w.addWordsToArray("1000words.txt");
		boolean result = w.containsSentence("she loves me");
		assertFalse(result);
	}
	
	
	@Test
	public void testReverseSentence1() {
		String result = w.reverseSentence("i love you");
		String expected = "you love i";
		assertEquals(expected, result);
	}
	
	@Test
	public void testReverseSentence2() {
		String result = w.reverseSentence("maria");
		String expected = "maria";
		assertEquals(expected, result);
	}
	
	@Test
	public void testReverseSentence3() {
		String result = w.reverseSentence("cybertek school");
		String expected = "school cybertek";
		assertEquals(expected, result);
	}
	
	
	@Test
	public void testCount1() {
		w.addWordsToArray("test1.txt");
		int result = w.count("abcd");
		int expected = 2;
		assertEquals(expected,result);
	}
	
	@Test
	public void testCount2() {
		w.addWordsToArray("test1.txt");
		int result = w.count("bbcc");
		int expected = 1;
		assertEquals(expected,result);
	}
	
	@Test
	public void testCount3() {
		w.addWordsToArray("names.txt");
		int result = w.count("trump");
		int expected = 0;
		assertEquals(expected,result);
	}
	
	
	@Test
	public void testAnagram1() {
		boolean result = w.anagram("abcd", "bcda");
		assertTrue(result);
	}
	@Test
	public void testAnagram2() {
		boolean result = w.anagram("bbd", "ddb");
		assertTrue(result);
	}
	
	@Test
	public void testAnagram3() {
		boolean result = w.anagram("abcd", "aadb");
		assertFalse(result);
	}
	
	
	@Test
	public void testFindAnagram1() throws Exception, Throwable{
		runProgramWithInput("abcd", "test1.txt");
	}
	
	
	@Test
	public void testFindAnagram2() throws Exception, Throwable{
		runProgramWithInput("save", "1000words.txt");
	}
	

	
	/**
	 * Executes a run of the OrdersProcessor program by reading the data
	 * in the specified file using input redirection.  The file inputFileName
	 * has the item's data file, whether multiple threads will be used,
	 * number of orders, base file name for the orders, and the 
	 * result file name.
	 * 
	 * @param inputFilename
	 * @throws Exception
	 * @throws Throwable
	 */
	private void runProgramWithInput(String word, String inputFilename) throws Exception, Throwable {
		
		/* Retrieving the name of the results file */
		
		String filename="";
		int i = inputFilename.lastIndexOf('.');
		if (i > 0) {
		    filename = inputFilename.substring(0,i);
		}
		
		String resultsFilename = filename + "_out.txt";
		String officialResultsFilename = filename + "_expected.txt";
		
		/* Deleting results file (in case it exists) */
		File file = new File(resultsFilename);
		file.delete();

		/* Actual execution of the test by using input redirection and calling 
		/* OrdersProcessor.main(null) */
		TestingSupport.redirectStandardInputTo(inputFilename);
		ByteArrayOutputStream b = TestingSupport.redirectStandardOutputToByteArrayStream();
		
		w.findAnagram(word, inputFilename);
		
		String output = b.toString();
		TestingSupport.writeToFile(resultsFilename, output);
		
		/* Checking if we got the right results */
		assertTrue(TestingSupport.sameContents(resultsFilename, officialResultsFilename));
	}
	
	
}
