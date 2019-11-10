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

}
