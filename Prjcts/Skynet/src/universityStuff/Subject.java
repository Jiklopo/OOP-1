/**
 * Subject is what you study, so it has semester, year and set of Students
*/
package universityStuff;
import users.*;
import java.util.*;
import java.io.*;
public class Subject implements Comparable, Serializable{
	//fields
private Course course;
private int year;
private int semester;
private HashSet<Student> students;
private HashSet<CourseFile> courseFiles;

//constructors
public Subject() {
	
}
public Subject(Course course, int year, int semester) {
	this.course=course;
	this.year=year;
	this.semester=semester;
}
/**
 * accessors and mutators for fields
*/
public Course getCourse() { return this.course; }
public int getYear() { return this.year; }
public int getSemester() { return this.semester; }
public HashSet<Student> getStudents() {
	return students;
}
/**
 * @param courseFile
 * adds courseFile to set of files
*/
public boolean addFile(CourseFile courseFile) {
	return courseFiles.add(courseFile); 
}
/**
 * @param courseFile
 * removes courseFile from set of files
*/
public boolean deleteFile(CourseFile courseFile) {
    return courseFiles.remove(courseFile);
}
/**
 * compares subjects by semester and year
*/
public int compareTo(Object o) {
	Subject s = (Subject)o;
	if(year == s.year)
		return semester - s.semester;
	return year - s.year;
}
/**
 * checking for equality based on subject's semester and year
*/
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
/**
 * shows information about subject including its course, year and semester
*/
public String toString() {
	return this.course + " " + this.year + " " + this.semester;
}
}

