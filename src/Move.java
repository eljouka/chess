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
    
    
}
