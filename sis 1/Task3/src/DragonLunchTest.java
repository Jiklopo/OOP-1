import java.util.Random;
public class DragonLunchTest {

	public static void main(String[] args) {
		Random r = new Random();
		DragonLunch lunch = new DragonLunch();
		for(int i = 0; i < 10; i++) {
			if(r.nextInt(10) > 5)
				lunch.kidnapp(new Person(Person.Gender.BOY));
			else
				lunch.kidnapp(new Person(Person.Gender.GIRL));
		}
		System.out.println(lunch.prisoners);
		if(lunch.toEatOrNotToEat()) {
			System.out.println(lunch.prisoners);
			System.out.println("Dragon will have dinner!");			
		}
		else{
			System.out.println(lunch.prisoners);
			System.out.println("Dragon will be hungry!");			
		}
	}
	
}
