
public class Sphere extends Shape3D {

	public Sphere() {super();}
	
	public Sphere(double radius)
	{
		this.length = radius;
	}
	@Override
	public double surfaceArea() {
		return crossSectionArea() * 4;
	}

	@Override
	public double volume() {
		return (crossSectionArea() * length * 4) / 3;
	}

	@Override
	public double crossSectionArea() {
		return Math.PI * Math.pow(length, 2);
	}

}
