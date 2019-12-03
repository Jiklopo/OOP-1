package universityStuff;

import java.sql.Date;
import java.util.*;
import java.io.*;

/**
 */
public class TimeTable implements Serializable{
	
	/**
	 * 
	 */
	private HashMap<Subject, Date> timeTable;
	
	public TimeTable() {
		timeTable = new HashMap<Subject, Date>();
	}
	

    /**
     * @return 
     */
    public boolean checkCollision() {
        return false;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((timeTable == null) ? 0 : timeTable.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object o) {
    	TimeTable tt = (TimeTable) o;
    	if(this == tt) return true;
    	if(!(this instanceof TimeTable)) return false;
    	
    	return timeTable.equals(tt);
    }
}

