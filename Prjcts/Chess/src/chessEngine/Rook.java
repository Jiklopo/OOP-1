package chessEngine;

public class Rook extends Piece
{
	
	public Rook() { super(); }
	
	public Rook(char symbol, Position position, fractions fraction)
	{
		super(symbol, position, fraction);
	}
	
	
	
	public boolean isKillValid(Position pos)
	{
		return isMoveValid(pos);
	}

	public boolean isMoveValid(Position pos)
	{
		int dx = pos.getDx(position);
		int dy = pos.getDy(position);
		if((dx == 0 && dy != 0) || (dy == 0 && dx != 0))
			return true;
		return false;
	}
}
