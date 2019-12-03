package users;

public class UserFactory {
	public static User getUser(String userType, String password, String firstName, String lastName, String phoneNumber)
	{
		if(userType == null)
			return null;
		else if(userType.equalsIgnoreCase("teacher"))
			return new Teacher(password, firstName, lastName, phoneNumber);
		else if(userType.equalsIgnoreCase("manager"))
			return new Manager(password, firstName, lastName, phoneNumber);
		else if(userType.equalsIgnoreCase("techguy"))
			return new TechGuy(password, firstName, lastName, phoneNumber);
		else if(userType.equalsIgnoreCase("admin"))
			return new Admin(password, firstName, lastName, phoneNumber);
		else if(userType.equalsIgnoreCase("student"))
			return new Student(password, firstName, lastName, phoneNumber);		
		return null;
	}
}
