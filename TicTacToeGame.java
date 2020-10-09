import java.util.*;
public class Main
{
	static final int HEADS=0;
    static final int TAILS=1;
    static final String USER="USER";
    static final String COMPUTER ="COMPUTER";
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
    	System.out.println("Enter X or O as your Choice");
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
        int i;
            while(true)
            {
            i=a.nextInt();
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
    public static void makeDesiredMove(char board[],int indexForPlaying,char choiceXorO)
    {	
        if(board[indexForPlaying]==' ')
        {
            board[indexForPlaying]=choiceXorO;
        }
        else
            System.out.println("Unable to make the move");
    }
    /*UC6*/
    public static String checkWhoPlaysFirst()
    {
     int toss=(int)(Math.random()*10)%2;
     if(toss==HEADS)
     return USER;
     else
     return COMPUTER;
    }
    /*UC7*/
	public static String checkWinner(char board[],char choiceXorO) 
	{
		int i=1;
		int counter=0;
	   if((board[1]==choiceXorO && board[2]==choiceXorO && board[3]==choiceXorO)
		||(board[4]==choiceXorO && board[5]==choiceXorO && board[6]==choiceXorO)
		||(board[7]==choiceXorO && board[8]==choiceXorO && board[9]==choiceXorO)
		||(board[1]==choiceXorO && board[4]==choiceXorO && board[7]==choiceXorO)
		||(board[2]==choiceXorO && board[5]==choiceXorO && board[8]==choiceXorO)
		||(board[3]==choiceXorO && board[6]==choiceXorO && board[9]==choiceXorO)
		||(board[1]==choiceXorO && board[5]==choiceXorO && board[9]==choiceXorO)
		||(board[3]==choiceXorO && board[5]==choiceXorO && board[7]==choiceXorO))
		return "WIN";
	   for(i=1;i<10;i++)
	   {
		   if(board[i]!=' ')
			   counter++;
	   }
	   if(counter==9)
		   return "TIE";
	   else
		   return "TURN";
	}
	 public static void main(String args[])
    {
    	System.out.println("Welcome to Tic Tac Toe Game");
    	Scanner sc=new Scanner(System.in);
        boardCreate();
        char choiceXorO=newTurn();
        String FirstPlay=checkWhoPlaysFirst();
        System.out.println(FirstPlay+" plays First.");
        if(FirstPlay.matches("USER"))
        {
        int index=chooseIndex();
        makeDesiredMove(board,index,choiceXorO);
        }
        System.out.println(checkIfICouldWinAndGetIndex(board, choiceXorO));	
        System.out.println(checkWinner(board, choiceXorO));
        displayBoard();
    }
}
