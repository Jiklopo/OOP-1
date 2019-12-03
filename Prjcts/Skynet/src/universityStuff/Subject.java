package universityStuff;

import java.util.HashSet;
import users.Student;

public class Subject implements Comparable {
	//fields
	private Course course;
	private int year;
	private int semester;
	private HashSet<Student> students;
	
	//constructors
	public Subject() {

	}
	public Subject(Course course, int year, int semester) {
		this.course=course;
		this.year=year;
		this.semester=semester;
	}

	
	public Course getCourse() {
		return course;
	}
	public int getYear() {
		return year;
	}
	public int getSemester() {
		return semester;
	}
	public HashSet<Student> getStudents() {
		return students;
	}
	//compare / equals/hashcode/toString
	public int compareTo(Object o) {
		Subject s = (Subject)o;
		if(year == s.year)
			return semester - s.semester;
		return year - s.year;
	}


	public boolean equals(Object o) {
		if (o == this) return true;
		if(!(o instanceof Subject)) return false;
		Subject s = (Subject) o;
		return course.equals(s.course)
				&& semester == s.semester 
				&& year == s.year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + semester;
		result = prime * result + year;
		return result;
	}


	public String toString() {
		return this.course + " " + this.year + " " + this.semester;
	}
}

