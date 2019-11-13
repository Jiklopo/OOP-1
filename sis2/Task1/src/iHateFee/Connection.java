package iHateFee;

public abstract class Connection extends Circuit {

	protected Circuit circuit1, circuit2;
	
	public Connection(Circuit circuit1, Circuit circuit2)
	{
		this.circuit1 = circuit1;
		this.circuit2 = circuit2;
	}
}
