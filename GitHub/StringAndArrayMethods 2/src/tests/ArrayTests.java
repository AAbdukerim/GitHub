package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import arrays.ArraysManipulation;

public class ArrayTests {
	ArraysManipulation arraysManipulation = new ArraysManipulation();;
	
	@Test
	public void testArray1() {
		int[] array= {1,2,3,4,5,6,7,8,9,10};
		int expected = 25;
		int result = arraysManipulation.sumOfOdds(array);		
		assertEquals(result,expected);
	}
	
	
	@Test
	public void testArray2() {
		int[] array= {2,3,4,5};
		int expected = 8;
		int result = arraysManipulation.sumOfOdds(array);		
		assertEquals(result,expected);
	}
	
	
	@Test
	public void testArray3() {
		int[] array= {-5,2,4,8,10,5};
		int expected = 0;
		int result = arraysManipulation.sumOfOdds(array);		
		assertEquals(result,expected);
	}
	
	
	@Test
	public void testThreeAmigos1(){
		int[] arr = {1,3,5,4,6};
		assertTrue(arraysManipulation.threeAmigos(arr));
	}
	
	@Test
	public void testThreeAmigos2(){
		int[] arr = {100,333,500,4,6,1};
		assertTrue(arraysManipulation.threeAmigos(arr));
	}

	@Test
	public void testThreeAmigos3(){
		int[] arr = {100,333,500,41,6,1};
		assertFalse(arraysManipulation.threeAmigos(arr));
	}
	
	@Test
	public void dontLike4s1sTogetherTest1(){
		int[] arr = {1,2,3};
		assertTrue(arraysManipulation.dontLike4s1sTogether(arr));
	}
	
	@Test
	public void dontLike4s1sTogetherTest2(){
		int[] arr = {1,2,3,4,4};
		assertFalse(arraysManipulation.dontLike4s1sTogether(arr));
	}
	
	@Test
	public void dontLike4s1sTogetherTest3(){
		int[] arr = {4,2,3,4,4,4};
		assertTrue(arraysManipulation.dontLike4s1sTogether(arr));
	}
	
	@Test
	public void dontLike4s1sTogetherTest4(){
		int[] arr = {3,2,3,7,2,9};
		assertTrue(arraysManipulation.dontLike4s1sTogether(arr));
	}
	
	@Test
	public void contains12Test1(){
		int[] arr = {25,13,1,22};
		assertFalse(arraysManipulation.contains12(arr));
	}
	
	@Test
	public void contains12Test2(){
		int[] arr = {25,13,1,2};
		assertTrue(arraysManipulation.contains12(arr));
	}
	
	@Test
	public void contains12Test3(){
		int[] arr = {1,13,11,2};
		assertTrue(arraysManipulation.contains12(arr));
	}
	
	@Test
	public void contains12Test4(){
		int[] arr = {2,2,1,1};
		assertFalse(arraysManipulation.contains12(arr));
	}
	
	@Test
	public void contains12Test5(){
		int[] arr = {133,3,56,0};
		assertFalse(arraysManipulation.contains12(arr));
	}
	
	@Test
	public void make100With2Test1(){
		int [] array = {7, 7, 1, 1, 7};
	    assertFalse(arraysManipulation.make100With2(array));
	}
	
	@Test
	public void make100With2Test2(){
		int [] array = {100, 0, 1};;
	    assertTrue(arraysManipulation.make100With2(array));
	}
	
	@Test
	public void make100With2Test3(){
		int [] array = {12,34,88};
	    assertTrue(arraysManipulation.make100With2(array));
	}
	
	@Test
	public void make100With2Test4(){
		int [] array = {49, 50, 65, 23 ,1};
	    assertFalse(arraysManipulation.make100With2(array));
	}
	
	@Test
	public void make100With2Test5(){
		int [] array = {1};
	    assertFalse(arraysManipulation.make100With2(array));
	}
	
	@Test
	public void make100With2Test6(){
		int [] array = {100};
	    assertFalse(arraysManipulation.make100With2(array));
	}
	
}
