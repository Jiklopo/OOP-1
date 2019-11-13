import java.util.Collections;
import java.util.Date;
import java.util.Vector;
public class MegaTest {

	public static void main(String[] args) {
		String[] names = {"Vasek", "Leha", "Miha", "Tanyuha", "Sanek"};
		Vector<Employee> es1 = new Vector<Employee>(5);
		Vector<Employee> es2 = new Vector<Employee>(5);
		Vector<Employee> es3 = new Vector<Employee>(5);
		for(int i = 0; i < 5; i++)
		{
			es1.add(new Employee(names[i], 2000.0 - (i * 23), new Date(), "00000" + i));
			es2.add(new Employee(names[i], 2000.0 - (i * 71), new Date(), "00000" + i));
			es3.add(new Employee(names[i], 4000.0 - (i * 43), new Date(), "11111" + i));
		}
		
		Manager m1 = new Manager("Lena", 3500, new Date(), "123456", es1);
		Manager m2 = new Manager("Lena", 3500, new Date(), "123456", es2);
		Manager m3 = new Manager("Manya", 3500, new Date(), "123456", es1);
		
		Collections.sort(es1, Employee.compareByName);
		Collections.sort(es2, Employee.compareBySalary);
		for(Employee e: es1)
		{
			System.out.println(e);
		}
		System.out.println();
		for(Employee e: es2)
		{
			System.out.println(e);
		}
	}

}
