package users;

import java.lang.*;
import java.util.Queue;


/**
 */
public class TechGuy extends User {
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

