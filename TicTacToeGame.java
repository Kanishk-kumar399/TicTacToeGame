import java.util.*;
public class TicTacToeGame
{
    static char[] board;
    static char Turn;
    Scanner sc=new Scanner(System.in);
    public static void boardCreate()
    {
        board=new char[10];
        for(int i=1;i<10;i++)
        {
            board[i]=' ';
        }
    }
    public static char newTurn()
    {
    	Scanner s=new Scanner(System.in);
    	System.out.println("Enter P for player and C for Computer");
    	char gamePlayer=s.next().charAt(0);
    	System.out.println("Enter X or O as your turn");
    	Turn=s.next().charAt(0);
    	return Turn;
    }
    public static void main(String args[])
    {
        TicTacToeGame obj=new TicTacToeGame();
        obj.boardCreate();
        obj.newTurn();
    }
}
