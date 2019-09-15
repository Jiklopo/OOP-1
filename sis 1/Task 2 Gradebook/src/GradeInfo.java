import student.Student;

public class GradeInfo {
	private Student student;
	private double grade;
	
	
	GradeInfo(){
		student = new Student();
	}	
	GradeInfo(String name, double grade){
		student = new Student(name);
		setGrade(grade);
	}
	GradeInfo(String name, String id){
		student = new Student(name, id);
	}
	
	GradeInfo(String name, String id, double grade){
		this(name, id);
		setGrade(grade);
	}
	
	public void setGrade(double grade) {
		if (grade > 0 && grade <= 4)
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
		return student.name + ": " + grade;
	}
}
