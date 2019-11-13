package bank;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable{
	public static ArrayList<Boolean> createdAccNumbers;
	protected String holderName;
	protected int accNumber;
	protected float balance;
	protected boolean isCredit;
	private int numberOfTransactions;
	protected final int FREE_TRANSACTIONS = 100;
	
	static
	{
		try
		{
			ObjectInputStream deserializer = new ObjectInputStream(new FileInputStream("resources\\createdAccounts.out"));
			createdAccNumbers = (ArrayList<Boolean>) deserializer.readObject();
			deserializer.close();
		}
		
		catch(Exception e)
		{
			createdAccNumbers = new ArrayList<Boolean>();
		}
	}
	
	{
		accNumber = createdAccNumbers.size();
		//createdAccNumbers.ensureCapacity(accNumber + 1);
		createdAccNumbers.add(true);
		numberOfTransactions = 0;
		try
		{
			ObjectOutputStream serializer = new ObjectOutputStream(new FileOutputStream("resources\\createdAccounts.out"));
			serializer.writeObject(createdAccNumbers);
			serializer.close();
		}
		catch(Exception e) {}
	}
	
	//Constructors
	public Account()
	{
		balance = 0;
		holderName = "";
		isCredit = false;
	}
	
	public Account(int accountNumber)
	{
		this.accNumber = accountNumber;
	}
	
	public Account(String holderName)
	{
		super();
		this.holderName = holderName;
	}
	
	public Account(String holderName, boolean isCredit)
	{
		this(holderName);
		this.isCredit = isCredit;
	}
	
	//Methods
	public void deposit(float deposit)
	{
		balance += deposit;
	}
	
	public boolean withdraw(float withdrawal)
	{
		if(balance - withdrawal > 5 || isCredit)
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
			numberOfTransactions++;
			target.deposit(amount);
			return true;
		}
		return false;
	}
	
	public final void print()
	{
		System.out.println(toString());
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
	
	public int getNumberOfTransactions()
	{
		return numberOfTransactions;
	}
	
	
	//Overriden methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accNumber;
		result = prime * result + (int)(balance);
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
