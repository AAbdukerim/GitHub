
public class people{
	public static void main(String[] args){
	Person p1=new Person();
	p1.name="Bob";
	p1.age=25;
	p1.gender='M';
	p1.job="SDET";

	System.out.println("My name is "+p1.name);
	System.out.println("I am "+p1.age+ " "+ p1.gender);
	System.out.println("I work as " +p1.job);
	}
}