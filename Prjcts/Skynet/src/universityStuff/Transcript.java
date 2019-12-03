package universityStuff;

import java.util.*;

/**
 */
public class Transcript implements Serializable, Comparable{
	
	public Transcript() {
		marks = new HashMap<Subject, Mark>();
	}
	
	public Transcript() {
		
	}
	
    /**
     */
    private HashMap<Subject, Mark> marks;

    /**
     * @param marks 
     * @return 
     */
    public boolean writeTranscript(Map marks) {
        return false;
    }
    
    public boolean equals(Object o) {
    	Transcript t = (Transcript) o;
    	if(this == t) return true;
    	
    	if(!(this instanceof t)) return false;
    	return this.marks.equals(t.marks);
    }
    
    public int compareTo(Object o) {
    	Transcript t = (Transcript) o;
    	if(subject != t.subject) return -1;
    	if(subject == t.subject)
    		return this.getCourse().getName().compareTo(t.getCourse().getName());
    }
    
    public int hashCode() {
    	int result = 37;
    	result = result + marks.hashCode();
    	result = result + writeTranscript.hashCode();
    }
}

