package users;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

/**
 * 
 * @author Jiklopo
 *
 */
public class Admin extends User {
	public Admin(String password, String firstName, String lastName, String phoneNumber) 
	{
		super(password, firstName, lastName, phoneNumber);
	}
	
	public static Vector<Admin> getAllAdmins()
	{
		Vector<Admin> res = new Vector<Admin>();
		for(User u: allUsers.keySet())
		{
			if(u instanceof Admin)
				res.add((Admin)u);
		}
		Collections.sort(res);
		return res;
	}
	
	
	public User createUser(String userType, String password, String firstName, String lastName, String phoneNumber)
	{
		return UserFactory.getUser(userType, password, firstName, lastName, phoneNumber);
	}
	/**
	 * @param login 
	 * @return 
	 */
	public boolean removeUser(String login) 
	{
		return allUsers.remove(User.getUserByLogin(login)) != null;
	}
	/**
	 * @param user 
	 * @return
	 * Return true if user was removed and false otherwise. 
	 */
	public boolean removeUser(User user) 
	{
		return !allUsers.remove(user).equals(null);
	}
	/**
	 * @param newName 
	 * @param oldName 
	 * @param login 
	 * @return 
	 */
	public boolean changeUserFirstName(String login, String newFirstName) 
	{
		User user = User.getUserByLogin(login);
		if(user == null)
			return false;
		return changeUserFirstName(user, newFirstName);
	}
	
	
	public boolean changeUserFirstName(User user, String newFirstName)
	{
		user.firstName = newFirstName;
		return true;
	}

	public boolean changeUserLastName(User user, String newLastName)
	{
		user.lastName = newLastName;
		return true;
	}
	
	public boolean changeUserLastName(String login, String newLastName) 
	{
		User user = User.getUserByLogin(login);
		if(user == null)
			return false;
		return changeUserLastName(user, newLastName);
	}
	
	public boolean changeUserNumber(String login, String newNumber)
	{
		User user = User.getUserByLogin(login);
		if(user == null)
			return false;
		return changeUserNumber(user, newNumber);
	}
	
	public boolean changeUserNumber(User user, String newNumber)
	{
		user.phoneNumber = newNumber;
		return true;
	}
	/**
	 * @param newName 
	 * @param oldName 
	 * @param user 
	 * @return 
	 */
	public boolean changeUserName(User user, String oldName, String newName) throws UserNotFoundException
	{
		return true;
	}

	/**
	 * @param newLogin 
	 * @param user 
	 * @return 
	 */
	public boolean changeUserLogin(User user, String newLogin) throws UserNotFoundException
	{
		return true;
	}
	/**
	 * @return 
	 */
	public String viewUsers() {
		return null;
	}
	/**
	 * @param comparator 
	 * @return 
	 */
	public String viewUsers(Comparator comparator) {
		return null;
	}
}

