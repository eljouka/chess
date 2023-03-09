public class Game {
    private Player[] players;
    private Board board;
    private Player currTurn;
    private Status status;
    
    public Game(Player p1, Player p2) {
        board = new Board();
        this.players = new Player[2];
        
        this.players[0] = p1;
        this.players[1] = p2;
    
        // white goes first
        if (p1.isLight) {
            currTurn = p1;
        } else {
            currTurn = p2;
        }
        this.board.displayBoard();
    }
        
    public Status getStatus() {
        return this.status;
    }
    
    public Player getCurrTurn() {
        return this.currTurn;
    }
    
    public Board getBoard() {
        return this.board;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public boolean isEnd() {
        return (this.getStatus() == Status.LIGHT_WIN || this.getStatus() == Status.DARK_WIN);
    }
    
    public boolean move(Player player, Piece piece, Tile dest) { //TODO: make this private (will use internally, not by user)
        Move move = new Move(piece, dest);
        
        if (player != currTurn) {
            System.out.println("it is not your turn");
            return false;
        }
        
        if (dest.get_letter() > 7 || dest.get_number() > 7) {
            System.out.println("destination out of bounds");
            return false;
        }
        
        // checking if it can move
        // if pawn, checking if both move and eat
        // if eat then wont go in this block and automatically goes to eat block
        if (!piece.canMove(dest) || (piece instanceof Pawn && !piece.canMove(dest) && !((Pawn) piece).pawnEat(dest))) {
            System.out.println("Failure: this move is not allowed for this piece");
            return false;
        }
        
        if (!dest.isOccupied()) {
            if (piece instanceof Pawn) {
                ((Pawn) piece).num_moves ++;
            }
            
            move.doMove(piece, dest);
        }
        
        // checkmate
        else if (dest.getPiece() instanceof King) {
            if (player.isLight) {
                this.setStatus(Status.LIGHT_WIN);
            }
            else {
                this.setStatus(Status.DARK_WIN);
            }
        }
        
        // eating a piece
        else {
            if (dest.getPiece().isLight != piece.isLight) { // just checking if not same colour
                if (!(piece instanceof Pawn) || ((Pawn) piece).pawnEat(dest))
                    move.doMove(piece, dest);
                else {
                    System.out.println("pawn can't eat vertically");
                    return false;
                }
                
                System.out.println("ate");
                move.canEat = true;
            }
        }
        
        if (this.currTurn == players[0]) {
            this.currTurn = players[1];
        }
        else {
            this.currTurn = players[0];
        }
        
        return true;
        
        //TODO: if at any point along path cross over piece -> invalid (unless knight)
        
    }
    
}
