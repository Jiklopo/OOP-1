package iHateFee;

public abstract class Connection extends Circuit {

	protected Circuit circuit1, circuit2;
	
	public Connection(Circuit circuit1, Circuit circuit2)
	{
		this.circuit1 = circuit1;
		this.circuit2 = circuit2;
	}

	@Override
	public void applyVoltage(double v)
	{		
		double r1 = circuit1.getResistance();
		double r2 = circuit2.getResistance();
		circuit1.applyVoltage((r1/getResistance() * getVoltage()));
		circuit2.applyVoltage((r1/getResistance() * getVoltage()));
	}

}
