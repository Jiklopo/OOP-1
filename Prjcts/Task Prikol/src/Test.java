import java.util.Vector;

public class Test {


	public static void main(String[] args) {
		Vector<Shape> shapes = new Vector<Shape>();
		shapes.add(new Circle(Shape.Color.RED, 3, 15));
		shapes.add(new Star(Shape.Color.BLACK, 5, "Milky Way"));
		shapes.add(new Square(Shape.Color.RED, 8, 2));
		for(Shape s: shapes)
		{
			if(s instanceof Circle)
			{
				Circle c = (Circle)s;
				System.out.println(c.getRadius());
			}
			
			else if(s instanceof Star)
			{
				Star star = (Star) s;
				System.out.println(star.getGalaxy());
			}
			
			else if(s instanceof Square)
			{
				Square square = (Square) s;
				System.out.println(square.detDiagonal());
			}
			s.draw(4);
		}
	}

}
