package skynet;

import users.*;
import java.io.*;
import java.util.*;

import universityStuff.*;

/**
 * 
 * @author Jiklopo
 * This class extends Skynet. Purpose of all inherited methods are the same.
 */
public class SkynetConsole extends Skynet{
	/**
	 * This is required to get data from console
	 */
	private static Scanner in = new Scanner(System.in);
	
	/**
	 * This is needed to make output to console
	 */
	private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private String serializationPath;
	
	public SkynetConsole() {}
	
	public SkynetConsole(String serializationPath)
	{
		super(serializationPath);
	}
	
	
	/**
	 * This method starts session when user opens application
	 * @throws IOException
	 */
	public void startSession() throws IOException
	{
		int choice = -1;
		String[] choices = new String[] {"Login", "Exit"};
		deserializeAll();
		while(choice != choices.length)
		{
			out.write(listVariants(choices));
			out.flush();
			choice = in.nextInt();			
			System.out.println(choice);
			if(choice == 1)
			{
				userLogin();
			}
			serializeAll();
		}
		
	}

	@Override
	public void userLogin() throws IOException 
	{
		String loginMessage = "Enter login and then password on separate lines. Enter 0 to the login field to exit.\n";
		String login = "";
		while(true)
		{
			out.write(loginMessage);
			out.flush();
			login = in.next();
			if(login.equals("0"))
				break;
			String password = in.next();
			
			User user = User.getUserByLogin(login);
			System.out.println(User.getAllUsers().toString());
			if(User.checkLogin(user, password))
			{
				writeLogs(user + " logged in");
				if(user instanceof Admin)
				{
					adminLogin((Admin)user);
				}
				else if(user instanceof Student)
				{
					studentLogin((Student)user);
				}
				else if(user instanceof Teacher)
				{
					teacherLogin((Teacher)user);
				}
				else if(user instanceof Manager)
				{
					managerLogin((Manager)user);
				}
				else if(user instanceof TechGuy)
				{
					techGuyLogin((TechGuy)user);
				}
				break;
			}
		}
		
	}

	@Override
	protected void studentLogin(Student student) throws IOException 
	{
		int choice = -1;
		String[] choices = new String[] {"View transcript",
				"View Attendance Journal",
				"View Timetable",
				"Exit"};
		while (choice != choices.length)
		{
			out.write(listVariants(choices));
			out.flush();
			choice = in.nextInt();
			if(choice == 1)
			{
				out.write(student.getTranscript().toString());
			}
			else if(choice == 2)
			{
				for(Subject s: student.getJournal().keySet())
				{
					out.write(student.getJournal().get(s) + "\n");
				}
			}
			else if(choice == 3)
			{
				out.write(student.getTimeTable().toString());
			}
			out.flush();
		}
	}

	@Override
	protected void teacherLogin(Teacher teacher) throws IOException {
		int choice = -1;
		String[] choices = new String[] {"View Students' Information",
				"Put Mark",
				"",
				"Exit"};
		while (choice != choices.length)
		{
			out.write(listVariants(choices));
			out.flush();
			choice = in.nextInt();
			if(choice == 1)
			{
				
			}
		}
	}

	@Override
	protected void managerLogin(Manager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void adminLogin(Admin admin) throws IOException {
		int choice = -1;
		String[] choices = new String[] {"Create user",
				"Change User",
				"Exit"};
		while (choice != choices.length)
		{
			out.write(listVariants(choices));
			out.flush();
			choice = in.nextInt();
			if(choice == 1)
			{
				out.write("Enter user type, password, first name, last name, phoneNumber\n");
				String type, password, name1, name2, number;
				out.write("User type: ");
				out.flush();
				type = in.next();
				out.write("Password: ");
				out.flush();
				password = in.next();
				out.write("First name: ");
				out.flush();
				name1 = in.next();
				out.write("Last name: ");
				out.flush();
				name2 = in.next();
				out.write("Phone number: ");
				out.flush();
				number = in.next();
				admin.createUser(type, password, name1, name2, number);
				writeLogs(admin + " created a user ");
				serializeAll();
			}
			else if(choice == 2)
			{
				out.write("Select user to change\n");
				{
					User user = (User)makeChoice(User.getAllUsers().keySet().toArray());
					out.write("What do you want to change?"
							+ "FirstName/LastName/PhoneNumber?\n"
							+ "Write in one word!\n");
					out.flush();
					String whatToChange = in.next();
					String newString = in.next();
					String logs = "Admin " + admin + " changed user's " + user + " " + whatToChange + " to " + newString;
					if(whatToChange.equalsIgnoreCase("first name"))
					{
						admin.changeUserFirstName(user, newString);
						writeLogs(logs);
					}
					else if(whatToChange.equalsIgnoreCase("last name"))
					{
						admin.changeUserLastName(user, newString);
						writeLogs(logs);
					}
					else if(whatToChange.equalsIgnoreCase("phone number"))
					{
						admin.changeUserNumber(user, newString);
						writeLogs(logs);
					}
					else
					{
						out.write("No such field: " + whatToChange + "\n");
					}						
					serializeAll();
				}
			}
		}
		
	}
	
	@Override
	protected void techGuyLogin(TechGuy techGuy) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * This method tries to write logs to text file.
	 * If it get exception it writes logs to the console.
	 */
	@Override
	protected void writeLogs(String logs)
	{		
		logs = java.time.LocalDateTime.now() + " " + logs;
		try {
			BufferedWriter logWriter = new BufferedWriter(new FileWriter("src\\resources\\logs.txt", true));
			logWriter.write(logs + "\n");
			logWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(logs);
		}
	}
	
	/**
	 * This method creates beautiful string for all strings in array
	 * and put numbers near them.
	 * @param variants
	 * @return
	 */
	private String listVariants(String[] variants)
	{
		String res = "";
		for(int i = 0; i < variants.length; i++)
		{
			res += (i + 1) + ". " + variants[i] + "\n";
		}
		return res;
	}
	/**
	 * This method takes list of objects and requires you to input number.
	 * @param objects
	 * @return Value of Object in array with index that you inputted
	 * @throws IOException
	 */
	private Object makeChoice(Object[] objects) throws IOException
	{
		String[] strings = new String[objects.length];
		for(int i = 0; i < objects.length; i++)
		{
			strings[i] = objects[i].toString();
		}
		out.write(listVariants(strings));
		out.flush();
		int choice = in.nextInt();
		return objects[choice - 1];	
	}
}

