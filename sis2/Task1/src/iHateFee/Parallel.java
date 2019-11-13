package iHateFee;

public class Parallel extends Connection{

	public Parallel(Circuit circuit1, Circuit circuit2) {
		super(circuit1, circuit2);
	}

	@Override
	public double getVoltage() {
		return circuit1.getVoltage();
	}

	@Override
	public double getResistance() {
		double r1 = circuit1.getResistance();
		double r2 = circuit2.getResistance();
		return (r1 * r2)/(r1 + r2);
	}
	
	@Override
	public void applyVoltage(double v)
	{
		circuit1.applyVoltage(v);
		circuit2.applyVoltage(v);
	}

}
