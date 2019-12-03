package skynet;

import users.*;
import java.io.*;
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
		setSerializationPath(serializationPath);;
	}
	
	
	
	
	public void startSession() throws IOException
	{
		int choice = -1;
		String[] choices = new String[] {"Login", "Exit"};
		while(choice != choices.length - 1)
		{
			out.write(listVariants(choices));
			choice = in.read();
			if(choice == 1)
			{
				userLogin();
			}
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
			login = in.readLine();
			String password = in.readLine();
			User user = User.getUserByLogin(login);
			if(User.checkLogin(user, password))
			{
				if(user instanceof Admin)
				{
					adminLogin();
				}
				else if(user instanceof Student)
				{
					studentLogin();
				}
				else if(user instanceof Teacher)
				{
					teacherLogin();
				}
				else if(user instanceof Manager)
				{
					managerLogin();
				}
				else if(user instanceof TechGuy)
				{
					techGuyLogin();
				}
				break;
			}
		}
		
	}

	@Override
	protected void studentLogin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void teacherLogin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void managerLogin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void adminLogin() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void techGuyLogin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeLogs(String logs) {
		try {
			out.write(logs);
		} catch (IOException e) {
			System.out.println(logs);
		}		
	}

	@Override
	protected void serializeAll() {
		try {
			User.serializeAllUsers(serializationPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Course.serialize(serializationPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void deserializeAll() {
		try {
			User.deserializeAllUsers(serializationPath);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Course.deserialize(serializationPath);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
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

