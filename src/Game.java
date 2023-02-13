import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // creates board
        // updates board
        // has methods for eat, checkmate, turn
        Player player1 = new Player(true,"player1");
        Player player2 = new Player(false,"player2");
        
        Board myboard = new Board();
        myboard.displayBoard();
        
        System.out.println("You are: Player1\nChoose your starting piece");
        
        int startLetter = new Scanner(System.in).nextInt();
        int startNum = new Scanner(System.in).nextInt();
        
        System.out.println("Choose your destination");
    
        int destLetter = new Scanner(System.in).nextInt();
        int destNum = new Scanner(System.in).nextInt();
        
        Move mymove = new Move(myboard.board[startLetter][startNum].getPiece(),myboard.board[destLetter][destNum]); // trying to move knight
        mymove.isValidMove();
        myboard.displayBoard();
    }
}