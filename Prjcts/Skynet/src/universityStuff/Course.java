package universityStuff;
import java.io.*;
import java.util.*;
import users.*;
public class Course implements Comparable, Serializable { 
	//fields
public static HashSet<Course> allCourses; 
private String code; 
private String name; 
private String description; 
private Vector<Teacher> teachers; 
private HashSet<Course> prerequisites;
private HashSet<CourseFile> courseFiles;
//constructors
public Course(String code, String name, String description) {
	this.code=code;
	this.name=name;
	this.description=description;
}
//get/set
public String getCode() {  return this.code; }
public void setCode(String code) { this.code=code; }
public String getName() { return this.name; }
public void setName(String name) { this.name= name; }
public String getDescription() { return this.description; }
public void setDescription(String description) { this.description= description; }
public Vector<Teacher> getTeachers() {  return this.teachers; }
public void addTeacher(Teacher teacher) { teachers.add(teacher); }
public void removeTeacher(Teacher teacher) {  teachers.remove(teacher); }
public HashSet<Course> getPrerequisites() { return this.prerequisites; }

public void addPrerequisite(Course c) {
    this.prerequisites.add(c);
}

public void addFile(CourseFile courseFile) 
{
	courseFiles.add(courseFile); 
}
public void deleteFile (CourseFile courseFile) throws IOException{
	courseFiles.remove(courseFile);
}

public static void serialize(HashSet<Course> allCourses) throws IOException {
	FileOutputStream fos = new FileOutputStream("courses.out");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(allCourses);
	oos.flush();
	oos.close();
}
public HashSet<Course> deserialize() throws IOException, ClassNotFoundException {
	FileInputStream fis = new FileInputStream("courses.out");
	ObjectInputStream ois = new ObjectInputStream(fis);
	HashSet<Course> allCourses = (HashSet<Course>)ois.readObject();
	ois.close();
	return allCourses;
}
//equals/hashCode/compare/toString
public boolean equals(Object o) {
    if (o == this) return true;
    if(!(o instanceof Course)) return false;
    Course c = (Course) o;
    return code.equals(c.code);
}
public int hashCode() {
	 int res = 1;
     res = 31 * res + code.hashCode();
     return res;
}
public int compareTo(Object o) {
	Course c = (Course)o;
	return name.compareTo(c.name);
}
public String viewCourseInfo() {
	return "Course is: " + this.name + "\n"
			+ "code is: " + this.code+ "\n"
					+ "prerequisites are: " + this.prerequisites + "\n"
							+ "description: "  + this.description;
   }
}

