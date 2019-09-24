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
		int dx = position.getDx(this.position);
		int dy = position.getDy(this.position);
		if((Math.abs(dx) == 1 && Math.abs(dy) == 2) || ((Math.abs(dx) == 2 && Math.abs(dy) == 1)))
			return true;
		return false;
	}
	
	public boolean isKillValid(Position position)
	{
		return isMoveValid(position);
	}
}
