import java.util.ArrayList;

public class DragonLunch {
	public ArrayList<Person> prisoners;
	
	
	
	public DragonLunch() {
		prisoners = new ArrayList<Person>();
	}
	public DragonLunch(Person p) {
		this();
		kidnapp(p);
	}	
	
	
	public boolean kidnapp(Person p) {
		return prisoners.add(p);
	}
	
	public boolean toEatOrNotToEat() {
		if(howManyPeopleToEat() > 0)
			return true;
		return false;
	}
	
	public int howManyPeopleToEat() {
		while(removeMagicPair());
		return prisoners.size();
	}
	
	private boolean removeMagicPair() {
		if(prisoners.size() <= 1)
			return false;
		boolean isDeleted = false;
		for(int i = 0; i < prisoners.size() - 1; i++) {
			if(prisoners.get(i).gender == Person.Gender.BOY
					&& prisoners.get(i + 1).gender == Person.Gender.GIRL)
			{
				prisoners.remove(i + 1);
				prisoners.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}
}
