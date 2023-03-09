public class Move {
    private Piece piece;
    private Tile dest;
    public boolean canEat;
    
    public Move(Piece piece, Tile dest) {
        this.piece = piece;
        this.dest = dest;
        this.canEat = false;
    }
    
    public void doMove(Piece piece, Tile dest) {
        Tile old = piece.tile;
        piece.tile.set_letter(dest.get_letter());
        piece.tile.set_number(dest.get_number());
        System.out.println("success");
        old.removePiece(piece);
        dest.placePiece(piece);
    }
    public boolean isValidMove() { //TODO: make this private (will use internally, not by user)
        System.out.println("this.dest.getPiece() == null " + (!this.dest.isOccupied()));
        if (dest.get_letter() > 7 || dest.get_number() > 7) {
            System.out.println("destination out of bounds");
            return false;
        }
        if (!piece.canMove(dest)) { // if move doesn't follow piece's rule, automatic fail
            System.out.println("Failure: this move is not allowed for this piece");
            return false;
        }
        if (!this.dest.isOccupied()) {
            if (piece instanceof Pawn) {
                ((Pawn) piece).num_moves ++;
            }
            
            doMove(piece, dest);
            
            return true;
        }
        
        // eating a piece
        else {
            if (dest.getPiece().isLight != piece.isLight) { // just checking if not same colour
                doMove(piece, dest);
                
                dest.removePiece(dest.getPiece());
                System.out.println("ate");
                this.canEat = true;
                return true;
    
            }
        }
        return false;
        
        //TODO: if at any point along path cross over piece -> invalid (unless knight)
        //TODO: if pawn and land on piece, only eat if diag otherwise invalid
        
    }
    
}
