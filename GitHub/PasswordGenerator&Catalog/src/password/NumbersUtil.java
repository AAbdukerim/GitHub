package password;

import java.util.Random;

public class NumbersUtil {
	
	Random random = new Random();
	/*
	 * create a method getInt that return any random int
	 * 
	 * 
	 */
	public void printInt(){
		System.out.println(random.nextInt());
	}
	
	public int getInt(){
		return random.nextInt();
	}
	
	
	public void printRandomInt(int upper){
		if(upper <= 0){
			System.out.println("Invalid argument");
			return;
		}
	//	Random random = new Random();
		//random number between 0 - value of upper
		System.out.println(random.nextInt(upper));
	}
	
	public int getRandomInt(int upper){
		if(upper <= 0){
			System.out.println("Fatal Error: Invalid argument upper <= 0");
			System.exit(0);
		}
	
		//random number between 0 - value of upper
		return random.nextInt(upper);
	}
	
	public void printRandomIntRange(int lower,int upper){
		
		if (lower >= upper){
			System.out.println("Invalid range lower >= upper");
			return;
		}
		
		int rNum = random.nextInt(upper);

		while(rNum < lower){
			rNum = random.nextInt(upper);
		}
		System.out.println(rNum);
	}
	
	public boolean isPrime(int num) {
		if (num <= 1){
			return false;
		}else if (num % 2 == 0 && num != 2){
			return false;
		}else {
			for(int n = 2; n < num/2; n++){
				if (num % n == 0){
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public int getMax(int num1, int num2, int num3){
		//55, 10, 56
		if (num1 > num2 && num1 > num3) {
			return num1;
		}else if (num2 > num3){
			return num2;
		}
		return num3;
	}
	
	public int countPrimes(int upper) {
		int counter = 0;
		for (int j = 0; j <= upper; j++) {
			if ( isPrime(j) ) {
				counter++;
			}
		}
		
		return counter;
	}
	
	public int[] getPrimeNumbersRange(int upper) {
		  	//find out how many prime number within range
		   int countP = countPrimes(upper);
		   
		   int[] primes = new int[countP];
		  	//loop through each number and assign prime ones to array
		   int index = 0;
		   for (int num = 0; num <= upper; num++) {
				if ( isPrime(num) ) {
					primes[index] = num;
					index++;
				}
			}
		   
		  	return primes;
		 
	}
	
	
}






