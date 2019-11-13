package bank;

public class CheckingAccount extends Account {
	//Fields
	private float transferCharge;
	
	//Constructors
	public CheckingAccount()
	{
		super();
		transferCharge = 0.02f;
	}

	public CheckingAccount(String holderName, boolean isCredit, float transferCharge) {
		super(holderName, isCredit);
		this.transferCharge = transferCharge;
	}

	
	
	//Overriden Methods
	@Override
	public boolean transfer(float amount, Account target) {
		return super.transfer(amount, target) && deductFee();
	}
	
	private boolean deductFee()
	{
		return withdraw(transferCharge);
	}
	
}
