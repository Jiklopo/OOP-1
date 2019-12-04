package universityStuff;

import java.io.*;
/**
 */
public class Mark implements Serializable, Comparable {
	
	public Mark(String mark, float firstAttestation, float secondAttestation, float finalGrade) {
		this.mark = "Undefined";
		this.firstAttestation = -1;
		this.secondAttestation = -1;
		this.finalGrade = -1;
	    // TODO Auto-generated constructor stub
	 }
	
	public Mark() {
			
	}
	
    /**
     */
    private String mark;

    /**
     */
    private float firstAttestation;

    /**
     */
    private float secondAttestation;

    /**
     */
    private float finalGrade;

    /**
     * @return 
     */

    
    
    
    public void calculateMark() {
    	if(getGrade() < 50) mark = "F";
    	else if(getGrade() >= 50 && getGrade() < 55) mark = "D";
    	else if(getGrade() >= 55 && getGrade() < 60) mark = "D+";
    	else if(getGrade() >= 60 && getGrade() < 65) mark = "C";
    	else if(getGrade() >= 65 && getGrade() < 70) mark = "C+";
    	else if(getGrade() >= 70 && getGrade() < 75) mark = "B-";
    	else if(getGrade() >= 75 && getGrade() < 80) mark = "B";
    	else if(getGrade() >= 80 && getGrade() < 85) mark = "B+";
    	else if(getGrade() >= 85 && getGrade() < 90) mark = "A-";
    	else if(getGrade() >= 90 && getGrade() < 95) mark = "A";
    	else if(getGrade() >= 95 && getGrade() <= 100) mark = "A+";
    }
    
    /**
     * @return 
     */
    public float getGrade() {
        return firstAttestation + secondAttestation + finalGrade;
    }    
    
    public float getFirstAttestation() {
		return firstAttestation;
	}

	public void setFirstAttestation(float firstAttestation) {
		this.firstAttestation = firstAttestation;
	}

	public float getSecondAttestation() {
		return secondAttestation;
	}

	public void setSecondAttestation(float secondAttestation) {
		this.secondAttestation = secondAttestation;
	}

	public float getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(float finalGrade) {
		this.finalGrade = finalGrade;
		calculateMark();
	}

	public String getMark() 
	{
		return mark;
	}
    
    public int compareTo(Object o) {
    	Mark m = (Mark) o;
    	return (int) (getGrade() - m.getGrade());
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(finalGrade);
		result = prime * result + Float.floatToIntBits(firstAttestation);
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + Float.floatToIntBits(secondAttestation);
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
		Mark other = (Mark) obj;
		return getGrade() == other.getGrade();
	}
	
	@Override
	public String toString() {
		return "First attestation: " + firstAttestation + "\n"
				+ "Second attestation: " + secondAttestation + "\n"
				+ "Final grade: " + finalGrade;
	}
	
	/**In the Mark class, 
	 * a student can find out his points 
	 * for the first and second grades, 
	 * points for the final exam 
	 * and the final grade(the sum of points for both grades and the final exam)
	 */
}
