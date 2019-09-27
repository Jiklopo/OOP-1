
public abstract class Animal 
{
	private String name;
	
	enum foodType {MEAT, VEGETABLES, FRUITS, LEAVES, GARBAGE}
	public Animal()
	{
		name = null;		
	}
	
	public Animal(String name)
	{
		this.name = name;
	}
	
	public abstract void makeSound();
	
	public abstract boolean eat(foodType food);
	
	public String getName()
	{
		return name;
	}
}
