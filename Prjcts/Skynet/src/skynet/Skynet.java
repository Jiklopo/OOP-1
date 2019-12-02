package skynet;
/**
 * 
 * @author Jiklopo
 *
 */
public interface Skynet {
    /**
     * @param password 
     * @param login 
     * @return 
     */
    boolean checkLogin(String login, String password);

    /**
     */
    void userLogin();

    /**
     */
    void studentLogin();

    /**
     */
    void teacherLogin();

    /**
     */
    void managerLogin();

    /**
     */
    void adminLogin();
    
    /**
     * 
     * @param logs
     */
    void writeLogs(String logs);
}

