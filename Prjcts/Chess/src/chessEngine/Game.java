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
			pieces.add(new Pawn('@', new Position(1, i), Piece.fractions.WHITE));//Adding pawns
			pieces.add(new Pawn('*', new Position(6, i), Piece.fractions.BLACK));
		}
		
		pieces.add(new Rook('^', new Position(0, 7), Piece.fractions.WHITE));//Adding rooks
		pieces.add(new Rook('^', new Position(0, 0), Piece.fractions.WHITE));
		pieces.add(new Rook('~', new Position(7, 0), Piece.fractions.BLACK));
		pieces.add(new Rook('~', new Position(7, 7), Piece.fractions.BLACK));
		
		pieces.add(new Bishop('!', new Position(0, 5), Piece.fractions.WHITE));//Adding Bishops
		pieces.add(new Bishop('!', new Position(0, 2), Piece.fractions.WHITE));
		pieces.add(new Bishop('x', new Position(7, 2), Piece.fractions.BLACK));
		pieces.add(new Bishop('x', new Position(7, 5), Piece.fractions.BLACK));
		
		pieces.add(new Knight('<', new Position(0, 1), Piece.fractions.WHITE));//Adding Knights
		pieces.add(new Knight('<', new Position(0, 6), Piece.fractions.WHITE));
		pieces.add(new Knight('>', new Position(7, 1), Piece.fractions.BLACK));
		pieces.add(new Knight('>', new Position(7, 6), Piece.fractions.BLACK));
		
		pieces.add(new Queen('P', new Position(0, 3), Piece.fractions.WHITE));//Adding Queen
		pieces.add(new Queen('Ü', new Position(7, 3), Piece.fractions.BLACK));
		
		for(int i = 0; i < pieces.size(); i++)//fill board with Pieces
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
									if(checkCollision(p, destination)) 
									{
										pieces.remove(target);
										board[destination.getVertcl()][destination.getHorizntl()] = p.getSymbol();
										board[start.getVertcl()][start.getHorizntl()] = '\u0000';
										changeTurn();
										return true;										
									}
								}
							}
							return false; //if not an enemy
						}
					}
					if(p.move(destination))
					{
						if(checkCollision(p, destination))
						{
							board[destination.getVertcl()][destination.getHorizntl()] = p.getSymbol();
							board[start.getVertcl()][start.getHorizntl()] = '\u0000';
							changeTurn();
							return true;							
						}
					}				
				}
			}
		}
		return false;
	}
	
	private boolean checkCollision(Piece piece, Position destination)
	{
		return true;
//		if(piece.getClass() == Knight.class)
//			return false;
//		int dx = destination.getDx(piece.getPosition());
//		int dy = destination.getDy(piece.getPosition());
//		Position start = piece.getPosition();
//		if(dx < 0)
//			dx = -1;
//		else if(dx > 0)
//			dx = 1;
//		if(dy < 0)
//			dy = -1;
//		else if(dy > 0)
//			dy = 1;
//		for(int i = 0; start.getHorizntl() + dy * i < 8 || start.getVertcl() + dx * i < 8; i++)
//		{
//			if(board[start.getHorizntl() + dy * i][start.getVertcl() + dx * i] != '\u0000')
//				return true;
//		}
//		return false;
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
	
	public Piece.fractions getTurn()
	{
		return turn;
	}
}
