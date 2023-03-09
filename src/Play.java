import java.util.Scanner;

public class Play {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Chess! This is a 2-player game.");
        System.out.println("Player 1, what is your name?");
        String player1Name = new Scanner(System.in).nextLine();
        System.out.println("Player 2, what is your name?");
        String player2Name = new Scanner(System.in).nextLine();
    
    
        Player player1 = new Player(true, player1Name);
        Player player2 = new Player(false, player2Name);
        
        Game game = new Game(player1, player2);
        
        String message;
        String defaultMessage = game.getCurrTurn().name + ", please select a piece to move"; // once compiled, this stores player1 name only (doesn't change)
        message = defaultMessage;
    
        int startLetter;
        int startNum;
        
        int destLetter;
        int destNum;
        
        while (!game.isEnd()) {
            System.out.println(message);
            
            startLetter = new Scanner(System.in).nextInt();
            startNum = new Scanner(System.in).nextInt();
    
            try {
                boolean p = game.getCurrTurn().isSameColour(game.getBoard().board[startLetter][startNum].getPiece());
            }
            catch (NullPointerException npe) {
                message = "Please choose a tile with a piece";
                continue;
            }
            
            try {
                if (!game.getCurrTurn().isSameColour(game.getBoard().board[startLetter][startNum].getPiece())) {
                    throw new Exception ("WrongColour");
                }
            }
            catch (Exception e) {
                message = "You can only move a piece of your own colour. Please try again";
                continue;
            }
            
            
            System.out.println("Choose your destination");
    
            destLetter = new Scanner(System.in).nextInt();
            destNum = new Scanner(System.in).nextInt();
            
            game.move(game.getCurrTurn(), (game.getBoard().board[startLetter][startNum]).getPiece(), game.getBoard().board[destLetter][destNum]);
            game.getBoard().displayBoard();
            System.out.println("curr is: " + game.getCurrTurn().name);
            defaultMessage = game.getCurrTurn().name + ", please select a piece to move"; // need to rewrite here so that the curr name is updated
            message = defaultMessage;
    
        }
        
        if (game.getStatus() == Status.LIGHT_WIN) {
            System.out.println("Congratulations " + player1.name + "! You won the game :)");
        }
        else {
            System.out.println("Congratulations " + player2.name + "! You won the game :)");
        }
    }
}