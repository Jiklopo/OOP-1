import java.util.Vector;
public class MegaTest {

	public static void main(String[] args) {
		String[] names = {"Vasek", "Leha", "Miha", "Tanyuha", "Sanek"};
		Vector<Employee> es1 = new Vector<Employee>(5);
		Vector<Employee> es2 = new Vector<Employee>(5);
		Vector<Employee> es3 = new Vector<Employee>(5);
		for(int i = 0; i < 5; i++)
		{
			es1.add(new Employee(names[i], 2000.0 + i * 1000, 2010 + i, "00000" + i));
			es2.add(new Employee(names[i], 2000.0 + i * 1000, 2010 + i, "00000" + i));
			es3.add(new Employee(names[i], 4000.0 + i * 1000, 2000 + i, "11111" + i));
		}
		
		Manager m1 = new Manager("Lena", 3500, 2012, "123456", es1);
		Manager m2 = new Manager("Lena", 3500, 2012, "123456", es2);
		Manager m3 = new Manager("Manya", 3500, 2012, "123456", es1);
		
		System.out.println(m1 + "\n\n" + m2 + "\n\n" + m3);
		System.out.println(m1.equals(m2) + "\n" + m1.equals(m3));
	}

}
