import java.util.Scanner;

public class Game
{
	private Piece[] whites, blacks;
	private char[][] board;
	private whoseTurn turn;
	private Scanner input = new Scanner(System.in);

	enum whoseTurn {BLACK, WHITE};
	Game()
	{
		whites = new Piece[8];
		blacks = new Piece[8];
		board = new char[8][8];
		turn = whoseTurn.WHITE;
		for(int i = 0; i < 8; i++)
		{
			whites[i] = new Pawn(new Position(1, i));
			blacks[i] = new Pawn(new Position(6, i));
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
		if(turn == whoseTurn.WHITE)
			System.out.println("White's turn");
		else
			System.out.println("Black's turn");
		String s1 = null, s2 = null;
		while(s1 != "stop")
		{
			s1 = input.next();
			s2 = input.next();
			makeMove(s1, s2);
			System.out.println(drawBoard());
		}
	}
	
	public void makeMove(String from, String to)
	{
		Piece[] pieces = null;
		if (turn == whoseTurn.WHITE)
			pieces = whites;
		else
			pieces = blacks;
		for(Piece p: pieces)
		{
			if(p.getPosition().toString().equals(from))
			{
				if(p.getPosition().isMoveValid(new Position(to)))
				{
					board[p.getVertcl()][p.getHorizntl()] = ' ';
					p.move(new Position(to));
					board[p.getVertcl()][p.getHorizntl()] = p.getSymbol();
					if(turn == whoseTurn.WHITE)
						turn = whoseTurn.BLACK;
					else
						turn = whoseTurn.WHITE;
				}
			}
		}		
	}
	
	private String drawBoard()
	{
		String drawnBoard = "  A   B   C   D   E   F   G   H  \n";
		for(int i = 7; i >= 0; i--)
		{			
			drawnBoard += "_________________________________\n|";
			for(int j = 0; j < 8; j++)
			{
				drawnBoard += " " + board[i][j] + " |";
			}
			drawnBoard += (i + 1) + "\n";
			
		}
		drawnBoard += "_________________________________";
		return drawnBoard;
	}
}
