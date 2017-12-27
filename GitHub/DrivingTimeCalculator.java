
import java.until.Scanner;

public class DrivingTimeCalculator{
	public static void main(String[] args){
	Scanner Keyboard=new Scanner(System.in);
	System.out.println("-Input number of miles:");
	float miles=keyboard.nextFloat();

	System.out.println("-Input speed in MPH:");
	float speed=keyboard.nextFloat();

	float time=miles/speedf;
	float minutes=miles/speed*60f;

	System.out.println("Total time to reach your destination is :"+time);
	System.out.println("Total minutes to reach your destination is :" + minutes);

	}
}

	
