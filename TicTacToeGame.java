import java.util.*;
public class TicTacToeGame
{
    static final int HEADS=0;
    static final int TAILS=1;
    static final String USER="USER starts first";
    static final String COMPUTER ="COMPUTER starts first";
    static char[] board;
    /*UC1*/
    public static void boardCreate()
    {
        board=new char[10];
        for(int i=1;i<10;i++)
        {
            board[i]=' ';
        }
    }
    /*UC2*/
    public static char newTurn()
    {
    	Scanner s=new Scanner(System.in);
    	System.out.println("Enter X or O as your turn");
    	char Symbol=s.next().charAt(0);
    	System.out.println(Symbol+" is for User");
    	return Symbol;
    }
    /*UC3*/
    public static void displayBoard()
    {
		System.out.println("  "+board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("--------------");
		System.out.println("  "+board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("--------------");
		System.out.println("  "+board[7] + " | " + board[8] + " | " + board[9]);
    }
    /*UC4*/
    public static int chooseIndex()
    {
        Scanner a=new Scanner(System.in);
        System.out.println("Enter an Index from 1 to 9");
        int i=a.nextInt();
            while(true)
            {
            if(board[i]!=' ')
             	{
                System.out.println("Choose Another Index! Index not free");
             	}
            else 
            	break;
            }
            return i;
    }
    /*UC5*/
    public static void makeDesiredMove(int indexForPlaying,char playerTurn)
    {
        if(board[indexForPlaying]==' ')
            board[indexForPlaying]=playerTurn;
        else
        {
            System.out.println("Unable to make the move");
        }
    }
    /*UC6*/
    public static int tossCoin()
    {
     int toss=(int)(Math.random()*10)%2;
     return USER;
     else
     return COMPUTER;
    }
    public static void main(String args[])
    {
    	System.out.println("Welcome to Tic Tac Toe Game");
    	Scanner sc=new Scanner(System.in);
        boardCreate();
        char choice=newTurn();
        displayBoard();
        System.out.println(tossCoin());
        int index=chooseIndex();
        makeDesiredMove(index,choice);
        displayBoard();
    }
}
