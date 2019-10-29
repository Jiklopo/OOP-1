package b;

public abstract class Vector {
	dimension dim;
	enum dimension
	{
		D3,
		D2
	}

	public abstract void dotProduct(Vector v);
	
	public abstract void crossProduct(Vector v);
	
	public abstract void addVector(Vector v);
	
	public double piffagor(double[] numbers)
	{
		double res = 0;
		for(double d: numbers)
		{
			res += d * d;
		}
		return Math.sqrt(res);
	}
}
