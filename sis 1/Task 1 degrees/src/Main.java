
public class Main {

	public static void main(String[] args) {
		Temperature t = new Temperature(140, 'F');
		System.out.println(t.getScale() + " " + t.degreesC());
	}

}
