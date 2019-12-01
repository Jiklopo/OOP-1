package users;

import java.util.*;


import java.io.*;

/**
*/
public abstract class User implements Comparable, Serializable {
	//Fields
	/**
	 * This map contains all users that have been created and hashCodes for their passwords
	*/
	protected static HashMap<User, Integer> allUsers;


	/**
	 * Login used to log into the Skynet
	*/
	protected String login;
	/**
	 * First Name of the user
	*/
	protected String firstName;
	/**
	 * Last Name of the user
	*/
	protected String lastName;
	/**
	 * Phone number of the user
	*/
	protected String phoneNumber;
	/**
	 * Unique id used to identify user
	*/
	protected String id;
	/**
	 * Comparator used to sort user by id
	*/
	public static final Comparator<User> COMPARE_BY_ID = Comparator.comparing(User::getId);
	/**
	*/
	public static Comparator<User> COMPARE_BY_LOGIN = Comparator.comparing(User::getLogin);
	/**
	*/
	private static String serializationPath;
	
	//Constructors	
	/**
	 * Automatically creates id number
	 */	
	private User()
	{
		id = GregorianCalendar.getInstance().get(Calendar.YEAR)%1000
				+ "SKY" + allUsers.size();		
	}

	public User(String password, String firstName, String lastName, String phoneNumber) {
		this();
		login = generateLogin(firstName, lastName);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		allUsers.put(this, password.hashCode());
	}
	
	/**
	 * Checks if user with such login exists or not
	 * @param login
	 * @return
	 */
	public boolean isLoginOccupied(String login)
	{
		for(User u: allUsers.keySet())
		{
			if(u.login.equals(login))
				return true;
		}
		return false;
	}
	
	/**
	 * This method almost guarantees uniqueness of a login
	 */
	private String generateLogin(String firstName, String lastName)
	{
		int charsFromName = 1, delimNumber = 0;
		char[] delimiters = {'_', '-', '.', ':'};
		String login = null;
		do{
			login = firstName.substring(0, charsFromName) + 
					delimiters[delimNumber] +
					lastName;
			charsFromName++;
			if(charsFromName == firstName.length())
			{
				charsFromName = 0;
				delimNumber++;
				if(delimNumber == delimiters.length)
				{
					String temp = lastName;
					lastName = firstName;
					firstName = temp;
					delimNumber = 0;
				}
			}					
		}while(isLoginOccupied(login));
		return login;
	}




	protected void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	protected void setId(String id) {
		this.id = id;
	}


	/**
	 * @throws IOException 
	 * @throws FileNotFoundException 
	*/
	public static void serializeAllUsers() throws FileNotFoundException, IOException {
		ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(serializationPath));
		writer.writeObject(allUsers);
		writer.close();
	}
	
	/**
	 * @throws IOException 
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException 
	 */
	public static void deserializeAllUsers() throws IOException, FileNotFoundException, ClassNotFoundException
	{
		ObjectInputStream reader = new ObjectInputStream(new FileInputStream(serializationPath));
		allUsers = (HashMap<User, Integer>)reader.readObject();
		reader.close();
	}

	/**
	 * @param password
	 * @return
	 */
	public boolean login(String password) {
		return false;
	}

	public String getLogin() {
		return login;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return login.equals(other.login);
	}
	
	@Override
	public int compareTo(Object o)
	{
		User u = (User)o;
		return firstName.compareTo(u.firstName);
	}
}
