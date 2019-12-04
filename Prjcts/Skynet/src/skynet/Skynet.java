package skynet;

import java.io.*;
import users.*;
import universityStuff.*;

/**
 * 
 * @author Jiklopo
 * This abstract class represents how any Skynet should be built. Whether it is console or web application.
 */
public abstract class Skynet {

	/**
	 * This is a path where all serialized files will be stored.
	 * It MUST end with // because it indicates the folder where files will be stored.
	 */
	protected String serializationPath;
	
	public Skynet () {}

	public Skynet(String serializationPath)
	{
		this.serializationPath = serializationPath;
	}
	/**
	 * @throws IOException 
	 * In this method user inputs his login and password and system checks it validity
	 */
	protected abstract void userLogin() throws IOException;

	/**
	 * @throws IOException
	 * This method perform required actions when student logs in
	 */
	protected abstract void studentLogin(Student student) throws IOException;

	/**
	 * @throws IOException
	 * This method perform required actions when teacher logs in
	 */
	protected abstract void teacherLogin(Teacher teacher) throws IOException;

	/**
	 * 
	 * @param manager is the manager who is logging in
	 * This method perform required actions when student logs in
	 */
	protected abstract void managerLogin(Manager manager);

	/**
	 * @throws IOException 
	 */
	protected abstract void adminLogin(Admin admin) throws IOException;

	protected abstract void techGuyLogin(TechGuy techGuy);

	/**
	 * This method is needed to write logs.
	 * @param logs
	 */
	protected abstract void writeLogs(String logs);


	/**
	 * This method serializes static collections that hold all users and courses.
	 * It also write logs when serialization was unsuccessful
	 */
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

	/**
	 * This method deserializes static collections that hold all users and courses.
	 * It also write logs when deserialization was unsuccessful
	 */
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


	public String getSerializationPath() {
		return serializationPath;
	}

	public void setSerializationPath(String serializationPath) {
		this.serializationPath = serializationPath;
	}

}

