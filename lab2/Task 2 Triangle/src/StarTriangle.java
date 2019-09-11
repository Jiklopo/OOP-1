
public class StarTriangle {
	int width;
	StarTriangle(int width){
		this.width = width;
	}
	
	public String toString() {
		String triangle = new String();
		for(int i = 1; i <= width; i++ ) {
			for(int j = 1; j <= i; j++) {
				triangle += "[*]";
			}
			triangle += "\n";
		}
		return triangle;
	}
}
