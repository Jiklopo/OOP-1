

public class Circle extends Shape {

	int radius;
	public Circle() {
	}

	public Circle(Color c, int x, int radius) {
		super(c, x);
		this.radius = radius;
	}
	public void draw() {
		makeSpace();
		if(c == Color.BLACK)
			System.out.println("( )");
		else
			System.err.println("( )");
	}
	
	public int getRadius()
	{
		return radius;
	}
}
