
public class Main {
	public static void main(String[] args) {
		Temperature temp = new Temperature(140, 'F');
		System.out.println(temp.getScale() + " " + temp.degreesC());
	}

}
