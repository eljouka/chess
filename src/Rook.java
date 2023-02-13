public class Rook extends Piece {
    
    public Rook(boolean isLight) {
        super(isLight);
        this.name = "R";
    }
    
    public boolean canMove(Tile dest) {
        return (super.updown(dest) ^ super.leftright(dest));
    }
    
}
