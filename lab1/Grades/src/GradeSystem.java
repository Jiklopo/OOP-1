import java.util.Scanner;

public class GradeSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int grade = input.nextInt();
		input.close();
		String mark = null;
		if (grade >= 100) {
			mark = "Your number is too high!";//Grade cannot be more than 100
		}
		else if (grade >= 95) {//Probably not the best way to do it
			mark = "A";
		}
		else if (grade >= 90) {
			mark = "A-";
		}
		else if (grade >= 95) {
			mark = "B+";
		}
		else if (grade >= 80) {
			mark = "B";
		}
		else if (grade >= 85) {
			mark = "B-";
		}
		else if (grade >= 70) {
			mark = "C+";
		}
		else if (grade >= 75) {
			mark = "C";
		}
		else if (grade >= 60) {
			mark = "C-";
		}
		else if (grade >= 65) {
			mark = "D+";
		}
		else if (grade >= 50) {
			mark = "D";
		}
		else if (grade < 50){
			mark = "F";
		}
		else if (grade < 0) {
			mark = "Your number cannot be below zero!";//Grade cannot be negative!
		}
		System.out.println(mark);
	}

}
