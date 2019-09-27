
public abstract class Shape3D 
{
	protected double length, height, width, radius;
	
	public Shape3D()
	{
		length = height = width = 1;
	}
	
	public abstract double surfaceArea();
	
	public abstract double volume();
	
	public abstract double crossSectionArea();
	
	public String getReport()
	{
		String cls = this.getClass().toString();
		String report = cls.substring(6, cls.length()) + " has a volume " + volume() + 
				" and a surface area " + surfaceArea() + ".";		
		return report;
	}
	
	public void SCREAM()
	{
		System.out.println("AAAAAAAAAAAAAAAAAA!");
	}
}
