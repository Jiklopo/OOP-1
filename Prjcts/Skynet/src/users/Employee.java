package users;

import java.lang.*;

/**
 */
public abstract class Employee extends User {
	public Employee() {}
    public Employee(String password, String firstName, String lastName, String phoneNumber) {
		super(password, firstName, lastName, phoneNumber);
	}

	/**
     * @param order 
     */
    public void sendOrderToTechSupport(String order) {
    }
}

