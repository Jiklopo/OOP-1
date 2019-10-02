
public class Cylinder extends Shape3D {

	double height;
	public Cylinder() {super();}
	
	public Cylinder(double height, double radius)
	{
		this.height = height;
		this.length = radius;
	}
	@Override
	public double surfaceArea() {
		return (2 * Math.PI * length * height) + (crossSectionArea() * 2);
	}

	@Override
	public double volume() {
		return crossSectionArea() * height;
	}

	@Override
	public double crossSectionArea() {
		return Math.PI * Math.pow(length, 2);
	}
}
