import java.util.ArrayList;
import java.util.Scanner;

public class Main {//I occasionally made biquadratic equation >_<

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.print("Input a, b, c:");
		double a  = input.nextDouble();
		double b  = input.nextDouble();
		double c  = input.nextDouble();
		input.close();
		double d = (b*b) - (4*a*c);
		
		
		if(d < 0) {
			System.out.println("No solution");
		}
		
		
		else if(d == 0) {
			double root = -1*b / 2*a;
			if(root < 0) {
				System.out.println("No solution");
				return;
			}
			System.out.println(Math.sqrt(root) + ", " + (Math.sqrt(root) * -1));
		}
		
		
		else if(d > 0) {
			ArrayList<Double> roots = new ArrayList<Double>();
			double tmp = (-1*b + Math.sqrt(d))/ (2*a);
			
			if(tmp < 0) {
				System.out.println("No solutions");
				return;
			}
			
			roots.add(Math.sqrt(tmp));
			roots.add(Math.sqrt(tmp) * -1);
			tmp = (-1*b - Math.sqrt(d))/ (2*a);
			if(tmp > 0) {
				roots.add(Math.sqrt(tmp));
				roots.add(Math.sqrt(tmp) * -1);
			}
			
			System.out.print("Roots: ");
			for(double r: roots) {
				System.out.print(r + " ");
			}
		}
	}

}
