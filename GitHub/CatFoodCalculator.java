public class CatFoodCalculator{
public static void main (String[] args){
byte days = 7;

short cats = 3;

double dryFood = 0.12;

double wetFood = 0.19;



double totalDryFood = days*dryFood*cats;

double totalWetFood = days*wetFood*cats;

 System.out.println(totalDryFood);

System.out.println(totalWetFood);

}

}