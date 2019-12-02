package gradeBook;

import student.Student;

public class GradeInfo {
	private Student student;
	private double grade;
	private char mark;
	
	//
	GradeInfo()
	{
		student = new Student();
		grade = 100;
		mark = 'A';
	}	
	GradeInfo(String name, double grade){
		student = new Student(name);
		setGrade(grade);
		analyzeMark(100);
	}
	GradeInfo(String name, String id){
		student = new Student(name, id);
	}
	
	GradeInfo(String name, String id, double grade){
		this(name, id);
		setGrade(grade);
	}
	
	public void setGrade(double grade) {
		if (grade > 0 && grade <= 100)
			this.grade = grade;
		else this.grade = 0;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public String toString() {
		return student.name + " - " + mark;
	}
	
	public void analyzeMark(double max)
	{
		if (max - grade <= 10)
			mark = 'A';
		else if (max - grade <= 20)
			mark = 'B';
		else if (max - grade <= 30)
			mark = 'C';
		else if (max - grade <= 40)
			mark = 'D';
		else mark = 'F';
	}
}
