
public class Cube extends Shape3D {
	
	public Cube() {super();}
	
	public Cube(double a)
	{
		length = a;
	}

	@Override
	public double surfaceArea() {
		return crossSectionArea() * 6;
	}

	@Override
	public double volume() {
		return Math.pow(length, 3);
	}

	@Override
	public double crossSectionArea() {
		return Math.pow(length, 2);
	}

}
