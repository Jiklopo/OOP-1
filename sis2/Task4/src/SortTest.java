import java.util.Random;

public class SortTest {

	public static void main(String[] args) {
		Chocolate[] chocs = new Chocolate[10];
		for(int i = 0 ; i < 10; i++)
			chocs[i] = new Chocolate("Test", 15 - i);
		Sort.bubbleSort(chocs);
		for(Chocolate c: chocs)
			System.out.println(c);
		
		Time[] times = new Time[10];
		Random r = new Random();
		for(int i = 9; i >= 0; i--)
		{
			times[i] = new Time(1, 1, r.nextInt(60));
		}
		Sort.bubbleSort(times);
		for(Time t: times)
		{
			System.out.println(t);
		}

	}

}
