package skynet;

import java.io.FileNotFoundException;
import java.io.IOException;
import users.*;
import universityStuff.Course;

/**
 * 
 * @author Jiklopo
 *
 */
public abstract class Skynet {

	protected String serializationPath;
	
	public Skynet () {}

	public Skynet(String serializationPath)
	{
		this.serializationPath = serializationPath;
	}
	/**
	 * @throws IOException 
	 */
	protected abstract void userLogin() throws IOException;

	/**
	 * @throws IOException 
	 */
	protected abstract void studentLogin(Student student) throws IOException;

	/**
	 * @throws IOException 
	 */
	protected abstract void teacherLogin(Teacher teacher) throws IOException;

	/**
	 */
	protected abstract void managerLogin(Manager manager);

	/**
	 */
	protected abstract void adminLogin(Admin admin);

	protected abstract void techGuyLogin(TechGuy techGuy);

	/**
	 * 
	 * @param logs
	 */
	protected abstract void writeLogs(String logs);


	protected void serializeAll() {
		try {
			User.serializeAllUsers(serializationPath);
		} catch (FileNotFoundException e) {
			writeLogs(e.getMessage());
		} catch (IOException e) {
			writeLogs(e.getMessage());
		}
		
		try {
			Course.serialize(serializationPath);
		} catch (FileNotFoundException e) {
			writeLogs(e.getMessage());
		} catch (IOException e) {
			writeLogs(e.getMessage());
		}
	}

	protected void deserializeAll() {
		try {
			User.deserializeAllUsers(serializationPath);
		}
		catch (FileNotFoundException e) {
			writeLogs(e.getMessage());
		}
		catch (IOException e) {
			writeLogs(e.getMessage());
		}
		catch (ClassNotFoundException e) {
			writeLogs(e.getMessage());
		}
		
		
		try {
			Course.deserialize(serializationPath);
		}
		catch (FileNotFoundException e) {
			writeLogs(e.getMessage());
		}
		catch (IOException e) {
			writeLogs(e.getMessage());
		}
		catch (ClassNotFoundException e) {
			writeLogs(e.getMessage());
		}
	}
}

