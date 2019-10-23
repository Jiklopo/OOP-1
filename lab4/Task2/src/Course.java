
public class Course {
	private String courseName;
	private Textbook textbook;
	private Instructor instructor;
	
	public Course()
	{
		courseName = null;
		textbook = new Textbook();
		instructor = new Instructor();
	}
	
	public Course(String courseName)
	{
		this();
		this.courseName = courseName;
	}
	public Course(String courseName, Textbook textbook, Instructor instructor)
	{
		this.courseName= courseName;
		this.textbook = textbook;
		this.instructor = instructor;
	}
	
	public Textbook getTextbook()
	{
		return textbook;
	}
	
	public Instructor getInstructor()
	{
		return instructor;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setTextbook(Textbook textbook)
	{
		this.textbook = textbook;
	}
	
	public void setInstructor(Instructor instructor)
	{
		this.instructor = instructor;
	}
	
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	
	public String toString()
	{
		return courseName + "\n" + instructor + "\n" + textbook;
	}
	
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		if(this.getClass() != o.getClass())
			return false;
		
		return this.toString().equals(o.toString());
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((instructor == null) ? 0 : instructor.hashCode());
		result = prime * result + ((textbook == null) ? 0 : textbook.hashCode());
		return result;
	}
}
