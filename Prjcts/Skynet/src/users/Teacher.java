package users;

import java.lang.*;
import java.util.*;
import universityStuff.*;

/**
 */
public class Teacher extends Employee {
    /**
     */
    private HashSet<Course> courses;

    /**
     */
    private HashSet<Subject> subjects;

    /**
     * @param student 
     * @param subject 
     * @param grade 
     * @param attestationPeriod 
     */
    public void putMark(Subject subject, Student student, float grade, String attestationPeriod) {
    }

    /**
     * @param date 
     * @param student 
     * @param subject 
     * @param attendance 
     */
    public void markAttendance(Subject subject, Student student, Date date, boolean attendance) {
    }

    /**
     * @param file 
     * @return 
     */
    public boolean addCourseFile(File file) {
        return false;
    }

    /**
     * @return 
     */
    public String viewStudentInfo() {
        return null;
    }
}

