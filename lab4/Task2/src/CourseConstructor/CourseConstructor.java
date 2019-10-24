package CourseConstructor;

import java.io.*;
import java.util.ArrayList;
public class CourseConstructor {
	private BufferedReader in;
	private PrintWriter out;
	private ArrayList<Course> courses;
	private ArrayList<Textbook> textbooks;
	private ArrayList<Instructor> instructors;
	
	{
		courses = new ArrayList<Course>();
		textbooks = new ArrayList<Textbook>();
		instructors = new ArrayList<Instructor>();
	}
	
	public CourseConstructor()
	{		
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out, true);
	}
	
	public CourseConstructor(BufferedReader in, PrintWriter out)
	{
		this.in = in;
		this.out = out;
	}
	
	
	public void run()
	{
		try {
			adminLogin("Vasek");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void adminLogin (String username) throws IOException
	{
		String choice = "a";
		out.println("Welcome, " + username);
		
		String greeting = "Type:\n"
				+ "1 to add Textbook\n"
				+ "2 to add Instructor\n"
				+ "3 to add a Course\n"
				+ "4 to list all Textbooks\n"
				+ "5 to list all Instructors\n"
				+ "6 to list all Courses\n"
				+ "0 to quit";
		
		while(choice != null)
		{
			out.println(greeting);
			choice = in.readLine();
			String logs = java.time.LocalDateTime.now() + " " + username + " ";
			if(choice.equals("0"))
				break;
			else if(choice.equals("1"))
			{
				out.println("Enter isbn, title and author on separate lines");
				String isbn = in.readLine();
				String title = in.readLine();
				String author = in.readLine();
				Textbook txtbk = new Textbook(isbn, title, author);
				textbooks.add(txtbk);
				logs += "added textbook " + txtbk;
			}
			
			else if (choice.equals("2"))
			{
				out.println("Enter first name, last name, deparment and email on separate lines!");
				String firstName = in.readLine();
				String lastName = in.readLine();
				String department = in.readLine();
				String email = in.readLine();
				Instructor inst = new Instructor(firstName, lastName, department, email);
				instructors.add(inst);
				logs += "added instructor" + inst;
			}
			
			else if(choice.equals("3"))
			{
				if(textbooks.isEmpty())
				{
					out.println("Add a textbook first!");
					logs += "tried to add a course, but no textbooks available!";
					continue;
				}
				if(instructors.isEmpty())
				{
					out.println("Add an instructor first!");
					logs += "tried to add a course, but no instructors available!";
					continue;
				}
				
				out.print("Enter course name: ");
				String courseName = in.readLine();
				listObjects(instructors.toArray());
				int instChoice = Integer.parseInt(in.readLine());
				listObjects(textbooks.toArray());
				int txtbkChoice = Integer.parseInt(in.readLine());
				Course course = new Course(courseName, textbooks.get(txtbkChoice), instructors.get(instChoice));
				courses.add(course);
				logs += "added course " + course;
			}
			
			else if(choice.equals("4"))
			{
				listObjects(textbooks.toArray());
				logs += "checked textbooks.";
			}
			
			else if(choice.equals("5"))
			{
				listObjects(instructors.toArray());
				logs += "checked instructors.";
			}
			
			else if(choice.equals("6"))
			{
				listObjects(courses.toArray());
				logs += "checked courses.";
			}
			
			try {writeLogs(logs);}
			catch(IOException e) {out.println("File logs.txt damaged or does not exist");}
		}
		
		finish();
	}
	
	private void writeLogs(String logs) throws IOException
	{
		BufferedWriter logWriter = new BufferedWriter(new FileWriter("src\\resources\\logs.txt", true));
		logWriter.write(logs + "\n");
		logWriter.close();
	}
	
	private void listObjects(Object[] list)
	{
		String line = "%x. %s";
		for(int i = 0; i < list.length; i++)
		{
			out.println(line.format(line, i, list[i].toString()));
		}
	}
	
	private void finish() throws FileNotFoundException, IOException
	{
		ObjectOutputStream txtbks = new ObjectOutputStream(new FileOutputStream("src\\resources\\textbooks.out", false));
		ObjectOutputStream insts = new ObjectOutputStream(new FileOutputStream("src\\resources\\instructors.out", false));
		ObjectOutputStream courses = new ObjectOutputStream(new FileOutputStream("src\\resources\\courses.out", false));
		txtbks.writeObject(textbooks);
		insts.writeObject(instructors);
		courses.writeObject(courses);
		//serialize all arraylists
	}
}
