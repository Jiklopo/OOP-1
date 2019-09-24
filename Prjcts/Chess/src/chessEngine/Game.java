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
		pieces.add(new Rook('^', new Position(0, 7), Piece.fractions.WHITE));
		pieces.add(new Rook('^', new Position(0, 0), Piece.fractions.WHITE));
		pieces.add(new Rook('~', new Position(7, 0), Piece.fractions.BLACK));
		pieces.add(new Rook('~', new Position(7, 7), Piece.fractions.BLACK));
		for(int i = 0; i < pieces.size(); i++)
		{
			Position pos = pieces.get(i).getPosition();
			board[pos.getVertcl()][pos.getHorizntl()] = pieces.get(i).getSymbol();
		}
	}
	
	
	
	public boolean makeMove(String from, String to)
	{
		Position destination = new Position(to);
		Position start = new Position(from);
		Piece.fractions enemy = null;
		if (turn == Piece.fractions.WHITE)
			enemy = Piece.fractions.BLACK;
		else
			enemy = Piece.fractions.WHITE;
		for(Piece p: pieces)
		{
			if(p.getPosition().equals((Object)start))
			{
				if(p.fraction == turn)
				{
					for(Piece target: pieces)
					{
						if(target.getPosition().equals((Object)destination))
						{
							if(target.fraction == enemy)
							{
								if(p.kill(target))
								{
									pieces.remove(target);
									board[destination.getVertcl()][destination.getHorizntl()] = p.getSymbol();
									board[start.getVertcl()][start.getHorizntl()] = ' ';
									changeTurn();
									return true;
								}
							}
						}
					}
					if(p.move(destination))
					{
						board[destination.getVertcl()][destination.getHorizntl()] = p.getSymbol();
						board[start.getVertcl()][start.getHorizntl()] = ' ';
						changeTurn();
						return true;
					}				
				}
			}
		}
		return false;
	}
	
	private void changeTurn()
	{
		if(turn == Piece.fractions.WHITE)
			turn = Piece.fractions.BLACK;
		else
			turn = Piece.fractions.WHITE;
	}
	public char[][] getBoard()
	{
		return board;
	}
}
