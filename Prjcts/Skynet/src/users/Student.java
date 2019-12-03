package users;


import java.util.*;

import universityStuff.*;
/**
 */
public class Student extends User {
	/**
	 */
	private Transcript transcript;
	/**
	 */
	private HashMap<Subject, AttendanceJournal> journal;
	/**
	 */
	private int year;
	/**
	 */
	private TimeTable timeTable;
	/**
	 */
	public static final Comparator<Student> COMPARE_BY_YEAR = Comparator.comparing(Student::getYear);
	/**
	 */
	private HashMap<Subject, Mark> currentSubjects;
	
	public Student() {}
	
	public Student(String password, String firstName, String lastName, String phoneNumber) {
		super(password, firstName, lastName, phoneNumber);
		transcript = new Transcript();
		journal = new HashMap<Subject, AttendanceJournal>();
		timeTable = new TimeTable();
	}
	
	public static Vector<Student> getAllStudents()
	{
		Vector<Student> res = new Vector<Student>();
		for(User u: allUsers.keySet())
		{
			if(u instanceof Student)
				res.add((Student)u);
		}
		Collections.sort(res);
		return res;
	}
	
	/**
	 */
	public void receiveMark(float grade, String attestationPeriod) {
	}
	public Transcript getTranscript() {
		return transcript;
	}

	public HashMap<Subject, AttendanceJournal> getJournal() {
		return journal;
	}

	public int getYear() {
		return year;
	}

	public TimeTable getTimeTable() {
		return timeTable;
	}

	public HashMap<Subject, Mark> getCurrentSubjects() {
		return currentSubjects;
	}

	/**
	 * @param attendance 
	 * @param date 
	 * @param subject 
	 */
	public void receiveAttendence(Subject subject, Date date, boolean attendance) {
		journal.get(subject).markAttendance(date, attendance);
	}

	public int hashCode() {
		int result = super.hashCode();
		result = result * 37 + transcript.hashCode();
		result = result * 37 + journal.hashCode();
		result = result * 37 + year;
		result = result * 37 + timeTable.hashCode();
		result = result * 37 + currentSubjects.hashCode();
		return result;
	}
	
	
}