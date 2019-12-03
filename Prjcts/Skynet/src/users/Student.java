package users;


import java.util.*;

import universityStuff.*;
/**
 */
public class Student extends User {
	
	public Student() {
		transcript = new Transcript();
		journal = new AttendanceJournal();
		timeTable = new TimeTable();
	}

	public Student(String password, String firstName, String lastName, String phoneNumber) {
		super(password, firstName, lastName, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	/**
	 */
	private Transcript transcript;
	/**
	 */
	private AttendanceJournal journal;
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
	/**
	 */
	public void receiveMark(float grade, String attestationPeriod) {
	}
	/**
	 */
	public void receiveAttendence() {
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

	/**
	 * @return 
	 */
	public void throws IOException deserializeIDs() {
		return null;
	}
}