package users;

import java.util.*;

import universityStuff.Faculties;

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
	 * Comparator used to sort users by login
	*/
	public static Comparator<User> COMPARE_BY_LOGIN = Comparator.comparing(User::getLogin);
	
	
	/**
	 * Instantiates static HashMap of all users to avoid null pointer exception
	 */
	static
	{
		allUsers = new HashMap<User, Integer>();
	}
	//Constructors	
	/**
	 * Automatically creates id number
	 */	
	public User()
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
	 * @return true if login is occupied
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
	 * Generates unique login from first and last name;
	 * @param firstName
	 * @param lastName
	 * @return unique login
	 */
	private String generateLogin(String firstName, String lastName)
	{
		int charsFromName = 1, delimNumber = 0;
		char[] delimiters = {'_', '-', '.', ':', '~', '<', '>'};
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
	 * Serializes allUsers field.
	 * @param path It must end with // because it indicates folder where file allUsers.out will be stored
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void serializeAllUsers(String path) throws FileNotFoundException, IOException {
		ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(path + "allUsers.out"));
		writer.writeObject(allUsers);
		writer.close();
	}
	
	/**
	 * Deserializes allUsers field.
	 * @param path It must end with // because it indicates folder where file allUsers.out will be stored
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void deserializeAllUsers(String path) throws IOException, FileNotFoundException, ClassNotFoundException
	{
		
		ObjectInputStream reader = new ObjectInputStream(new FileInputStream(path + "allUsers.out"));
		allUsers = (HashMap<User, Integer>)reader.readObject();
		reader.close();
		if(allUsers == null)
		{
			allUsers = new HashMap<User, Integer>();
		}
		if(allUsers.isEmpty())
		{			
			Student a = new Student("1234", "Timur", "Khaimovich", "+77777777777", Faculties.FIT);
			a.login = "jiklopo";
			serializeAllUsers(path);
		}
	}

	/**
	 * Checks validity of login and password combination
	 * @param login
	 * @param password
	 * @return true if combination is valid.
	 */
	public static boolean checkLogin(String login, String password) {
		User u = getUserByLogin(login);
		if(u != null)
		{
			return allUsers.get(u).equals(password.hashCode());
		}
		return false;
	}
	
	public static boolean checkLogin(User user, String password)
	{
		if(user == null)
			return false;
		return allUsers.get(user) == password.hashCode();
	}
	
	/**
	 * Searches user by login
	 * @param login login of the user you are looking for
	 * @return User with such login or null if user was not found
	 */
	public static User getUserByLogin(String login)
	{
		for(User u: allUsers.keySet())
		{
			if(u.login.equalsIgnoreCase(login))
				return u;
		}
		return null;
	}

	public String getLogin() {
		return login;
	}

	/**
	 * 
	 * @return First Name and Last Name in one String
	 */
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
	
	public static HashMap<User, Integer> getAllUsers()
	{
		return allUsers;
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
	/**
	 * Compares users by full name
	 */
	public int compareTo(Object o)
	{
		User u = (User)o;
		return firstName.compareTo(u.firstName);
	}
	
	@Override
	public String toString()
	{
		return id + " " + getFullName();
	}
}
