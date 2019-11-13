import java.util.Comparator;
import java.util.Date;

public class Employee extends Person implements Comparable, Cloneable
{
	//Fields
	protected double salary;
	protected Date hireDate;
	protected String insuranceNumber;
	
	public static final Comparator<Employee> compareByName = Comparator.comparing(Employee::getName);
	public static final Comparator<Employee> compareBySalary = Comparator.comparing(Employee::getSalary);
	
	
	//Constructors
	public Employee()
	{
		super();
		hireDate = new Date();
		salary = 1000;
		insuranceNumber = "000000";
	}
	
	public Employee(String name)
	{
		super(name);
		hireDate = new Date();
		salary = 20000;
		insuranceNumber = "111111";
	}
	
	public Employee(String name, double salary)
	{
		this(name);
		setSalary(salary);
	}
	
	public Employee(String name, double salary, Date hireDate)
	{
		this(name, salary);
		setHireDate(hireDate);
	}
	
	public Employee(String name, double salary, Date hireDate, String insuranceNumber)
	{
		this(name, salary, hireDate);
		setInsuranceNumber(insuranceNumber);
	}
	
	
	//Getters and Setters
	public String getInsuranceNumber()
	{
		return insuranceNumber;
	}
	
	public void setInsuranceNumber(String insuranceNumber)
	{
		this.insuranceNumber = insuranceNumber;
	}
	
	public Date getHireDate()
	{
		return hireDate;
	}
	
	public void setHireDate(Date hireDate)
	{
		this.hireDate = hireDate;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	//Overriden Methods
	public String toString()
	{
		return "I'am an Employee\n" + super.toString() + " and I get " + salary + "$ per year.";
	}
	
	public int hashCode()
	{
		int result = super.hashCode();
		result = (int) (result * 31 + salary);
		result = result * 31 + hireDate.hashCode();
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

	public int compareTo(Object o) {
		Employee e = (Employee)o;
		if(this.salary > e.salary)
			return 1;
		else if(this.salary < e.salary)
			return -1;
		return 0;
	}
	
	public Employee clone() throws CloneNotSupportedException
	{
		Employee cloned = (Employee)super.clone();
		cloned.hireDate = (Date)hireDate.clone();
		cloned.insuranceNumber = new String(insuranceNumber);
		return cloned;
	}
}
