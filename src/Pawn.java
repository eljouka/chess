import static java.lang.Math.abs;

public class Pawn extends Piece {
    public int num_moves;
    
    public Pawn(boolean isLight) {
        super(isLight);
        this.name = "P";
        this.num_moves = 0;
    }
    
    public boolean canMove(Tile dest) {
        return (abs(dest.get_number()-this.tile.get_number()) == 1) || ((abs(dest.get_number()-this.tile.get_number()) == 2 && this.num_moves == 0) && dest.get_letter()-this.tile.get_letter() == 0); // TODO: first move = 2, diag (for eating)
    }
    
    public boolean pawnEat(Tile dest) {
        return diag(dest);
    }
}
