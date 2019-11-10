package bank;

import java.util.HashSet;
import java.io.*;
public class Bank {
	private HashSet<Account> accounts;
	private float serviceCost;
	
	private enum AccountType
	{
		REGULAR,
		SAVING,
		CHECKING
	}
	
	{
		try
		{
			ObjectInputStream deserializer = new ObjectInputStream(new FileInputStream("resources\\accounts.out"));
			accounts = (HashSet<Account>) deserializer.readObject();
			deserializer.close();
		}
		
		catch(Exception e)
		{
			accounts = new HashSet<Account>();
		}
	}
	
	
	public Bank()
	{
		serviceCost = 0.05f;
	}
	
	
	
	//Methods
	public void update()
	{
		for(Account a: accounts)
		{
			a.withdraw(serviceCost);
			if(a instanceof SavingsAccount)
			{
				((SavingsAccount) a).addInterest();
			}
		}
	}
	
	
	//Universal method for adding accounts
	//Maybe way too universal
	private void openAccount(AccountType type, String holderName, boolean isCredit, float transferCharge, float interestRate)
	{
		if(type == AccountType.REGULAR)
			accounts.add(new Account(holderName, isCredit));
		else if(type == AccountType.CHECKING)
			accounts.add(new CheckingAccount(holderName, isCredit, transferCharge));
		else if(type == AccountType.SAVING)
			accounts.add(new SavingsAccount(holderName, isCredit, interestRate));
		serialize();
	}
	
	
	
	//A LOT OF ACCOUNTS TO OPEN
	public void openAccount(String holderName)
	{
		openAccount(AccountType.REGULAR, holderName, false, 0, 0);
	}
	
	public void openAccount(String holderName, boolean isCredit)
	{
		openAccount(AccountType.REGULAR, holderName, isCredit, 0, 0);
	}
	
	public void openCheckingAccount(String holderName, boolean isCredit, float transferCharge)
	{
		openAccount(AccountType.CHECKING, holderName, isCredit, transferCharge, 0);
	}
	
	public void openSavingAccount(String holderName, boolean isCredit, float interestRate)
	{
		openAccount(AccountType.SAVING, holderName, isCredit, 0, interestRate);
	}
	
	public void openAccount(Account account)
	{
		accounts.add(account);
		serialize();
	}
	
	
	
	
	public void closeAccount(int accountNumber)
	{
		accounts.remove(new Account(accountNumber));
		serialize();
	}
	
	private boolean serialize()
	{
		try
		{
			ObjectOutputStream serializer = new ObjectOutputStream(new FileOutputStream("resources\\accounts.out"));
			serializer.writeObject(accounts);
			serializer.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
