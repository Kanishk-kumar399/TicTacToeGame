import java.util.*;
public class TicTacToeGame
{
    static char[] board;
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
    	System.out.println("Enter X or O as your turn");
    	char Symbol=s.next().charAt(0);
	System.out.println(Symbol+" is option for player");
    	return symbol;
    }
    public static void main(String args[])
    {
        boardCreate();
        newTurn();
    }
}
