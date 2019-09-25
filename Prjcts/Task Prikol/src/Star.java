

public class Star extends Shape {

	String galaxy;
	public Star() {
	}

	public Star(Color c, int x, String galaxy) {
		super(c, x);
		this.galaxy = galaxy;
	}

	@Override
	public void draw() {
		makeSpace();
		if(c == Color.BLACK)
			System.out.println(" * ");
		else
			System.err.println(" * ");
	}
	
	public String getGalaxy()
	{
		return galaxy;
	}

}
