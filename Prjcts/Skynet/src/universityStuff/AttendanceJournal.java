package universityStuff;

import java.util.*;
import java.io.*;
import universityStuff.*;

/**
 */
public class AttendanceJournal implements Serializable, Comparable{

	public AttendanceJournal(Subject subject) {
		journal = new HashMap<Date, Boolean>();
		this.subject = subject;

		// TODO Auto-generated constructor stub
	}

	public AttendanceJournal() {}
	/**
	 */
	private Subject subject;

	/**
	 */
	private HashMap<Date, Boolean> journal;

	/**
	 * @param date 
	 * @param attendance 
	 */
	public void markAttendance(Date date, boolean attendance) {
		journal.put(date, attendance);
	}

	/**
	 * @param attendance 
	 */
	public void markTodaysAttendance(boolean attendance) {
	}

	public boolean equals(Object o) {
		AttendanceJournal j = (AttendanceJournal) o;
		if(this == j) return true;

		if(!(this instanceof AttendanceJournal)) return false;
		return this.subject.equals(j.subject);
	}

	public int compareTo(Object o) {
		AttendanceJournal aj = (AttendanceJournal) o;
		return this.subject.compareTo(aj.subject);
	}

	public int hashCode()
	{
		int result = 37;
		result = result * 37 + journal.hashCode();
		result = result * 37 + subject.hashCode();
		return result;
	}
	
	public String toString() {
		String res = "";
		for(Date d: journal.keySet())
		{
			String attended = journal.get(d)?"Attended":"Not Attended";
			res += d + ": " + attended;
		}
		return res;
	}
	
	/**In the AttendanceJournal class 
	 * we select the subject, 
	 * then we mark on which days 
	 * the student attended or did not attend classes
	 */
}