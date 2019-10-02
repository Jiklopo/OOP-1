
public class Person {
	private String name;
	
	public Person()
	{
		name = "Lexa";
	}
	
	public Person(String name)
	{
		setName(name);
	}
	
	public String toString()
	{
		return "My name is " + name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public boolean equals(Object o)
	{
		if(o.getClass() != this.getClass())
			return false;
		if(o == this)
			return true;
		
		Person p = (Person) o;
		
		return p.name.equals(name);
	}
	
	public int hashCode()
	{
		return 17 + name.hashCode();
	}
}
