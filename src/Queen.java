public class Queen extends Piece {
    
    public Queen(boolean isLight) {
        super(isLight);
        this.name = "Q";
    }
    
    public boolean canMove(Tile dest) {
        return (super.leftright(dest) ^ super.updown(dest) || super.diag(dest));
    }
}