package users;
import java.util.Comparator;

/**
*/
public class Admin extends User {
	
	
public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String login, String name, String phoneNumber) {
		super(login, name, phoneNumber);
		// TODO Auto-generated constructor stub
	}
/**
 * @param user 
 * @return 
*/
public boolean createUser(User user) {
    return false;
}
/**
 * @param login 
 * @return 
*/
public boolean removeUser(String login) {
    return false;
}
/**
 * @param user 
 * @return
 * Return true if user was removed and false otherwise. 
*/
public boolean removeUser(User user) {
    return allUsers.remove(user);
}
/**
 * @param newLogin 
 * @param oldLogin 
 * @return 
*/
public boolean changeUserLogin (String oldLogin, String newLogin) throws UserNotFoundException {
    return false;
}
/**
 * @param newName 
 * @param oldName 
 * @param login 
 * @return 
*/
public boolean  changeUserName(String login, String oldName, String newName) {
    return null;
}
/**
 * @param oldNumber 
 * @param newNumber 
 * @param user 
 * @return 
*/
public boolean throws UserNotFoundException changeUserNumber(User user, String oldNumber, String newNumber) {
    return null;
}
/**
 * @param newName 
 * @param oldName 
 * @param user 
 * @return 
*/
public boolean throws UserNotFoundException changeUserName(User user, String oldName, String newName) {
    return null;
}
/**
 * @param oldNumber 
 * @param newNumber 
 * @param user 
 * @return 
*/
public boolean throws UserNotFoundException changeUserNumber(User user, String oldNumber, String newNumber) {
    return null;
}
/**
 * @param newLogin 
 * @param user 
 * @return 
*/
public boolean throws UserNotFoundException changeUserLogin(User user, String newLogin) {
    return null;
}
/**
 * @param log 
 * @return 
*/
private boolean log(String log) {
    return false;
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

