package chessEngine;

import java.util.ArrayList;

import chessEngine.Piece.fractions;

public class Game
{
	private ArrayList<Piece> pieces;
	private char[][] board;
	private fractions turn;
	
	public Game()
	{
		pieces = new ArrayList<Piece>();
		board = new char[8][8];
		turn = fractions.WHITE;
		for(int i = 0; i < 8; i++)
		{
			pieces.add(new Pawn('@', new Position(1, i), fractions.WHITE));//Adding pawns
			pieces.add(new Pawn('*', new Position(6, i), fractions.BLACK));
		}
		
		pieces.add(new Rook('^', new Position(0, 7), fractions.WHITE));//Adding Rooks
		pieces.add(new Rook('^', new Position(0, 0), fractions.WHITE));
		pieces.add(new Rook('~', new Position(7, 0), fractions.BLACK));
		pieces.add(new Rook('~', new Position(7, 7), fractions.BLACK));
		
		pieces.add(new Bishop('!', new Position(0, 5), fractions.WHITE));//Adding Bishops
		pieces.add(new Bishop('!', new Position(0, 2), fractions.WHITE));
		pieces.add(new Bishop('x', new Position(7, 2), fractions.BLACK));
		pieces.add(new Bishop('x', new Position(7, 5), fractions.BLACK));
		
		pieces.add(new Knight('<', new Position(0, 1), fractions.WHITE));//Adding Knights
		pieces.add(new Knight('<', new Position(0, 6), fractions.WHITE));
		pieces.add(new Knight('>', new Position(7, 1), fractions.BLACK));
		pieces.add(new Knight('>', new Position(7, 6), fractions.BLACK));
		
		pieces.add(new Queen('P', new Position(0, 3), fractions.WHITE));//Adding Queen
		pieces.add(new Queen('Ü', new Position(7, 3), fractions.BLACK));
		
		pieces.add(new King('$', new Position(0,4), fractions.WHITE));//Adding Kings
		pieces.add(new King('$', new Position(7,4), fractions.BLACK));
		
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
		
		fractions enemy = null;
		if (turn == fractions.WHITE)
			enemy = fractions.BLACK;
		else
			enemy = fractions.WHITE;
		
		for(Piece p: pieces)
		{
			if(p.getPosition().equals(start))
			{
				if(p.fraction == turn)
				{
					for(Piece target: pieces)
					{
						if(target.getPosition().equals(destination))
						{
							if(target.fraction == enemy)
							{
								if(!checkCollision(p, destination))
								{
									if(p.kill(target)) 
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
					if(!checkCollision(p, destination))
					{
						if(p.move(destination))
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
		if(piece instanceof Knight)
			return false;		
		if(piece instanceof Pawn)
		{
			return checkPawnCollision(piece, destination);
		}
		Position start = piece.getPosition();
		int dx = destination.getDx(start);
		int dy = destination.getDy(start);
		
		System.out.println(piece.getVertcl() + " " + piece.getVertcl() + " " + dx + " " + dy);
		if(Math.abs(dx) <= 1 && Math.abs(dy) <= 1)
			return false;
		
		if(Math.abs(dy) == 1)
			return false;
		dx = getSign(dx);
		dy = getSign(dy);
		for(int i = 1; i < 8; i++)
		{
			if(board[start.horizntl + (dy * i)][start.vertcl + (dx * i)] != '\u0000')
			{
				return true;	
			}
		}
		return false;
	}
	
	private boolean checkPawnCollision(Piece piece, Position destination)
	{
		int dy;
		if(piece.fraction == fractions.BLACK)
			dy = -1;
		else 
			dy = 1;
		if(board[piece.getVertcl() + dy][piece.getHorizntl()] == '\u0000')
		{
			if(Math.abs(destination.getDy(piece.getPosition())) == 2)
			{
				if(board[piece.getVertcl() + (dy * 2)][piece.getHorizntl()] == '\u0000')
					return false;
			}				
		}
		return true;
	}
	
	private int getSign(int a)
	{
		if(a > 0)
			return 1;
		else if(a < 0)
			return -1;
		return 0;
	}
	
	private void changeTurn()
	{
		if(turn == fractions.WHITE)
			turn = fractions.BLACK;
		else
			turn = fractions.WHITE;
	}
	
	public char[][] getBoard()
	{
		return board;
	}
	
	public String getTurn()
	{
		if(turn == fractions.BLACK)
			return "Black";
		return "White";
	}
}
