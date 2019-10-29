import java.util.Date;
import java.util.Vector;

public class Manager extends Employee {

	private Vector<Employee> employees;
	private double bonus;
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

	public Manager(String name, double salary, Date hireDate) {
		super(name, salary, hireDate);
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, double salary, Date hireDate, String insuranceNumber) {
		super(name, salary, hireDate, insuranceNumber);
		// TODO Auto-generated constructor stub
	}
	
	public Manager(String name, double salary, Date hireDate, String insuranceNumber, Vector<Employee> employees)
	{
		super(name, salary, hireDate, insuranceNumber);
		this.employees = employees;
	}
	
	public double getBonus()
	{
		return bonus;
	}
	
	public void setBonus(double bonus)
	{
		this.bonus = bonus;
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
	
	public int compareTo(Object o)
	{
		if(super.compareTo(o) != 0)
			return super.compareTo(o);
		Manager m = (Manager)o;
		if(bonus > m.bonus)
			return 1;
		else if(bonus < m.bonus)
			return -1;
		return 0;
	}
}
