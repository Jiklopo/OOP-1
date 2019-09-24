package chessEngine;

public class Position {
	private int horizntl, vertcl;
	
	public Position()
	{
		horizntl = vertcl = 0;
	}
	
	public Position(int vertcl, int horizntl)
	{
		this.vertcl = vertcl;
		this.horizntl = horizntl;
	}
	
	public Position(String position)
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
	
	public int getDx(Position p)
	{
		return horizntl - p.horizntl;
	}
	
	public int getDy(Position p)
	{
		return vertcl - p.vertcl;
	}
	
	public String toString()
	{
		String string = "";
		string += (char)(97 + horizntl);
		string += (vertcl + 1);
		return string;
	}
	
	public boolean equals(Object obj)
	{
		if(this.getClass() != obj.getClass())
			return false;
		Position pos = (Position)obj;
		if(pos.toString().equals(this.toString()))
			return true;
		return false;
	}
	
	public int hashCode()
	{
		int result = 17;
		result = 31 * result + horizntl;
		result = 31 * result + vertcl;
		return result;
	}
}
