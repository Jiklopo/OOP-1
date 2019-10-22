package chessEngine;

public class Knight extends Piece
{
	public Knight()
	{
		super();
	}
	
	public Knight(char symbol, Position position, fractions fraction)
	{
		super(symbol, position, fraction);
	}
	
	public boolean isMoveValid(Position position)
	{
		int dx = Math.abs(position.getDx(this.position));
		int dy = Math.abs(position.getDy(this.position));
		if((dx == 1 && dy == 2) || ((dx == 2 && dy == 1)))
			return true;
		return false;
	}
}
