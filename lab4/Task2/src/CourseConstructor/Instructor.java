package CourseConstructor;

import java.io.Serializable;

public class Instructor implements Serializable{
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
		return firstName + " " + lastName + " from " + department + ", email: " + email + ".";
	}
	
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		if(this.getClass() != o.getClass())
			return false;
		
		return this.toString().equals(o.toString());
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
}
