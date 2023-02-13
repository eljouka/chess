import static java.lang.Math.abs;

public class King extends Piece {
    
    public King(boolean isLight) {
        super(isLight);
        this.name = "K";
    }
    
    public boolean canMove(Tile dest) {
        return (
                (abs(this.tile.get_number()-dest.get_number()) == 1)
                ^ (abs(this.tile.get_letter()-dest.get_letter()) == 1)
                ^ ((abs((dest.get_number()-this.tile.get_number())/(dest.get_letter()-this.tile.get_letter())) == 1)
                        && (abs(this.tile.get_number()-dest.get_number()) == 1) && (abs(this.tile.get_letter()-dest.get_letter()) == 1))
                ); // TODO: and not check
    }
}