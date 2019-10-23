
public class Instructor {
	private String firstName, lastName, department, email;
	
	public Instructor() {};
	
	public Instructor(String firstName, String lastName, String department, String email)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.email = email;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setDepartment(String department)
	{
		this.department = department;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}

	public String toString()
	{
		return firstName + " " + lastName + " works at " + department + ", has email: " + email + ".";
	}
	
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		if(this.getClass() != o.getClass())
			return false;
		
		return this.toString().equals(o.toString());
	}
}
