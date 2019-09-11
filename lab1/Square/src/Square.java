
public class Square {//very simple class for square with functions to get everything you need
	double length;
	public Square(double length) {
		this.length = length;
	}
	
	public double Area() {
		return length*length;
	}
	
	public double Perimeter() {
		return length*4;
	}
	
	public double Diagonal() {
		return length * Math.sqrt(2);
	}
	}
