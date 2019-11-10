package iHateFee;

public class Test {

	public static void main(String[] args) {
		Circuit a = new Resistor(3.0, 2.5);
		Circuit b = new Resistor(3.0, 3);
		Circuit c = new Resistor(6.0, 2);
		Circuit d = new Resistor(3.0, 2);
		Circuit e = new Resistor(2.0, 1.5);
		Circuit f = new Series(a, b);
		Circuit g = new Parallel(c, d);
		Circuit h = new Series(g, e);
		Circuit circuit = new Parallel(h, f);
		double R = circuit.getResistance();
		System.out.println(R);
		//Must be 2.4;
	}

}
