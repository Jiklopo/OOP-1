package chessEngine;

import java.util.ArrayList;

public class Game
{
	private ArrayList<Piece> pieces;
	private char[][] board;
	private Piece.fractions turn;
	
	public Game()
	{
		pieces = new ArrayList<Piece>();
		board = new char[8][8];
		turn = Piece.fractions.WHITE;
		for(int i = 0; i < 8; i++)
		{
			pieces.add(new Pawn('@', new Position(1, i), Piece.fractions.WHITE));
			pieces.add(new Pawn('*', new Position(6, i), Piece.fractions.BLACK));
		}
		for(int i = 0; i < pieces.size(); i++)
		{
			Position whitePos = pieces.get(i).getPosition();
			board[whitePos.getVertcl()][whitePos.getHorizntl()] = pieces.get(i).getSymbol();
		}
	}
	
	
	
	public boolean makeMove(String from, String to)
	{
		Position destination = new Position(to);
		Position start = new Position(from);
		for(Piece p: pieces)
		{
			Piece.fractions enemy = null;
			if (turn == Piece.fractions.WHITE)
				enemy = Piece.fractions.BLACK;
			else
				enemy = Piece.fractions.WHITE;
			if(p.fraction == turn)
			{
				if(p.getPosition() == start)
				{
					for(Piece target: pieces)
					{
						if(target.fraction == enemy)
						{
							if(target.getPosition() == destination)
							{
								if(p.move(target.position))
								{
									board[start.getVertcl()][start.getHorizntl()] = ' ';
									return true;
								}
							}
						}
					}
					if(p.move(destination))
					{
						board[start.getVertcl()][start.getHorizntl()] = ' ';
						return true;
					}				
				}
			}
		}
		return false;
	}
	
	public char[][] getBoard()
	{
		return board;
	}
}
