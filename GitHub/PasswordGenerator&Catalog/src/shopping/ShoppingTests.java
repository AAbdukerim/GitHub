package shopping;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;
import org.junit.Test;



public class ShoppingTests {
	Catalog ctl = new Catalog();
	@Test
	public void getWholeCatalogTest() throws IOException {
		String expected = fileData("catalog.txt");
		assertEquals(expected , ctl.getWholeCatalog().toString().trim());
	}
	
	@Test
	public void getItemDetailsTest1() throws IOException {
		assertEquals(null, ctl.getItemDetails("Table"));
	}
	
	@Test
	public void getItemDetailsTest2() throws IOException {
		assertEquals("MacbookPro-1499.99-79.49", ctl.getItemDetails("MacbookPro"));
	}
	
	@Test
	public void getItemDetailsTest3() throws IOException {
		assertEquals("Apple Watch-559.0-21.18", ctl.getItemDetails("Apple Watch"));
	}
	
	@Test
	public void getItemsLessThanAMonthlyPriceTest1(){
		StringBuilder stb = new StringBuilder();
		stb.append("ThumbDrive-39.99-2.68\n")
		   .append("Mouse-79.99-8.98\n")
		   .append("Charger-39.99-4.56\n");
		assertEquals(stb.toString(),ctl.getItemsLessThanAMonthlyPrice(14.99).toString());
	}
	
	@Test
	public void getItemsLessThanAMonthlyPriceTest2(){
		StringBuilder stb = new StringBuilder();
		stb.append("iPhone 6s-449.0-18.71\n")
		   .append("iPhone 6s Plus-549.0-22.88\n")
		   .append("ThumbDrive-39.99-2.68\n")
		   .append("Beats HeadPhones-349.99-15.12\n")
		   .append("Mouse-79.99-8.98\n")
		   .append("Charger-39.99-4.56\n")
		   .append("iPad-429.0-18.31\n")
		   .append("Dyson Vacuum-399.0-16.25\n")
		   .append("Apple Watch-559.0-21.18\n");
		assertEquals(stb.toString(),ctl.getItemsLessThanAMonthlyPrice(23.99).toString());
	}
	
	@Test
	public void getItemsLessThanAMonthlyPriceTest3(){
		assertEquals("",ctl.getItemsLessThanAMonthlyPrice(1.99).toString());
	}
	
	private String fileData(String fileName) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		Scanner fileScanner = new Scanner(bufferedReader);

		while (fileScanner.hasNextLine()) { 
			stringBuffer.append(fileScanner.nextLine()+"\n");
		}
		
		fileScanner.close();

		return stringBuffer.toString().trim();
    }
	
}
