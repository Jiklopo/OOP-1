
public class Cylinder extends Shape3D {

	public Cylinder() {super();}
	
	public Cylinder(double height, double radius)
	{
		this.height = height;
		this.radius = radius;
	}
	@Override
	public double surfaceArea() {
		return (2 * Math.PI * radius * height) + (crossSectionArea() * 2);
	}

	@Override
	public double volume() {
		return crossSectionArea() * height;
	}

	@Override
	public double crossSectionArea() {
		return Math.PI * Math.pow(radius, 2);
	}
}
