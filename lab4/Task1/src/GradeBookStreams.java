import java.io.*;
import java.util.StringTokenizer;
import gradeBook.*;
import student.Student;

public class GradeBookStreams {

	public static void main(String[] args) throws IOException {
		Gradebook gb = new Gradebook();
		FileReader in = new FileReader("P:\\Библиотеки\\Documents\\KBTU\\Java OOP\\lab4\\Task1\\src\\scores.txt");
		BufferedReader br = new BufferedReader(in);
		String line = br.readLine();
		while(line != null)
		{
			String[] gradeStudent = line.split("-");
			String name = gradeStudent[0];
			double grade = Double.parseDouble(gradeStudent[1]);
			gb.add(name, grade);			
			line = br.readLine();
		}
		in.close();
		br.close();
		BufferedWriter bw = new BufferedWriter(new FileWriter("P:\\Библиотеки\\Documents\\KBTU\\Java OOP\\lab4\\Task1\\src\\grades.txt"));
		bw.write(gb.getNewMarks());
		bw.write(gb.getReport());
		bw.close();
	}

}
