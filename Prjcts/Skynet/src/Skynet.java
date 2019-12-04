import java.lang.*;

/**
 * This abstract class represents how Skynet system should be build.
 * No matter if it is console application, or any other.
 */
public abstract class Skynet {
    /**
     * @param password 
     * @param login 
     * @return 
     */
    public boolean checkLogin(String login, String password) {
        return false;
    }

    /**
     * This is a login screen
     */
    public void userLogin() {
    }

    /**
     */
    protected void studentLogin() {
    }

    /**
     */
    protected void teacherLogin() {
    }

    /**
     */
    protected void managerLogin() {
    }

    /**
     */
    protected void adminLogin() {
    }
}

