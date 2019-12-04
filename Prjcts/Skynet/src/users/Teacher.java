/**
 * Teacher class is one of the users who can put marks and put attendance for students
 * and also can see courses and get information about certain teacher.
 */
package users;
import java.util.*;
import java.lang.*;
import universityStuff.*;
public class Teacher extends Employee{
	//fields
	private HashSet<Course> courses;
	private Faculties faculty;
	//constructors
	public Teacher() {

	}
	public Teacher(String password, String firstName, String lastName, String phoneNumber) {
		super(password, firstName, lastName, phoneNumber);
		this.faculty= faculty;
	}
	/**
	 * accessors and mutators for fields.
	 */
	public String getFaculty() { return this.faculty.toString(); }
	public void setFaculty(Faculties faculty) { this.faculty = faculty; }
	public HashSet<Course> getCourses()
	{
		return courses;
	}
	public static Vector<Teacher> getAllTeachers()
	{
		Vector<Teacher> res = new Vector<Teacher>();
		for(User u: allUsers.keySet())
		{
			if(u instanceof Teacher)
				res.add((Teacher)u);
		}
		Collections.sort(res);
		return res;
	}

	/**
	 * @param subject
	 * @param student
	 * @param grade
	 * @param attestationPeriod
	 * puts certain mark for student for given attestation period
	 */
	public void putMark(Subject subject, Student student, float grade, String attestationPeriod) {
		student.receiveMark(grade, attestationPeriod);
	}
	/**
	 * @param subject
	 * @param student
	 * @param date
	 * @param attendance
	 * puts attendance for student on certain date and subject
	 */

	public void markAttendance(Subject subject, Student student, Date date, boolean attendance) 
	{
		student.receiveAttendence(subject, date, attendance);		
	}
	/**
	 * @param subject
	 * shows information about student
	 */
	public String viewStudentsInfo(Subject subject) {
		String res = "";
		for(Student s: subject.getStudents())
		{
			res += s + " " + s.getCurrentSubjects().get(subject) + "\n";
		}
		return res;
	}
	/**
	 * displays content of HashSet<Course> courses
	 */
	public void viewCourses(){
		int i = 1;
		for(Course c : courses){
			System.out.println(i + "." + c);
			i++;
		}
	}

	/**
	 * overrides hashcode method of User
	 */
	public boolean equals(Object obj) { 
		return super.equals(obj);
	}

	public int hashCode() { 
		return super.hashCode(); 
	}
	/**
	 * displays information about Teacher
	 */
	public String toString() {
		return super.toString() + ", Teacher";
	}
}




