import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Length: ");
		double a = input.nextDouble();
		input.close();
		Square square = new Square(a);
		System.out.println("Area: " + square.Area());
		System.out.println("Perimeter: " + square.Perimeter());
		System.out.println("Diagonal: " + square.Diagonal());
		
	}

}
