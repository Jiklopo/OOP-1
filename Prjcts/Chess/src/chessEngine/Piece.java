package chessEngine;
public abstract class Piece
{
	protected Position position;
	private char symbol;
	fractions fraction;
	
	public enum fractions {WHITE, BLACK};
	public Piece()
	{
		position = new Position();
		symbol = '*';
		fraction = fractions.WHITE;
	}
	
	public Piece(Position position)
	{
		this();
		this.position = position;
	}
	
	public Piece(char symbol, Position position, fractions fraction)
	{
		this.symbol = symbol;
		this.position = position;
		this.fraction = fraction;
	}
	
	
	
	public final boolean move(Position position)
	{
		if(isMoveValid(position))
		{
			this.position = position;
			return true;
		}
		return false;
	}	
	
	public final boolean kill(Piece piece)
	{
		if(isKillValid(piece.getPosition()))
		{
			position = piece.getPosition();
			return true;
		}
		return false;
	}
	
	public abstract boolean isMoveValid(Position position);

	public boolean isKillValid(Position position)
	{
		return isMoveValid(position);
	}
	
	public final char getSymbol()
	{
		return symbol;
	}
	
	public final Position getPosition()
	{
		return position;
	}
	
	public final int getHorizntl()
	{
		return position.getHorizntl();
	}
	
	public final int getVertcl()
	{
		return position.getVertcl();
	}
	
	public String toString()
	{
		return fraction.toString().toLowerCase() + " piece at " + position;
	}
	
	
}
