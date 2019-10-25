package CourseConstructor;

import java.io.*;
import java.util.ArrayList;
public class CourseConstructor {
	private BufferedReader in;//Для ввода данных. 
	//Используем BufferedReader, чтобы не по одному символу считывать, а сразу целую строку
	private PrintWriter out;//для вывода
	//Используем PrintWriter, чтобы на выводе были человекочитаемые) слова, а не машинный код
	private ArrayList<Course> courses;
	private ArrayList<Textbook> textbooks;
	private ArrayList<Instructor> instructors;
	
	{
		try//Попытка десериализовать, листы с предыдущих сессий
		{
			ObjectInputStream txtbks = new ObjectInputStream(new FileInputStream("src\\resources\\textbooks.out"));
			ObjectInputStream insts = new ObjectInputStream(new FileInputStream("src\\resources\\instructors.out"));
			ObjectInputStream crss = new ObjectInputStream(new FileInputStream("src\\resources\\courses.out"));
			//Для ДЕсериализации нам нужны *OBJECT*InputStream, чтобы считывать *ОБЪЕКТЫ*
			textbooks = (ArrayList<Textbook>)txtbks.readObject();
			instructors = (ArrayList<Instructor>)insts.readObject();
			courses = (ArrayList<Course>)crss.readObject();
			//Считываем все объекты
			txtbks.close();
			insts.close();
			crss.close();
			//Не забываем закрывать потоки!!!
		}
		catch(Exception e)//Если не получилось, то создаем новые
		{
			courses = new ArrayList<Course>();
			textbooks = new ArrayList<Textbook>();
			instructors = new ArrayList<Instructor>();
		}
	}
	
	public CourseConstructor()//По умолчанию ввод и вывод из консоли, но не через Сканнер. Сканер - плохо
	{		
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out, true);
		//Параметр true для того, чтобы автоматически использовалась функция flush()
		//Эта функция нужна, чтобы сразу сделать вывод, без нее выйдет только перед закрытием потока
		//out.close(); Вот тогда
		//Она используется автоматически только при println();
		//При print() flush() нужно писать самому(
	}
	
	public CourseConstructor(BufferedReader in, PrintWriter out)
	{//Можно сделать свой ввод и вывод, но я не пользовался этим
		this.in = in;
		this.out = out;
	}
	
	
	public void run() throws IOException
	{//Я сделал throws *exception* во многих функциях, чтобы не прописывать try/catch
		//При считывании или других потенциально опасных методах!
		//Примеры таких будут дальше
		out.println("Welcome to Course App by Jiklopo corp.!");
		String choice;
		out.println("Type:\n"
				+ "1 to enter as a guest\n"
				+ "2 to enter as an admin.");
		choice = in.readLine();
		if(choice.equals("1"))
			userMode();
		else if(choice.equals("2"))
		{
			out.print("Login:");
			out.flush();
			String username = in.readLine();
			out.print("Password:");
			out.flush();
			String password = in.readLine();
			if(checkLogin(username, password))
				adminMode(username);
			else 
				out.println("Wrong username or password!");
		}
		out.println("Goodbye!");
		out.close();
		in.close();
		//Всегда закрывайте потоки за собой.
	}
	
	private void userMode() throws IOException
	{
		String greeting = "\nType:\n"
				+ "1 to list all Textbooks\n"
				+ "2 to list all Instructors\n"
				+ "3 to list all Courses\n"
				+ "0 to quit";
		String choice = "a";
		while(!choice.equals("0"))
		{
			out.println(greeting);
			choice = in.readLine();
			if(choice.equals("1"))
				listObjects(textbooks.toArray());
			else if(choice.equals("2"))
				listObjects(instructors.toArray());
			else if(choice.equals("3"))
				listObjects(courses.toArray());
		}
	}
	
	private void adminMode (String username) throws IOException
	{
		out.println("Welcome, " + username);
		String greeting = "\nType:\n"
				+ "1 to add Textbook\n"
				+ "2 to add Instructor\n"
				+ "3 to add a Course\n"
				+ "4 to list all Textbooks\n"
				+ "5 to list all Instructors\n"
				+ "6 to list all Courses\n"
				+ "7 to delete a Textbook\n"
				+ "8 to delete an Insturctor\n"
				+ "9 to delete a Course\n"
				+ "0 to quit";
		
		String choice = "a";
		while(!choice.equals("0"))
		{
			out.println(greeting);
			choice = in.readLine();
			String logs = java.time.LocalDateTime.now() + " " + username + " ";
			if(choice.equals("1"))
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
				logs += "added instructor " + inst;
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
				out.flush();
				String courseName = in.readLine();
				out.println("Choose a textbook for the course");
				listObjects(instructors.toArray());
				int instChoice = Integer.parseInt(in.readLine());
				out.println("Choose an instructor for the course");
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
			
			else if(choice.equals("7"))
			{
				if(!textbooks.isEmpty())
					logs += deleteSmthn(textbooks.toArray(), "Textbook");
				else
					logs += "tried to delete a Textbook";
			}
			
			else if(choice.equals("8"))
			{
				if(!instructors.isEmpty())
					logs += deleteSmthn(instructors.toArray(), "Instructor");
				else
					logs += "tried to delete an Instructor";
			}
			
			else if(choice.equals("9"))
			{
				if(!courses.isEmpty())
					logs += deleteSmthn(courses.toArray(), "Course");
				else
					logs += "tried to delete a Course";
			}
			
			try {writeLogs(logs);}
			catch(IOException e) {out.println("File logs.txt damaged or does not exist");}
		}
		
		deserialize();
	}
	
	private void writeLogs(String logs) throws IOException//Здесь мы записываем логи
	{
		BufferedWriter logWriter = new BufferedWriter(new FileWriter("src\\resources\\logs.txt", true));
		logWriter.write(logs + "\n");
		logWriter.close();
	}
	
	private String deleteSmthn(Object[] list, String cls) throws NumberFormatException, IOException
	{//Это, чтобы удалить что-нибудь откуда-нибудь
		out.println("Choose a %s to delete:".format(cls));
		listObjects(list);
		int indexChoice = Integer.parseInt(in.readLine());
		//Здесь может быть NumberFormatException, если попытаемся НЕ число запихать
		String logs = "deleted " + textbooks.get(indexChoice);
		textbooks.remove(indexChoice);
		return logs;
	}
	
	private void listObjects(Object[] list)//Это, чтобы вывести все из массива чего угодно
	{
		String line = "%x. %s";
		//%x заменятеся на интегер, %s - на строку
		for(int i = 0; i < list.length; i++)
		{
			out.println(line.format(line, i, list[i].toString()));
		}
	}
	
	private void deserialize() throws FileNotFoundException, IOException
	{
		ObjectOutputStream txtbks = new ObjectOutputStream(new FileOutputStream("src\\resources\\textbooks.out", false));
		ObjectOutputStream insts = new ObjectOutputStream(new FileOutputStream("src\\resources\\instructors.out", false));
		ObjectOutputStream crss = new ObjectOutputStream(new FileOutputStream("src\\resources\\courses.out", false));
		//Сериализация и десериализация похожи, только вместо input - output.
		txtbks.writeObject(textbooks);
		insts.writeObject(instructors);
		crss.writeObject(courses);
		//Записываем все листы
		txtbks.close();
		insts.close();
		crss.close();
		//Не забываем закрыть потоки, а то ничего не сохранится
	}
	
	private boolean checkLogin(String username, String password) throws FileNotFoundException, IOException
	{
		BufferedReader pass = new BufferedReader(new FileReader("src\\CourseConstructor\\admin.txt"));
		String login = pass.readLine();
		int hashPassword = Integer.parseInt(pass.readLine());
		return login.equals(username) && hashPassword == password.hashCode();
	}
}
