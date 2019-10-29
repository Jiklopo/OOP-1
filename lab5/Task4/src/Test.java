
public class Test {

	public static void main(String[] args) {
		MinMax m = new MinMax();
		int[] a = {1, -2, 10, 15};
		System.out.println(m.findMinMax(a).getMax() + "\n" + m.findMinMax(a).getMin());
		System.out.println(m.findMinMax(a));
		
	}

}
