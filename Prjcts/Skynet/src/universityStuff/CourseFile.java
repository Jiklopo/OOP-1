/**
 * every Course has CourseFiles, so this class contains path for coursefile, its owner and for which course this file belongs
*/
package universityStuff;
import users.*;
import universityStuff.*;
import java.io.*;
import java.util.*;
public class CourseFile implements Serializable {
	//fields
private String path;
private Teacher owner;
private Course course;
private static HashSet<CourseFile> allFiles;
//constructors
public CourseFile() {
	
}
public CourseFile(String path, Teacher owner, Course course) {
	this.path=path;
	this.owner=owner;
	this.course=course;
}
/**
 * accessors and mutators for fields.
*/
public String getPath() { return this.path; }
public Teacher getOwner() { return this.owner; }
public Course getCourse() { return this.course; }

/**
 * @param path
 * @throws IOException 
 * @throws FileNotFoundException 
*/
public static void serialize(String path) throws IOException, FileNotFoundException {
	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
	oos.writeObject(allFiles);
	oos.flush();
	oos.close();
}
/**
 * @param path
 * @throws IOException , FileNotFoundException , ClassNotFoundException
*/
public static void deserialize(String path) throws IOException, ClassNotFoundException, FileNotFoundException {
	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
	allFiles = (HashSet<CourseFile>)ois.readObject();
	ois.close();
}

/**
 * checking for equality of coursefiles based on their path, course and owner
*/
public boolean equals(Object o) {
  if (o == this) return true;
  if(!(o instanceof CourseFile)) return false;
  CourseFile c = (CourseFile) o;
  return (this.path.equals(c.path) && this.course.equals(c.course) && this.owner.equals(c.owner));
}
public int hashCode() {
	 int res = 12;
  res = 11 * res + path.hashCode();
  return res;
}
/**
 * shows information about CourseFile
*/
public String toString(){
	return this.course + " " + this.owner + " " + this.path;
 }
}


