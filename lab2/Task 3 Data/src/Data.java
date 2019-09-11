
public class Data {
	private double sum, max;
	private int amount;
	
	Data(){
		sum = 0;
		amount = 0;
		max = Double.NaN;
	}
	
	public void add(double value) {
		amount++;
		sum += value;
		if(value > max || Double.isNaN(max))
			max = value;
	}
	
	public double getAvg() {
		if(amount != 0)
			return sum/amount;
		else
			return 0;
	}
	
	public double getMax() {
		return max;
	}
}
