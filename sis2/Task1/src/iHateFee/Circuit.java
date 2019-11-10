package iHateFee;

public abstract class Circuit {
	public abstract double getVoltage();
	
	public abstract double getResistance();
	
	public abstract void applyVoltage(double v);
	
	public double getPower()
	{
		return getVoltage() * getCurrent();
	}
	
	public double getCurrent()
	{
		return getVoltage() / getResistance();
	}
}
