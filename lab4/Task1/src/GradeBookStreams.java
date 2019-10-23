import java.io.*;
import java.util.StringTokenizer;
import gradeBook.*;
import student.Student;

public class GradeBookStreams {

	public static void main(String[] args) throws IOException{
		Gradebook gb = new Gradebook();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("src\\scores.txt"));
		} catch (FileNotFoundException e) {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
			pw.println("File scores.txt does not exist!");
			pw.close();
			return;
		}
		String line = br.readLine();
		while(line != null)
		{
			String[] gradeStudent = line.split("-");
			String name = gradeStudent[0];
			double grade = Double.parseDouble(gradeStudent[1]);
			gb.add(name, grade);			
			line = br.readLine();
		}
		br.close();
		BufferedWriter bw;
		try
		{
			bw = new BufferedWriter(new FileWriter("src\\grades.txt", true));			
		}
		catch(IOException e)
		{
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
			pw.println("File grades.txt does not exist!");
			pw.close();
			return;
		}
		bw.write(gb.getNewMarks());
		bw.close();
	}
}
