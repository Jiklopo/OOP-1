package users;
import java.util.*;
import java.lang.*;
import universityStuff.*;
public class Teacher extends Employee {
	//fields
	private HashSet<Course> courses;
	private Faculties faculty;


	public Teacher(String password, String firstName, String lastName, String phoneNumber, Faculties faculty) {
		super(password, firstName, lastName, phoneNumber);
		this.faculty = faculty;
	}

	public String getFaculty() { return this.faculty.toString();}
	public void setFaculty(Faculties faculty) { this.faculty = faculty; }

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

	//methods
	public void putMark(Subject subject, Student student, float grade, String attestationPeriod) {
		student.receiveMark(grade, attestationPeriod);
	}


	public void markAttendance(Subject subject, Student student, Date date, boolean attendance) 
	{
		student.receiveAttendence(subject, date, attendance);		
	}

	public String viewStudentsInfo(Subject subject) {
		String res = "";
		for(Student s: subject.getStudents())
		{
			res += s + " " + s.getCurrentSubjects().get(subject) + "\n";
		}
		return res;
	}

	//equals/hashcode/toString
	public boolean equals(Object obj) { 
		return super.equals(obj);
	}

	public int hashCode() { 
		return super.hashCode(); 
	}


	public String toString() {
		return super.toString() + ", Teacher";
	}
}

