import java.util.*;
public class TicTacToeGame
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
	/*UC8*/
	public static int checkIfICouldWinAndGetIndex(char board[],char computerChoice)
	{
		int index=0;
		char dummyBoard[]=new char[10];
		for(int i=1;i<10;i++)
		dummyBoard[i]=board[i];
		for(int i=1;i<10;i++)
		{
		if(dummyBoard[i]==' ')
			{
			dummyBoard[i]=computerChoice;
			if(checkWinner(dummyBoard,computerChoice).equals("WIN"))
			{
			index=i;
			return index;
			}
			else
				dummyBoard[i]=' ';
			}
		}
		return 0;
	}
	/*UC9*/
	public static int computerChecksIndexToBlockWin(char board[],char opponentXorO)
	{	
		int index=0;
		char dummyBoard[]=new char[10];
		for(int i=1;i<10;i++)
			dummyBoard[i]=board[i];
		for(int i=1;i<10;i++)
		{
			if(dummyBoard[i]==' ')
			{
				dummyBoard[i]=opponentXorO;
				if(checkWinner(dummyBoard,opponentXorO).equals("WIN"))
				{
					index=i;
					return index;
				}
				else
					dummyBoard[i]=' ';
			}
		}
		return 0;
	}
	/*UC10*/
	public static int computerMoveForCorners(char board[])
	{
		int index=0;
		int cornerIndex[]= {1,3,7,9};
		for(int i=0;i<4;i++)
		{
			if(board[cornerIndex[i]]==' ')
				{
				index=cornerIndex[i];
				break;
				}
		}
		return index;
	}
	/*UC11*/
	public static int computerMoveForOtherPlaces(char board[])
	{
		int index=5;
		if(board[index]==' ')
			index=5;
		else
		{
			for(int i=2;i<=8;i=i+2)
			{
				if(board[i]==' ')
					{
					index=i;
					break;
					}
			}
		}
		return index;
	}
	/*UC12 and Main Function*/
    public static void main(String args[])
    {
    	System.out.println("Welcome to Tic Tac Toe Game\n");
    	Scanner sc=new Scanner(System.in);
        boardCreate();
        int numberOfTurns=1;
        char choiceForUserAsOorX=newTurn();
        char computerChoice;
        char playerWhichPlays;
        if(choiceForUserAsOorX=='X')
        	computerChoice='O';
        else
        	computerChoice='X';
        String FirstPlay=checkWhoPlaysFirst();
        if(FirstPlay.matches("USER"))
        	playerWhichPlays=choiceForUserAsOorX; 
        else
        	playerWhichPlays=computerChoice;
        System.out.println(FirstPlay+" plays First.");
        while(numberOfTurns<=9)
        {
        	numberOfTurns++;
        	if(playerWhichPlays!=computerChoice)
        	{
        	int index=chooseIndex();
        	makeDesiredMove(board,index,choiceForUserAsOorX);
        	}
        	else
        	{
        		if(checkIfICouldWinAndGetIndex(board, computerChoice)!=0)
        		makeDesiredMove(board, checkIfICouldWinAndGetIndex(board, computerChoice), computerChoice);
        		else if(computerChecksIndexToBlockWin(board, choiceForUserAsOorX)!=0)
        		{
        			makeDesiredMove(board, computerChecksIndexToBlockWin(board, choiceForUserAsOorX), computerChoice);
        		}
        		else
        		{
        		int index=computerMoveForCorners(board);
        			if(index==0)
        			index=computerMoveForOtherPlaces(board);
        			makeDesiredMove(board,index, computerChoice);
        		}
        	}
        	displayBoard();
        	if(checkWinner(board, playerWhichPlays).matches("WIN"))
        	{
        		if(playerWhichPlays==computerChoice)
        			System.out.println("Winner is Computer");
        		else
        			System.out.println("Winner is User");
        			break;
        	}
        	else
        		System.out.println(checkWinner(board, playerWhichPlays));
        	if(playerWhichPlays=='X')
        		playerWhichPlays='O';
        	else
        		playerWhichPlays='X';
        }
    }
}
