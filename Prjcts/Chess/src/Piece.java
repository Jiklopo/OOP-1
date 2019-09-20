
public abstract class Piece
{
	private Position position, movement;
	private char symbol;
	
	Piece()
	{
		position = new Position();
		movement = new Position(1, 0);
		symbol = '*';
	}
	
	Piece(Position position)
	{
		this();
		this.position = position;
	}
	
	Piece(char symbol, Position position, Position movement)
	{
		this.symbol = symbol;
		this.position = position;
		this.movement = movement;
	}
	
	
	public boolean move(int vertcl, int horizntl)
	{
		return position.move(vertcl, horizntl);
	}
	
	public boolean move(Position p)
	{
		return position.move(p);
	}
	
	public boolean move()
	{
		return position.move(movement);
	}
	
	public char getSymbol()
	{
		return symbol;
	}
	
	public Position getPosition()
	{
		return position;
	}
	
	public int getHorizntl()
	{
		return position.getHorizntl();
	}
	
	public int getVertcl()
	{
		return position.getVertcl();
	}
}
