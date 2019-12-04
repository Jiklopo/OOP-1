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
	
	/**
	 * 
	 * @return Vector of all Admins that exist.
	 */
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
	
	/**
	 * Creates user of type userType
	 * @param userType
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @return
	 */
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
	 * 
	 * @param login
	 * @param newFirstName
	 * @return true if user was found and name changed
	 */
	public boolean changeUserFirstName(String login, String newFirstName) 
	{
		User user = User.getUserByLogin(login);
		if(user == null)
			return false;
		return changeUserFirstName(user, newFirstName);
	}
	
	/**
	 * 
	 * @param user
	 * @param newFirstName
	 * @return true if name was changed
	 */
	public boolean changeUserFirstName(User user, String newFirstName)
	{
		if(user == null)
			return false;
		user.firstName = newFirstName;
		return true;
	}

	/**
	 * 
	 * @param user
	 * @param newFirstName
	 * @return true if name was changed
	 */
	public boolean changeUserLastName(User user, String newLastName)
	{
		if(user == null)
			return false;
		user.lastName = newLastName;
		return true;
	}
	
	/**
	 * 
	 * @param login
	 * @param newFirstName
	 * @return true if name was changed
	 */
	public boolean changeUserLastName(String login, String newLastName) 
	{
		User user = User.getUserByLogin(login);
		if(user == null)
			return false;
		return changeUserLastName(user, newLastName);
	}
	
	/**
	 * 
	 * @param login
	 * @param newNumber
	 * @return true if number was changed
	 */
	public boolean changeUserNumber(String login, String newNumber)
	{
		User user = User.getUserByLogin(login);
		if(user == null)
			return false;
		return changeUserNumber(user, newNumber);
	}
	
	/**
	 * 
	 * @param user
	 * @param newNumber
	 * @return true if number was changed
	 */
	public boolean changeUserNumber(User user, String newNumber)
	{
		user.phoneNumber = newNumber;
		return true;
	}
}

