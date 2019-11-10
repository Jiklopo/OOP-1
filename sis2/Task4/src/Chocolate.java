
public class Chocolate implements Comparable{
	//Fields
	private float weight;
	private String name;
	
	//Constructors
	public Chocolate()
	{
		weight = 1;
		name = "";
	}
	
	public Chocolate(String name, float weight)
	{
		this.name = name;
		this.weight = weight;
	}
	
	
	//OVerriden Methods
	public int compareTo(Object o) {
		Chocolate c = (Chocolate) o;
		return (int) (weight - c.weight);
	}
	
	public String toString()
	{
		return "Chocolate " + name + " " + weight;
	}
	
}
