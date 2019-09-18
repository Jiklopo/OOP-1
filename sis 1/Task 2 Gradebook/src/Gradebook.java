import java.util.ArrayList;

public class Gradebook {
	public ArrayList<GradeInfo> gradeInfos;
	private Course course;
	
	
	
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
		gradeInfos.add(gradeInfo);
	}
	
	
	
	public String displayMessage() {
		return "Welcome to the best grade application for "
				+ course.name + "! Type stop into the student name field to stop.";
	}
	
	public boolean addGradeInfo(GradeInfo gradeInfo) {
		return gradeInfos.add(gradeInfo);
	}
	
	public boolean addGradeInfo(String studentName, double grade) {
		return gradeInfos.add(new GradeInfo(studentName, grade));
	}
	
	public String getReport() {
		return "Class average is " + getAvg() +
				".\nUnluckiest student is " + getUnluckiest() +
				".\nBest student is " + getBest() +
				".\n" + getGradeStats();
	}
	
	private double getAvg() {
		double avg = 0;
		for(GradeInfo gi: gradeInfos) {
			avg += gi.getGrade();
		}
		return avg/gradeInfos.size();
	}
	
	private GradeInfo getBest() {
		GradeInfo best = gradeInfos.get(0);
		for(GradeInfo gi: gradeInfos) {
			if(gi.getGrade() > best.getGrade())
				best = gi;
		}
		return best;
	}
	
	private GradeInfo getUnluckiest() {
		GradeInfo unluckiest = gradeInfos.get(0);
		for(GradeInfo gi: gradeInfos) {
			if(gi.getGrade() < unluckiest.getGrade())
				unluckiest = gi;
		}
		return unluckiest;
	}
	
	private String getGradeStats() {
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
	public String toString() {
		return course.name;
	}
}
