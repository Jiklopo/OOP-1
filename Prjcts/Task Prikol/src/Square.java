

public class Square extends Shape {

	int length;
	public Square() {
	}

	public Square(Color c, int x, int length) {
		super(c, x);
		this.length = length;
	}
	@Override
	public void draw() {
		makeSpace();
		if(c == Color.BLACK)
			System.out.println("[ ]");
		else
			System.err.println("[ ]");
	}
	
	public double detDiagonal()
	{
		return length*Math.sqrt(2);
	}

}
