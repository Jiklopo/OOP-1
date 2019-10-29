package b;

public abstract class Vector {
	int dim;
	
	public abstract double calculateLength();

	public abstract double dotProduct(Vector v);
	
	public double dotProduct(double module, double angle)
	{
		return calculateLength() * module * Math.cos(angle);
	}
	
	public abstract Vector crossProduct(Vector v);
	
	public abstract void addVector(Vector v);
	
	public double piffagor(double x, double y, double z)
	{
		double res = x * x + y * y + z * z;
		return Math.sqrt(res);
	}
	
	public double piffagor(double x, double y)
	{
		return piffagor(x, y, 0);
	}
	
	
}
