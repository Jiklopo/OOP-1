/**
 * Course class is the course that student chooses when registering for disciplines
 *  Here you can get information about course as code, name, prerequisites etc.
 *  also add teacher to specific course or remove etc.
*/
package universityStuff;
import users.*;
import java.io.*;
import java.util.*;
public class Course implements Comparable, Serializable { 
	//fields
public static HashSet<Course> allCourses; 
private String code; 
private String name; 
private String description; 
private HashSet<Teacher> teachers; 
private HashSet<Course> prerequisites;
private HashSet<CourseFile> courseFiles;
private Faculties faculty;
//constructors
public Course() {
	
}
public Course(String code, String name, String description, Faculties faculty) {
	this.code=code;
	this.name=name;
	this.description=description;
	this.faculty= faculty;
	allCourses.add(this);
}
/**
 * accessors and mutators for fields.
*/
public String getCode() {  return this.code; }
public void setCode(String code) { this.code=code; }
public String getName() { return this.name; }
public void setName(String name) { this.name= name; }
public String getDescription() { return this.description; }
public void setDescription(String description) { this.description= description; }
public Faculties getFaculty() { return this.faculty; }
public void setFaculty(Faculties faculty) { this.faculty = faculty; }
public HashSet<Teacher> getTeachers() {  return this.teachers; }
public HashSet<Course> getPrerequisites() { return this.prerequisites; }

/**
 * adds to HashSet<Course> prerequisites courses;
*/
public void addPrerequisite(Course c) {
    this.prerequisites.add(c);
}
/**
 * adds teacher to HashSet<Teacher> teachers, so duplicate teacher wouldn't be added.
*/
public boolean addTeacher(Teacher teacher) 
{
	return teachers.add(teacher);
}
/**
 * removes from set the given teacher
*/
public boolean removeTeacher (Teacher teacher){
	return teachers.remove(teacher);
}
/**
 * @param path
 * @throws IOException 
 * @throws FileNotFoundException 
*/
public static void serialize(String path) throws IOException, FileNotFoundException {
	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "allCourses.out"));
	oos.writeObject(allCourses);
	oos.flush();
	oos.close();
}
/**
 * @param path
 * @throws IOException , FileNotFoundException , ClassNotFoundException
*/
public static void deserialize(String path) throws IOException, ClassNotFoundException, FileNotFoundException {
	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+"courses.out"));
	allCourses = (HashSet<Course>)ois.readObject();
	ois.close();
}

public static boolean removeCourse(Course course)
{
	if(course == null)
		return false;
	return allCourses.remove(course);
}

/**
 * checking for equality of courses based on their codes
*/
public boolean equals(Object o) {
    if (o == this) return true;
    if(!(o instanceof Course)) return false;
    Course c = (Course) o;
    return this.code.equals(c.code);
}
public int hashCode() {
	 int res = 1;
    res = 31 * res + code.hashCode();
    return res;
}

/**
 * @param object
 * compares by name of the courses
*/
public int compareTo(Object obj) {
	Course c = (Course)obj;
	return name.compareTo(c.name);
}
/**
 * shows basic information about Course
*/
public String toString() {
	return "Course is: " + this.name + "\n"
			+ "code is: " + this.code+ "\n"
					+ "prerequisites are: " + this.prerequisites + "\n"
							+ "description: "  + this.description + "\n"
									+ "faculty: " + this.faculty;
   }
}

