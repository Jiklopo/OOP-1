/*Manager class, which extends from Employee, is used create and assign managers' objectives*/
package users;

import java.util.*;
import java.io.*;

import universityStuff.*;


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

	public boolean createNews(String header, String text) {
        return false;
    }
	
	

	/*deleteNews method deletes news*/
    public void deleteNews(int newsId) {
    	News.deleteNews(null);
    }

    /*deleteNews method deletes news*/
    public void deleteNews(News news) {
    	News.deleteNews(null);
    }

    /*assignCourse method creates the course, here we are adding a teachers and the courses*/
    public void assignCourse(Teacher teacher, Course course) {
    	teacher.c
    }

    
    public void createCourse(String code, String name, String description, Faculties faculty)) {
    	Course c = new Course(code, name, description, faculty);
    }

    
    public void deleteCourse(Course course) {
    	Course.removeCourse(course);
    	course = null;
    }
/*assignCourse method creates the course, here we are adding a students and the subjects*/
        public void assignSubject(Student student, Subject subject) {
        	student.getCurrentSubjects().put(subject, new Mark());
        	subject.getStudents().add(student);
        	
    }
/*confirmTimetable method acknowledges time table for the students via getter*/
        public void confirmTimeTable(Student student, TimeTable timeTable) {
        	for(Student s: student) {
        		for(TimeTable sub:timeTable) {
        			if(student.getName()==s.Name)
        				s.confirmTimeTable(timeTable);
    		}
    	}

    }

        public TimeTable createTimeTable() {
        return null;
    }
}

