package users;

import java.lang.*;
import java.util.Queue;


/**
 */
public class TechGuy extends User {
	public TechGuy(String password, String firstName, String lastName, String phoneNumber) {
		super(password, firstName, lastName, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	/**
	 */
	private static Queue<String> orders;

	/**
	 */
	private String currentOrder;

	/**
	 */
	private int ordersDone;

	/**
	 * @param order 
	 * @return 
	 */
	public static boolean receiveOrder(String order) {
		return false;
	}

	/**
	 */
	public void takeOrder() {
	}

	/**
	 */
	public void finishOrder() {
	}
}

