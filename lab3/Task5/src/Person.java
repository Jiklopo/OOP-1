
public class Person {
	private String name, address;
	
	public Person()
	{
		name = "Vasya";
		address = "Orbita-4";
	}
	
	public Person(String name, String address)
	{
		this.name = name;
		this.address = address;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String toString()
	{
		return "My name is " + name + " and I live at " + address;
	}
	
	public boolean equals(Object o)
	{
		if(this.getClass() != o.getClass())
			return false;
		if(o == this)
			return true;
		
		Person p = (Person) o;
		return p.name.equals(name);
	}

}
