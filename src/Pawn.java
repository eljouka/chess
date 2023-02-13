public class Pawn extends Piece {
    
    public Pawn(boolean isLight) {
        super(isLight);
        this.name = "P";
    }
    
    public boolean canMove(Tile dest) {
        return (dest.get_number()-this.tile.get_number() == 1 && dest.get_letter()-this.tile.get_letter() == 0); // TODO: first move = 2, diag (for eating)
    }
}
