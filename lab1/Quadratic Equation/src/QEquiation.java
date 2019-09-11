import java.util.Scanner;

public class QEquiation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("a, b, c: ");
		double a = input.nextDouble();
		double b = input.nextDouble(); //Get values
		double c = input.nextDouble();
		input.close();
		double d = (b*b) - (4*a*c); // define discriminant
		double antiB = b * -1; //define antiB for ease of understanding formulas and for not to count it twice
		if(d < 0) 
			System.out.println("No solution");
		else if(d == 0)
			System.out.println(antiB / (2 * a));
		else {
			double rootOfD = Math.sqrt(d); // define square root of d to not count it twice
			System.out.println((antiB + rootOfD)/(2*a));
			System.out.println((antiB - rootOfD)/(2*a));
		}
	}

}
