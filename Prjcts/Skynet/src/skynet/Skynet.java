package skynet;

import java.io.IOException;

import universityStuff.Course;
import users.User;

/**
 * 
 * @author Jiklopo
 *
 */
public abstract class Skynet {
    /**
     * @throws IOException 
     */
    protected abstract void userLogin() throws IOException;

    /**
     */
    protected abstract void studentLogin();

    /**
     */
    protected abstract void teacherLogin();

    /**
     */
    protected abstract void managerLogin();

    /**
     */
    protected abstract void adminLogin();
    
    protected abstract void techGuyLogin();
    
    /**
     * 
     * @param logs
     */
    protected abstract void writeLogs(String logs);
    
    /**
     * 
     * @param path
     */
    protected abstract void serializeAll();
    /**
     * 
     */
    protected abstract void deserializeAll();
}

