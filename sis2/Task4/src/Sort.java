
public class Sort {
	static <T> void swap(T [] array, int l, int r)
	{
		T temp = array[l];
		array[l] = array[r];
		array[r] = temp;
	}
	
	static <T extends Comparable<T>> void bubbleSort(T[] array)
	{
		for(int i = 0; i < array.length - 1; i++)
		{
			for(int j = 0; j < array.length - i - 1; j++)
			{
				if(array[j].compareTo(array[j + 1]) > 0)
					swap(array, j, j + 1);
			}
		}
	}
}
