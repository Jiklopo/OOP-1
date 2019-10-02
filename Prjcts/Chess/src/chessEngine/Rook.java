package chessEngine;

public final class Rook extends Piece
{
	
	public Rook() { super(); }
	
	public Rook(char symbol, Position position, fractions fraction)
	{
		super(symbol, position, fraction);
	}

	public boolean isMoveValid(Position position)
	{
		int dx = position.getDx(this.position);
		int dy = position.getDy(this.position);
		return ((dx == 0 && dy != 0) || (dy == 0 && dx != 0))
		
	}
}
