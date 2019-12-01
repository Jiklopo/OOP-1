package universityStuff;
import java.util.*;
import universityStuff.*;
import users.*;
import java.io.*;
public class CourseFile {
	//fields
private String path;
private Teacher owner;
private Course course;
private static HashSet<CourseFile> allFiles;
//constructor
public CourseFile(String path, Teacher owner, Course course) {
	this.path=path;
	this.owner=owner;
	this.course=course;
}
//get/set
public String getPath() { return this.path; }
public void setPath(String path) { this.path=path; }
public Teacher getOwner() { return this.owner; }
public void setOwner(Teacher anotherTeacher) { this.owner = anotherTeacher; }
public Course getCourse() { return this.course; }
public void setCourse(Course anotherCourse) { this.course = anotherCourse; }

public static void serialize(HashSet<CourseFile> allFiles) throws IOException{
	FileOutputStream fos = new FileOutputStream("courseFiles.out");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(allFiles);
	oos.flush();
	oos.close();
}
public void deserialize() throws IOException, ClassNotFoundException {
	FileInputStream fis = new FileInputStream("courseFiles.out");
	ObjectInputStream ois = new ObjectInputStream(fis);
	HashSet<CourseFile> allFiles = (HashSet<CourseFile>)ois.readObject();
	ois.close();
}
//equals/hashCode/toString
public boolean equals(Object o) {
  if (o == this) return true;
  if(!(o instanceof CourseFile)) return false;
  CourseFile c = (CourseFile) o;
  return (this.path.equals(c.path) && this.course.equals(c.course) && this.owner.equals(c.owner);
}
public int hashCode() {
	 int res = 12;
   res = 11 * res + path.hashCode();
   return res;
}

public String toString(){
	return this.course + " " + this.owner + " " + this.path;
 }
}


