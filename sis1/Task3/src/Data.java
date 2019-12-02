import java.util.Vector;

public class Data{
	public Vector<Integer> data;
	
	public void addData(int[] data) {
		for(int i: data)
			this.data.add(i);
	}
	
	public void addData(Vector<Integer> data) {
		this.data.addAll(data);
	}
	
	public void addData(int data) {
		this.data.add(data);
	}
}
