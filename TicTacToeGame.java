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
    	return Symbol;
    }
    public static void displayBoard()
    {
		System.out.println("  "+board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("--------------");
		System.out.println("  "+board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("--------------");
		System.out.println("  "+board[7] + " | " + board[8] + " | " + board[9]);
    }
    public static int chooseIndex()
    {
        Scanner a=new Scanner(System.in);
        System.out.println("Enter an Index from 1 to 9");
        int i=a.nextInt();
            if(board[i]==' ')
            return i;
            else
            {
                System.out.println("Choose Another Index! Index not free");
                return chooseIndex();
            }
    }
    public static void main(String args[])
    {
        boardCreate();
        newTurn();
	displayBoard();
	chooseIndex();
    }
}
