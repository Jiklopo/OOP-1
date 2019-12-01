package universityStuff;
import universityStuff.*;
import java.util.*;
import java.io.*;
public class Subject implements Comparable {
	//fields
private Course course;
private int year;
private int semester;
private HashSet<CourseFile> courseFiles;
//constructors
public Subject() {
	
}
public Subject(Course course, int year, int semester) {
	this.course=course;
	this.year=year;
	this.semester=semester;
}
//get/set
public Course getCourse() { return this.course; }
public void setCourse(Course course) { this.course=course; }
public int getYear() { return this.year; }
public void setYear(int year) { this.year = year; }
public int getSemester() { return this.semester; }
public void setSemester(int semester) { this.semester= semester; }
public HashSet<CourseFile> getCourseFiles() { return this.courseFiles; }

//methods
public void addFile(CourseFile courseFile) {
	courseFiles.add(courseFile); 
}
public void deleteFile (CourseFile courseFile) throws IOException{
    courseFiles.remove(courseFile);
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
	result = prime * result + ((courseFiles == null) ? 0 : courseFiles.hashCode());
	result = prime * result + semester;
	result = prime * result + year;
	return result;
}


public String toString() {
	return this.course + " " + this.year + " " + this.semester;
}
}

