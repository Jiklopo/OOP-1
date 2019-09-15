import java.util.Scanner;

public class GradeBookTest {

	public static void main(String[] args) {
		Gradebook gb = new Gradebook(new Course("OOP"));
		Scanner input = new Scanner(System.in);
		String student;
		double grade;
		System.out.println(gb.displayMessage());
		while(true) {
			System.out.print("Student name: ");
			student = input.nextLine();
			System.out.println(student);
			if (student.equals("stop"))
				break;
			System.out.print("Grade: ");
			grade = input.nextDouble();
			System.out.println(grade);
			gb.addGradeInfo(student, grade);
			input.nextLine();
		}
		input.close();
		System.out.println(gb.getReport());
	}

}
