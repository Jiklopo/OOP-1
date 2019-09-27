package chessEngine;

public class Position {
	public int horizntl, vertcl;
	
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
		if (isPosValid(horizntl))
		{
			this.horizntl = horizntl;
			return true;
		}
		return false;
	}
	
	public boolean setVertcl(int vertcl)
	{
		if (isPosValid(vertcl))
		{
			this.vertcl = vertcl;
			return true;
		}
		return false;
	}
	
	public boolean isPosValid(int a)
	{
		if(a > 7 || a < 0)
			return false;
		return true;
	}
	
	public int getDx(Position p)
	{
		System.out.println(p.horizntl);
		return horizntl - p.horizntl;
	}
	
	public int getDy(Position p)
	{
		System.out.println(p.vertcl);
		return vertcl - p.vertcl;
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
		Position position = (Position)o;
		if(position.toString().equals(this.toString()))
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
