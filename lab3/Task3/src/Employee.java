
public class Employee extends Person 
{
	private double salary;
	private int yearStarted;
	private String insuranceNumber;
	
	public Employee()
	{
		super();
		yearStarted = 2000;
		salary = 1000;
		insuranceNumber = "000000";
	}
	
	public Employee(String name)
	{
		super(name);
		yearStarted = 2019;
		salary = 20000;
		insuranceNumber = "111111";
	}
	
	public Employee(String name, double salary)
	{
		this(name);
		setSalary(salary);
	}
	
	public Employee(String name, double salary, int yearStarted)
	{
		this(name, salary);
		setYearStarted(yearStarted);
	}
	
	public Employee(String name, double salary, int yearStarted, String insuranceNumber)
	{
		this(name, salary, yearStarted);
		setInsuranceNumber(insuranceNumber);
	}
	
	
	public String getInsuranceNumber()
	{
		return insuranceNumber;
	}
	
	public int getYearStarted()
	{
		return yearStarted;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	public void setYearStarted(int yearStarted)
	{
		this.yearStarted = yearStarted;
	}
	
	public void setInsuranceNumber(String insuranceNumber)
	{
		this.insuranceNumber = insuranceNumber;
	}
	
	public String toString()
	{
		return "I'am an Employee\n" + super.toString() + " and I get " + salary + "$ per year.";
	}
	
	public int hashCode()
	{
		int result = super.hashCode();
		result = (int) (result * 31 + salary);
		result = result * 31 + yearStarted;
		result = result * 31 + insuranceNumber.hashCode();
		return result;
	}
	
	public boolean equals(Object o)
	{
		if(this.getClass() != o.getClass())
			return false;
		if(o == this)
			return true;
		
		Employee e = (Employee) o;
		return (e.salary == salary) && (e.insuranceNumber.equals(insuranceNumber));
	}
}
