package universityStuff;

import java.sql.Date;

import javax.security.auth.Subject;

/**
 */
public class TimeTable implements Serializable, Comparable{
	
	public TimeTable(boolean checkCollision) {
		this.checkCollision() = checkCollision;
	}
	
	public TimeTable() {
		
	}
	
    /**
    Subject  private HashMap<Subject, Date> timeTable;

    /**
     * @return 
     */
    public boolean checkCollision() {
        return false;
    }
    
    public boolean equals(Object o) {
    	TimeTable tt = (TimeTable) o;
    	if(this == tt) return true;
    	
    	if(!(this instanceof tt)) return false;
    	return this.checkCollision.equals(tt.checkCollision);
    }
    
    public int compareTo(Object o) {
    	TimeTable tt = (TimeTable) o;
    	return this.checkCollision.compareTo(tt.checkCollison);
    }
    
    public int hashCode() {
    	int result = 37;
    	result = result + checkCollision.hashCode();
    }
}

