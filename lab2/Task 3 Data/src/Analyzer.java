import java.util.Scanner;

public class Analyzer {

	public static void main(String[] args) {
		Data data = new Data();
		String s = null;
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.print("Enter number(Q to quit): ");
			s = input.next();
			if (s.equals("Q"))
				break;
			data.add(Double.parseDouble(s));			
		}
		input.close();
		System.out.println("Average: " + data.getAvg());
		System.out.println("Max: " + data.getMax());
		
	}

}
