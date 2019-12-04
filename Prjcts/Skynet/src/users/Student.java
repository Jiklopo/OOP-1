package users;


import java.util.*;

import universityStuff.*;
/**
 */
public class Student extends User {
	
	public Student(Faculties faculty) {
		this.faculty = faculty;
		transcript = new Transcript();
		journal = new HashMap<Subject, AttendanceJournal>();
		timeTable = new TimeTable();
	}

	public Student(String password, String firstName, String lastName, String phoneNumber, Faculties faculty) {
		super(password, firstName, lastName, phoneNumber);
		this.faculty = faculty;
	}
	
	private Faculties faculty;
	
	public Faculties getFaculty() {
		return faculty;
	}

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
	
	public String toString() {
		return "Faculty: " + getFaculty() + "; " + "Year of study: " + getYear();
	}
	
	/**In the Student class we store student data:
	 * faculty, 
	 * year of study, 
	 * subjects that student have
	 * transcript, 
	 * student journal, 
	 * time table
	 */
}