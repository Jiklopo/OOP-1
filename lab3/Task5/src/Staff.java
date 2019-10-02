
public class Staff extends Person 
{
	private String school;
	private double pay;
	
	public Staff()
	{
		super();
		school = "NPMS";
		pay = 120.0;
	}
	
	public Staff(String name, String address, String school, double pay)
	{
		super(name, address);
		this.school = school;
		this.pay = pay;
	}
	
	public String getSchool()
	{
		return school;
	}
	
	public double getPay()
	{
		return pay;
	}
	
	public void setPay(double pay)
	{
		this.pay = pay;
	}
	
	public void setSchool(String school)
	{
		this.school = school;
	}
	
	public String toString()
	{
		return super.toString() + ". I'am also a Staff. I work at " 
				+ school + " and I get "
				+ pay + " thousand tenge";  
	}
}
