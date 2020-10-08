import java.util.*;
public class TicTacToeGame
{
    static char[] board;
    Scanner sc=new Scanner(System.in);
    public void boardCreate()
    {
        board=new char[10];
        for(int i=1;i<10;i++)
        {
            board[i]=' ';
        }
    }
    public static void main(String args[])
    {
        TicTacToeGame obj=new TicTacToeGame();
        obj.boardCreate();
    }
}
