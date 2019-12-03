package skynet;

import users.*;
import java.io.*;
import java.util.*;

import universityStuff.*;

/**
 * 
 * @author Jiklopo
 *
 */
public class SkynetConsole extends Skynet{
	
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	private String serializationPath;
	
	public SkynetConsole() {}
	
	public SkynetConsole(String serializationPath)
	{
		super(serializationPath);
	}
	
	
	public void startSession() throws IOException
	{
		int choice = -1;
		String[] choices = new String[] {"Login", "Exit"};
		deserializeAll();
		while(choice != choices.length)
		{
			out.write(listVariants(choices));
			out.flush();
			choice = in.read();
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
		String loginMessage = "Enter login and then password on separate lines. Enter 0 to the login field to exit.";
		String login = "";
		while(!login.equalsIgnoreCase("0"))
		{
			out.write(loginMessage);
			out.flush();
			login = in.readLine();
			String password = in.readLine();
			User user = User.getUserByLogin(login);
			if(User.checkLogin(user, password))
			{
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
			choice = in.read();
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
			choice = in.read();
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
	protected void adminLogin(Admin admin) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void techGuyLogin(TechGuy techGuy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeLogs(String logs)
	{		
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
	
	private String listVariants(String[] variants)
	{
		String res = "";
		for(int i = 0; i < variants.length; i++)
		{
			res += (i + 1) + variants[i] + "\n";
		}
		return res;
	}

	public String getSerializationPath() {
		return serializationPath;
	}

	public void setSerializationPath(String serializationPath) {
		this.serializationPath = serializationPath;
	}

	
}

