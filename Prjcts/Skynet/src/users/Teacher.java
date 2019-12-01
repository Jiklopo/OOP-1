package users;
import java.util.*;
import java.lang.*;
import universityStuff.*;
public class Teacher extends Employee {
	//fields
private HashSet<Course> courses;
private HashSet<Subject> subjects;

private HashSet<Student> students;
private String name;
private String surname;
private String faculty;


public Teacher(String password, String firstName, String lastName, String phoneNumber) {
	super(password, firstName, lastName, phoneNumber);
}
//get/set
public String getName() { return this.name; }
public String getSurname() { return this.surname; }
public String getFaculty() { return this.faculty; }
public void setFaculty(String faculty) { this.faculty = faculty; }

//methods
public void putMark(Subject subject, Student student, float grade, String attestationPeriod) {
	
	for(Course c:courses) {
		for(Subject sub:subjects) {
		   for(Student s:students) {
			if(student.getName()== s.Name) {
				Mark m = new Mark(firstAttestation, secondAttestation, finalGrade);
				if(attestationPeriod.equals("First attestation")) {
					m.setFirstAttestation(grade);
				}
				else if(attestationPeriod.equals("SecondAttestation")) {
					m.setSecondAttestation(grade);
				}
				else if(attestationPeriod.equals("Final")) {
					m.setFinalGrade(grade);
				}
			}
		}
	}
}
}
public void markAttendance(Subject subject, Student student, Date date, boolean attendance) {
	for(Student s: students) {
		for(Subject sub:subjects) {
			if(student.getName()==s.Name)
				s.markAttendance(date,attendance);
		}
	}
	
}
public void addCourseFile(CourseFile file) {
	courses.add(file);
}

public String viewStudentInfo() {
	String res = "";
	for(Student s: students) {
		res += s.toString() + "\n";
	}
	return res;
}
public void viewCourses(){
    int i = 1;
    for(Course c : courses){
        System.out.println(i + "." + c);
        i++;
    }
}

//equals/hashcode/toString
public boolean equals(Object obj) { 
	return super.equals(obj);
}

public int hashCode() { 
	return super.hashCode(); 
	}
}

public String toString() {
	return " Teacher: " + this.surname + " " + this.name + " " +this.faculty + "\""
			+ "Courses:" + this.courses + " " + "subjects" + this.subjects;
}
}

