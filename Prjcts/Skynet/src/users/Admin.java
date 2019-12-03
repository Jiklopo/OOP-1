package users;
import java.util.Comparator;

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
	 * @param user 
	 * @return 
	 */
	public boolean createUser(User user) 
	{
		return false;
	}
	
	public boolean createUser(String userType, String login, String firstName, String lastName, String phoneNumber)
	{
		return true;
	}
	/**
	 * @param login 
	 * @return 
	 */
	public boolean removeUser(String login) 
	{
		return false;
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
	 * @param newLogin 
	 * @param oldLogin 
	 * @return 
	 */
	public boolean changeUserLogin (String oldLogin, String newLogin) throws UserNotFoundException 
	{
		return false;
	}
	/**
	 * @param newName 
	 * @param oldName 
	 * @param login 
	 * @return 
	 */
	public boolean changeUserName(String login, String oldName, String newName) 
	{
		return false;
	}
	/**
	 * @param oldNumber 
	 * @param newNumber 
	 * @param user 
	 * @return 
	 */
	public boolean changeUserNumber(User user, String oldNumber, String newNumber) throws UserNotFoundException
	{
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

