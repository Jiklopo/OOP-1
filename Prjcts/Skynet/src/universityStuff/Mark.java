package universityStuff;

/**
 */
public class Mark implements Serializable, Comparable {
	
	public Mark(char mark, float firstAttestation, float secondAttestation, float finalGrade) {
		this.mark = 'U';
		this.firstAttestation = 0;
		this.secondAttestation = 0;
		this.finalGrade = 0;
	    // TODO Auto-generated constructor stub
	 }
	
	public Mark() {
			
	}
	
    /**
     */
    private char mark;

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
    public String getMark() {
        return mark;
    }

    /**
     * @return 
     */
    public float getGrade() {
        return firstAttestation + secondAttestation + finalGrade;
    }
    
    
    private void calculateMark() {
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
     * @param firstAttestation 
     */
    public void setFirstAttestation(float firstAttestation) {
    }

    /**
     * @param secondAttestation 
     */
    public void setSecondAttestation(float secondAttestation) {
    }

    /**
     * @param finalGrade 
     */
    public void setFinalGrade(float finalGrade) {
    }
    
    public boolean equals(Object o) {
    	Mark m = (Mark) o;
    	if(this == m) return true;
    	
    	if(!(this instanceof m)) return false;
    	return this.mark.equals(m.mark);
    }
    
    public int compareTo(Object o) {
    	Mark m = (Mark) o;
    	return getGrade() - m.getGrade();
    }
    
    public int hashCode() {
    	int result = 37;
    	result = result + mark.hashCode();
    	result = result + firstAttestation.hashCode();
    	result = result + secondAttestation.hashCode();
    	result = result + finalGrade.hashCode();
    	result = result + getMark.hashCode();
    	result = result + getGrade.hashCode();
    }
}

