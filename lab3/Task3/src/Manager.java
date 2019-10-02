import java.util.Vector;

public class Manager extends Employee {

	private Vector<Employee> employees;
	public Manager() 
	{
		// TODO Auto-generated constructor stub
	}

	public Manager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, double salary) {
		super(name, salary);
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, double salary, int yearStarted) {
		super(name, salary, yearStarted);
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, double salary, int yearStarted, String insuranceNumber) {
		super(name, salary, yearStarted, insuranceNumber);
		// TODO Auto-generated constructor stub
	}
	
	public Manager(String name, double salary, int yearStarted, String insuranceNumber, Vector<Employee> employees)
	{
		super(name, salary, yearStarted, insuranceNumber);
		this.employees = employees;
	}
	
	public void getBonus(double bonus)
	{
		setSalary(getSalary() + bonus);
	}
	
	public boolean equals(Object o)
	{
		if(this.getClass() != o.getClass())
			return false;
		if(o == this)
			return true;
		
		Manager m = (Manager)o;
		
		return m.employees.equals(employees) && m.getName().equals(getName());
	}
	
	public String toString()
	{
		String result = "I'am Manager and " + super.toString() + " and these people work for me: \n";
		for(Employee e: employees)
			result += e + "\n";
		return result;
	}
}
