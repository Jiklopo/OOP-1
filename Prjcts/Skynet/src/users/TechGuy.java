/*TechGuy class, which extends from User, fulfills orders that he receives from the Employee.
 * Received orders are stored in the Queue<String> orders, then Technical manager takes it from there and fulfills.*/

package users;

import java.lang.*;
import java.util.Queue;


public class TechGuy extends User {
	
	public TechGuy() {
	    super();
	    // TODO Auto-generated constructor stub
	  }
	  public TechGuy(String password, String firstName, String lastName, String phoneNumber) {
			super(password, firstName, lastName, phoneNumber);
				
	private static Queue<String> orders;
    
    public String getOrder() {
    	return currentOrder;
    }
    private String currentOrder;

    private int ordersDone;
  

    public static boolean receiveOrder(String order) {
        return false;
    }

    public void takeOrder() {
    	
    	currentOrder=orders.poll();
    	
    }

    public void finishOrder() {
    	  ordersDone++;
    }
}

  public int hashCode() { 
		return super.hashCode(); 
		}
	}
  
	public String toString() {
		return "TechGuy [currentOrder=" + currentOrder + ", ordersDone=" + ordersDone + "]";
	} 
          
