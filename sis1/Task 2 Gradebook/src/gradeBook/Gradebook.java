package gradeBook;

import java.util.ArrayList;

public class Gradebook {
	private ArrayList<GradeInfo> gradeInfos;
	private Course course;
	private double sum;
	private GradeInfo max, min;
	
	
	{
		max = new GradeInfo();
		min = new GradeInfo();
		sum = 0;
	}
	
	public Gradebook() {
		gradeInfos = new ArrayList<GradeInfo>();
		course = new Course();
	}
	
	public Gradebook(Course course) {
		gradeInfos = new ArrayList<GradeInfo>();
		this.course = course;
	}
	
	public Gradebook(Course course, GradeInfo gradeInfo) {
		this(course);
		add(gradeInfo);
	}
	
	
	
	public String displayMessage() {
		return "Welcome to the best grade application for "
				+ course.name + "! Type stop into the student name field to stop.";
	}
	
	public boolean add(GradeInfo gradeInfo) {
		double grade = gradeInfo.getGrade();
		sum += grade;
		if(grade > max.getGrade())
			max = gradeInfo;
		if(grade < min.getGrade())
			min = gradeInfo;
		return gradeInfos.add(gradeInfo);
	}
	
	public boolean add(String studentName, double grade) {
		return add(new GradeInfo(studentName, grade));
	}
	
	public String getReport() {
		return "Class average is " + getAvg() +
				".\nBest student is " + getBest() +
				".\nUnluckiest student is " + getUnluckiest();
	}
	
	public double getAvg() {
		return sum / gradeInfos.size();
	}
	
	public GradeInfo getBest() {
		return max;
	}
	
	public GradeInfo getUnluckiest() {
		return min;
	}
	
	public String getGradeStats() {
		int low = 0;
		int high = 9;
		String gradeStats = "";
		for(int i = 0; i < 10; i++) {
			gradeStats += low + "-" + high + ": " + countGrades(low, high);
			low += 10;
			high += 10;
			gradeStats += "\n";
		}
		gradeStats += "100: " + countGrades(100, 100);
		return gradeStats;
	}
	
	private int countGrades(int a, int b) {
		int cnt = 0;
		for(GradeInfo gr: gradeInfos) {
			if(gr.getGrade() <= b && gr.getGrade() >= a)
				cnt++;
		}
		return cnt;
	}
	
	public String getNewMarks()
	{
		String res = "";
		GradeInfo best = getBest();
		for(GradeInfo gi: gradeInfos)
		{
			gi.analyzeMark(best.getGrade());
			res += gi.toString() + "\n";
		}
		return res;
	}
	
	public String toString() {
		return course.name;
	}
	
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass())
			return false;
		Gradebook gr = (Gradebook)o;
		if(course.name == gr.course.name)
			return true;
		return false;
	}
}
