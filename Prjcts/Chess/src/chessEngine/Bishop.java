package chessEngine;

public final class Bishop extends Piece
{
	public Bishop()
	{
		super();
	}
	
	public Bishop(char symbol, Position position, fractions fraction)
	{
		super(symbol, position, fraction);
	}
	
	public boolean isMoveValid(Position position)
	{
		int dx = position.getDx(this.position);
		int dy = position.getDy(this.position);
		if(dx != 0 && dy != 0 && Math.abs(dx) == Math.abs(dy))
			return true;
		return false;
	}
}