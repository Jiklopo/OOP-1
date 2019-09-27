
public class Yeti extends Animal {

	furColor fur;
	enum furColor {WHITE, GREY, BROWN}
	public Yeti() 
	{
		super();
		fur = furColor.BROWN;
	}

	public Yeti(String name) 
	{
		super(name);
		fur = furColor.WHITE;
	}
	
	public Yeti(String name, String fur)
	{
		super(name);
		if(fur.toLowerCase().equals("white"))
			this.fur = furColor.WHITE;
		else if(fur.toLowerCase().equals("grey"))
			this.fur = furColor.GREY;
	}

	@Override
	public void makeSound() 
	{
		System.out.println("ROAR");
	}

	@Override
	public boolean eat(foodType food)
	{
		if(food == foodType.MEAT)
			return true;
		return false;
	}
	
	public boolean eat(foodType food, boolean isHungry)
	{
		if(isHungry)
			return true;
		return eat(food);
	}
}
