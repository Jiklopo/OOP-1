import java.util.Scanner;

public class Game
{
	private Piece[] whites, blacks;
	private char[][] board;
	private Scanner input = new Scanner(System.in);
	
	Game()
	{
		whites = new Piece[16];
		blacks = new Piece[16];
		board = new char[8][8];
		for(int i = 0; i < 8; i++)
		{
			whites[i] = new Pawn(new Position(1, i), Piece.fractions.WHITE);
			blacks[i] = new Pawn(new Position(6, i), Piece.fractions.BLACK);
		}
		for(int i = 0; i < 8; i++)
		{
			Position whitePos = whites[i].getPosition();
			Position blackPos = blacks[i].getPosition();
			board[whitePos.getVertcl()][whitePos.getHorizntl()] = whites[i].getSymbol();
			board[blackPos.getVertcl()][blackPos.getHorizntl()] = whites[i].getSymbol();
		}
	}
	
	public void start()
	{
		System.out.println(drawBoard());
		String s1 = input.next();
		String s2 = input.next();
		makeMove(s1, s2);
		System.out.println(drawBoard());
	}
	
	public void makeMove(String from, String to)
	{
		Position prev = new Position();
		char c = '*';
		boolean isChanged = false;
		for(int i = 0; i < 8; i++)
		{
			if(whites[i].getPosition().toString() == from)
			{
				prev = whites[i].getPosition();
				c = whites[i].getSymbol();
				isChanged = whites[i].move(new Position(to));
				break;
			}
			else if(blacks[i].getPosition().toString() == from)
			{
				prev = blacks[i].getPosition();
				c = blacks[i].getSymbol();
				isChanged = blacks[i].move(new Position(to));
				break;
			}
		}
		if(isChanged)
		{
			board[prev.getVertcl()][prev.getHorizntl()] = c;
		}
	}
	
	private String drawBoard()
	{
		String drawnBoard = "";
		for(int i = 0; i < 8; i++)
		{
			drawnBoard += "_________________________________\n|";
			for(int j = 0; j < 8; j++)
			{
				drawnBoard += " " + board[i][j] + " |";
			}
			drawnBoard += "\n";
			
		}
		drawnBoard += "_________________________________";
		return drawnBoard;
	}
}
