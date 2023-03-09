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
    public boolean move() { //TODO: make this private (will use internally, not by user)
        System.out.println("this.dest.getPiece() == null " + (!this.dest.isOccupied()));
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
                if (!(piece instanceof Pawn) || ((Pawn) piece).pawnEat(dest))
                    doMove(piece, dest);
                else {
                    System.out.println("pawn can't eat vertically");
                    return false;
                }
                
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
