package universityStuff;
import java.io.*;
import java.util.*;
import users.*;
public class Course implements Comparable, Serializable {
	
	public static HashSet<Course> allCourses;
	private String code; 
	private String name; 
	private String description; 
	private Vector<Teacher> teachers; 
	private HashSet<Course> prerequisites;
	private HashSet<CourseFile> courseFiles;

	
	public Course(String code, String name, String description) {
		this.code=code;
		this.name=name;
		this.description=description;
	}

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

	public static void serialize(String path) throws IOException {
		FileOutputStream fos = new FileOutputStream(path + "allCourses.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(allCourses);
		oos.close();
	}
	
	public static void deserialize(String path) throws IOException, ClassNotFoundException {
		ObjectInputStream o = new ObjectInputStream(new FileInputStream(path + "courses.out"));
		allCourses = (HashSet<Course>)o.readObject();
		o.close();
	}
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Vector<Teacher> getTeachers() {
		return teachers;
	}


	public HashSet<Course> getPrerequisites() {
		return prerequisites;
	}


	public HashSet<CourseFile> getCourseFiles() {
		return courseFiles;
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

