
public abstract class Shape3D 
{
	protected double length;
	
	public Shape3D()
	{
		length = 1;
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
}
