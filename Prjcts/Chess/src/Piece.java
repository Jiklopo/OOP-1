
public abstract class Piece
{
	private Position position, movement;
	private char symbol;
	fractions fraction;
	
	enum fractions {WHITE, BLACK};
	
	Piece()
	{
		position = new Position();
		movement = new Position(1, 0);
		fraction = fractions.WHITE;
		symbol = '*';
	}
	
	Piece(Position position, fractions fraction)
	{
		this();
		this.position = position;
		this.fraction = fraction;
	}
	
	Piece(char symbol, Position position, Position movement, fractions fraction)
	{
		this.symbol = symbol;
		this.position = position;
		this.movement = movement;
		this.fraction = fraction;
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
