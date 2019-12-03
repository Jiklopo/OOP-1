package users;

import java.lang.*;
import java.util.Collections;
import java.util.Queue;
import java.util.Vector;


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

	public static Vector<TechGuy> getAllTechs()
	{
		Vector<TechGuy> res = new Vector<TechGuy>();
		for(User u: allUsers.keySet())
		{
			if(u instanceof Teacher)
				res.add((TechGuy)u);
		}
		Collections.sort(res);
		return res;
	}	
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

