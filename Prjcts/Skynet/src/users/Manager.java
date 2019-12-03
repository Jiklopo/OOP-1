package users;
import java.util.Collections;
import java.util.Vector;

import universityStuff.*;
/**
 */
public class Manager extends Employee {
	public Manager() {}
	
	public Manager(String password, String firstName, String lastName, String phoneNumber) 
	{
		super(password, firstName, lastName, phoneNumber);
	}
	
	public static Vector<Manager> getAllManagers()
	{
		Vector<Manager> res = new Vector<Manager>();
		for(User u: allUsers.keySet())
		{
			if(u instanceof Manager)
				res.add((Manager)u);
		}
		Collections.sort(res);
		return res;
	}
	
	/**
	 * @param header 
	 * @param text 
	 * @return 
	 */
	public boolean createNews(String header, String text) {
		return false;
	}
	/**
	 * @param newsId 
	 */
	public void deleteNews(int newsId) {
	}
	/**
	 * @param news 
	 */
	public void deleteNews(News news) {
	}
	/**
	 * @param teacher 
	 * @param course 
	 */
	public void assignCourse(Teacher teacher, Course course) {
	}
	/**
	 * @return 
	 */
	public boolean createCourse() {
		return false;
	}
	/**
	 * @return 
	 */
	public boolean deleteCourse() {
		return false;
	}
	/**
	 * @param student 
	 * @param subject 
	 */
	public void assignCourse(Student student, Subject subject) {
	}
	/**
	 * @param student 
	 * @param timeTable 
	 */
	public void confirmTimeTable(Student student, TimeTable timeTable) {
	}
	/**
	 * @return 
	 */
	public TimeTable createTimeTable() {
		return null;
	}
}

