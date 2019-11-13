package iHateFee;

public class Series extends Connection {

	public Series(Circuit circuit1, Circuit circuit2) {
		super(circuit1, circuit2);
	}

	@Override
	public double getVoltage() {
		return circuit1.getVoltage() + circuit2.getVoltage();
	}

	@Override
	public double getResistance() {
		return circuit1.getResistance() + circuit2.getResistance();
	}

	public void applyVoltage(double v)
	{		
		double r1 = circuit1.getResistance();
		double r2 = circuit2.getResistance();
		circuit1.applyVoltage((r1/getResistance() * getVoltage()));
		circuit2.applyVoltage((r2/getResistance() * getVoltage()));
	}
}
