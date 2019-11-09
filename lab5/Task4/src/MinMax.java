
public class MinMax {
	MinMaxPair minMax;
	
	public static class MinMaxPair
	{
		private int min, max;
		
		public MinMaxPair()
		{
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
		}
		
		public int getMin()
		{
			return min;
		}
		
		public int getMax()
		{
			return max;
		}
		
		public String toString()
		{
			return "Min: " + min + "\nMax: " + max;
		}
	}
	
	public MinMax()
	{
		minMax = new MinMaxPair();
	}
	
	public MinMaxPair findMinMax(int numbers[])
	{
		for(int i = 0; i < numbers.length; i++)
		{
			if(minMax.min > numbers[i])
				minMax.min = numbers[i];
			if(minMax.max < numbers[i])
				minMax.max = numbers[i];
		}
		return minMax;
	}

}
