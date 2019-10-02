import java.util.Scanner;
import java.util.Vector;

public class PersonalTest {

	public static void main(String[] args) {
		Vector<Person> persons = new Vector<Person>();
		Scanner input = new Scanner(System.in);
		while(true)
		{
			System.out.println("What do you want to do?\n"
					+ "Type p - to add Person\n"
					+ "student - to add Student\n"
					+ "staff - to add Staff member\n"
					+ "exit - to exit");
			String type = input.next();
			if(type.equals("exit"))
				break;
			System.out.println("Name and address");
			String name = input.next();
			String address = input.next();
			switch (type) 
			{
			case "p":
				persons.add(new Person(name, address));
				break;

			case "student":
				System.out.println("Program, year, fee");
				String program = input.next();
				int year = input.nextInt();
				double fee = input.nextDouble();
				persons.add(new Student(name, address, program, year, fee));
				break;
				
			case "staff":
				System.out.println("School, pay");
				String school = input.next();
				double pay = input.nextDouble();
				persons.add(new Staff(name, address, school, pay));
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + type);
			}	
		}
		input.close();
		
		for(Person p: persons)
			System.out.println(p);
		}
}
