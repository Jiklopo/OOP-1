
public abstract class Shape 
{
	Color c;
	private int x;
	enum Color {BLACK, RED};
	static int cnt;
	{cnt++;}
	public Shape()
	{
		c = Color.BLACK;
		x = 0;
	}
	
	public Shape(Color c, int x)
	{
		this.c = c;
		this.x = x;
	}
	public abstract void draw();
	
	public void draw(int cnt)
	{
		for(int i = 0; i < cnt; i++)
			draw();
	}
	
	public void makeSpace()
	{
		for(int i = 0; i < x; i++)
			System.out.print(" ");
	}
}
