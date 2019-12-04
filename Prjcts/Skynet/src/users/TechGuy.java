
package users;

import java.lang.*;
import java.util.Queue;

/**TechGuy class, which extends from User, fulfills orders that he receives from the Employee.
 * Received orders are stored in the Queue<String> orders, then Technical manager takes it from there and fulfills.*/
public class TechGuy extends User {

	public TechGuy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TechGuy(String password, String firstName, String lastName, String phoneNumber) {
		super(password, firstName, lastName, phoneNumber);
	}

	/**
	 * All orders that have been received are stored here.
	 */
	private static Queue<String> orders;

	public String getOrder() {
		return currentOrder;
	}
	private String currentOrder;

	private int ordersDone;


	public static boolean receiveOrder(String order) {
		return orders.add(order);
	}

	public void takeOrder() {
		if(currentOrder == null)
			currentOrder=orders.poll();
	}

	public void finishOrder() {
		currentOrder = null;
		ordersDone++;
	}

	public String toString() {
		return super.toString() + ". Current order: " + currentOrder;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((currentOrder == null) ? 0 : currentOrder.hashCode());
		result = prime * result + ordersDone;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TechGuy other = (TechGuy) obj;
		return login.equals(other.login);
	} 
}

