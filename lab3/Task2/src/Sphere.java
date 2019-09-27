
public class Sphere extends Shape3D {

	public Sphere() {super();}
	
	public Sphere(double radius)
	{
		this.radius = radius;
	}
	@Override
	public double surfaceArea() {
		return crossSectionArea() * 4;
	}

	@Override
	public double volume() {
		return (crossSectionArea() * radius * 4) / 3;
	}

	@Override
	public double crossSectionArea() {
		return Math.PI * Math.pow(radius, 2);
	}

}
