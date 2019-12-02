package gradeBook;

public class Course {
	public String name, description;
	public int credits;//
	public Course[] prerequisites;
	
		
	public Course() {
		name = "";
		description = "";
		credits = 0;
	}
	
	public Course(String name) {
		this.name = name;
	}
	
	public Course(String name, String description) {
		this(name);
		this.description = description;
	}
	
	public Course(String name, String description, int credits) {
		this(name, description);
		this.credits = credits;
	}
	
	public Course(String name, String description, int credits, Course[] prerequisites) {
		this(name, description, credits);
		this.prerequisites = prerequisites;
	}
	
	
	
	public String toString() {
		return name + "\n" + description;
	}
}
