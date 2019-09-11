
public class Account {
	private int balance;
	public Account(int balance) {
		this.balance = balance;
	}
	public void add(int interest) {
		balance += balance * interest/100;
		System.out.println(show());
	}
	public int show() {
		return balance;
	}
}
