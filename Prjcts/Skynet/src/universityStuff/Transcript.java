package universityStuff;

import java.util.*;
import java.io.*;


/**
 */
public class Transcript implements Serializable{
	
	public Transcript() {
		marks = new HashMap<Subject, Mark>();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marks == null) ? 0 : marks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transcript t = (Transcript) obj;
		return marks.equals(t.marks);
	}
    
    public String toString() {
    	return marks.toString();
    }
    
    /**In the Transcript class, 
     * a student can find out 
     * what grades in subjects he has
     */
}
