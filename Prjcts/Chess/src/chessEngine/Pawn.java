package chessEngine;

public final class Pawn extends Piece
{
	private boolean moveMade;
	{
		vertclMove = 1;
		horizntlMove = 0;
		moveMade = false;
	}
	public Pawn()
	{
		super();
	}
	
	public Pawn(char symbol, Position position, fractions fraction)
	{
		super(symbol, position, fraction);
	}
	
	public boolean isMoveValid(Position pos)
	{
		int dx = pos.getDx(position);
		if(dx != 0)
			return false;
		int dy = pos.getDy(position);
		if(fraction == fractions.BLACK)
			dy *= -1;
		if(dy <= 2 && dy > 0 && !moveMade)
		{
			moveMade = true;
			return true;
		}
		if(dy == 1)
		{
			moveMade = true;
			return true;
		}
		else
			return false;
	}

}
