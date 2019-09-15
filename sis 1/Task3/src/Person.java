
public class Person {
	Gender gender;
	enum Gender{
		BOY,
		GIRL
	}
	
	
	public Person() {
		gender = Gender.BOY;
	}	
	public Person(Gender gender) {
		this.gender = gender;
	}
	
	
	public String toString() {
		return gender.toString();
	}
}
