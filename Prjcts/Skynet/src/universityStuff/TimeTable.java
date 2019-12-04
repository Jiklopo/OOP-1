package universityStuff;

import java.util.*;
import java.io.*;

/**In the TimeTable class, 
 * we show on which days 
 * the student should attend certain subjects
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
    
    public void addSubject(Subject subject, Date date)
    {
    	timeTable.put(subject, date);
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
	
	public String toString() {
		return timeTable.toString();
	}
	
	
}
