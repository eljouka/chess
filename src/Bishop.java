public class Bishop extends Piece {
    
    public Bishop(boolean isLight) {
        super(isLight);
        this.name = "B";
    }
    
    public boolean canMove(Tile dest) {
        return super.diag(dest);
    }
}