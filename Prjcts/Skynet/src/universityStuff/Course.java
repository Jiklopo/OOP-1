package universityStuff;
import java.lang.*;
import HashSet<Users.User>;
/**
*/
public class Course implements Comparable {
/**
*/
public static HashSet<Course> allCourses;
/**
*/
private String code;
/**
*/
private String name;
/**
*/
private String description;
/**
*/
private Vector<Teacher> teachers;
/**
 * @param teacher 
 * @return 
*/
public boolean addTeacher(Teacher teacher) {
    return false;
}
/**
 * @param teacher 
 * @return 
*/
public boolean removeTeacher(Teacher teacher) {
    return false;
}
/**
 * @return 
*/
public String getCode() {
    return null;
}
/**
 * @return 
*/
public String getName() {
    return null;
}
/**
 * @param name 
*/
public void setName(String name) {
}
/**
 * @return 
*/
public String getDescription() {
    return null;
}
/**
 * @param description 
*/
public void setDescription(String description) {
}
/**
 * @return 
*/
public Vector<Teacher> getTeachers() {
    return null;
}
/**
*/
public static void serialize() {
}
/**
*/
public static void deserialize() {
}
}

