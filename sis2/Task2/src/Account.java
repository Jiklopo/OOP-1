import java.util.ArrayList;
public abstract class Account {
	public static ArrayList<Boolean> createdAccNumbers = new ArrayList<Boolean>();
	protected String holderName;
	protected int accNumber;
	protected float balance;
	protected boolean isCredit;
	
	{
		accNumber = createdAccNumbers.size();
		createdAccNumbers.set(accNumber, true);		
	}
	
	//Constructors
	public Account()
	{
		balance = 0;
		holderName = "";
		isCredit = false;
	}
	
	public Account(String holderName)
	{
		super();
		this.holderName = holderName;
	}
	
	public Account(String holderName, float balance)
	{
		this(holderName);
		this.balance = balance;
	}
	
	public Account(String holderName, float balance, boolean isCredit)
	{
		this(holderName, balance);
		this.isCredit = isCredit;
	}
	
	//Methods
	public void deposit(float deposit)
	{
		balance += deposit;
	}
	
	public boolean withdraw(float withdrawal)
	{
		if(balance - withdrawal > 0 || isCredit)
		{
			balance -= withdrawal;
			return true;
		}
		return false;
	}
	
	public boolean transfer(float amount, Account target)
	{
		if(withdraw(amount))
		{
			target.deposit(amount);
			return true;
		}
		return false;
	}
	
	
	//Getters and Setters
	public String getHolderName() {
		return holderName;
	}
	
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	
	public int getAccNumber() {
		return accNumber;
	}
	
	public float getBalance() {
		return balance;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}

	
	
	//Overriden methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accNumber;
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + ((holderName == null) ? 0 : holderName.hashCode());
		result = prime * result + (isCredit ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return accNumber == other.accNumber;
	}
	
	public String toString()
	{
		String s = "Account number: %s\n"
				+ "Holder Name: %s\n"
				+ "Balance: %s\n";
		return String.format(s, accNumber, holderName, balance);
	}
}
