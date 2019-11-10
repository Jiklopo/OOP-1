package iHateFee;

public class Resistor extends Circuit {

	//Fields
	private double resistance, voltage;
	
	//Constructors
	public Resistor()
	{
		resistance = 1;
		voltage = 1;
	}
	
	public Resistor(double resistance, double voltage)
	{
		this.resistance = resistance;
		this.voltage = voltage;
	}
	
	
	//Overriden abstract methods
	@Override
	public double getVoltage() {
		return voltage;
	}

	@Override
	public double getResistance() {
		return resistance;
	}

	@Override
	public void applyVoltage(double v) {
		this.voltage = v;
	}

}
