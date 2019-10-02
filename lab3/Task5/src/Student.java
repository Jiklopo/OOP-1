
public class Student extends Person 
{
	private String program;
	private int year;
	private double fee;
	
	public Student()
	{
		program = "Netu :(";
		year = 1;
		fee = 1.5;
	}
	
	public Student(String name, String address, String program, int year, double fee)
	{
		super(name, address);
		this.year = year;
		this.program = program;
		this.fee = fee;
	}
	
	public String getProgram()
	{
		return program;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public double getFee()
	{
		return fee;
	}
	
	public void setProgram(String program)
	{
		this.program = program;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public void setFee(double fee)
	{
		this.fee = fee;
	}
	
	public String toString()
	{
		return super.toString() + ". I'am also a Student. My program is " 
				+ program + ", I study at " + year + "th year and I pay " 
				+ fee + " millions tenge per year!";
	}
}
