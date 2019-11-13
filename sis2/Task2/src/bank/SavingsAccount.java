package bank;

public class SavingsAccount extends Account 
{
	//Fields
	private float interestRate;

	//Constructors
	public SavingsAccount() {
		super();
		interestRate = 0.02f;
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(String holderName, boolean isCredit) {
		super(holderName, isCredit);
	}

	public SavingsAccount(String holderName, boolean isCredit, float interestRate)
	{
		super(holderName, isCredit);
		this.interestRate = interestRate;
	}
	
	
	
	//Methods
	public void addInterest()
	{
		deposit(balance * interestRate);
	}
	
	//Overriden Methods
	public String toString()
	{
		return "Savings Account\n"
				+ super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int)(interestRate);
		return result;
	}
	
	
	
	
}
