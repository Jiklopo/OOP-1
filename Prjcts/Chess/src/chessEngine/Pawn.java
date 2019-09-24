package chessEngine;

public final class Pawn extends Piece
{
	private boolean moveMade;
	
	{
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
	
	public boolean isMoveValid(Position position)
	{
		int dx = position.getDx(this.position);
		if(dx != 0)
			return false;
		int dy = position.getDy(this.position);
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
	
	public boolean isKillValid(Position position)
	{
		int dx = position.getDx(this.position);
		int dy = position.getDy(this.position);
		if(fraction == fractions.BLACK)
			dy *= -1;
		if(dy == 1 && (dx == 1 || dx == -1))
			return true;
		return false;
	}

}
