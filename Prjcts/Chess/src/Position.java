
public class Position {
	private int horizntl, vertcl;
	
	Position()
	{
		horizntl = vertcl = 0;
	}
	
	Position(int vertcl, int horizntl)
	{
		this.vertcl = vertcl;
		this.horizntl = horizntl;
	}
	
	Position(String position)
	{
		vertcl = Integer.parseInt(position.charAt(1) + "") - 1;
		horizntl = (int)position.charAt(0) - 97;
	}
	
	public int getHorizntl()
	{
		return horizntl;
	}
	
	public int getVertcl()
	{
		return vertcl;
	}
	
	public boolean setHorizntl(int horizntl)
	{
		if (isMoveValid(this.horizntl, horizntl))
		{
			this.horizntl = horizntl;
			return true;
		}
		return false;
	}
	
	public boolean setVertcl(int vertcl)
	{
		if (isMoveValid(this.vertcl, vertcl))
		{
			this.vertcl = vertcl;
			return true;
		}
		return false;
	}
	
	public boolean isMoveValid(int a, int b)
	{
		if(a + b < 0)
			return false;
		else if(a + b >= 8)
			return false;
		else
			return true;		
	}
	
	public boolean isMoveValid(Position p)
	{
		if (vertcl == p.vertcl && horizntl == p.horizntl)
			return false;
		return true;
	}
	
	public boolean move(Position p)
	{
//		if(isMoveValid(horizntl, p.horizntl) || isMoveValid(vertcl, p.vertcl))
//		{
//			horizntl += p.horizntl;
//			vertcl += p.vertcl;
//			return true;
//		}
//		return false;
		horizntl = p.horizntl;
		vertcl = p.vertcl;
		return true;
	}
	
	public boolean move(int vertcl,  int horizntl)
	{
		if(isMoveValid(horizntl, this.horizntl) || isMoveValid(vertcl, this.vertcl))
		{
			this.horizntl += horizntl;
			this.vertcl += vertcl;
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		String string = "";
		string += (char)(97 + horizntl);
		string += (vertcl + 1);
		return string;
	}
	
	public boolean equals(Object o)
	{
		if(this.getClass() != o.getClass())
			return false;
		Position temp = (Position)o;
		if(temp.toString() != this.toString())
			return false;
		return true;
	}
}
