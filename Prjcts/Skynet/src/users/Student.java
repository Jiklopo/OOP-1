package users;
import universityStuff.*;
import java.util.*;;
/**
 */
public class Student extends User {
	

	public Student(String password, String firstName, String lastName, String phoneNumber) {
		super(password, firstName, lastName, phoneNumber);
	}
	/**
	 */
	private Transcript transcript;
	/**
	 */
	private AttendanceJournal journal;
	/**
	 */
	private int year;
	/**
	 */
	private TimeTable timeTable;
	/**
	 */
	public Comparator<User> COMPARE_BY_YEAR;
	/**
	 */
	private HashMap<Subject, Mark> currentSubjects;
	/**
	 */
	private static Vector<boolean> createdIDs;
	/**
	 * @param grade 
	 * @param attestationPeriod 
	 */
	public void receiveMark(float grade, String attestationPeriod) {
	}
	/**
	 */
	public void receiveAttendence() {
	}
	/**
	 */
	public static void serializeIDs() {
	}
	/**
	 * @return 
	 */
	public void throws IOException deserializeIDs() {
		return null;
	}
}

