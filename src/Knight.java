import static java.lang.Math.abs;

public class Knight extends Piece {
    
    public Knight(boolean isLight) {
        super(isLight);
        this.name = "k";
    }
    
    public boolean canMove(Tile dest) {
        boolean case1 = (abs(dest.get_number()-this.tile.get_number())==2) && (abs(dest.get_letter()-this.tile.get_letter())==1);
        boolean case2 = (abs(dest.get_number()-this.tile.get_number())==1) && (abs(dest.get_letter()-this.tile.get_letter())==2);
        return (case1 || case2);
    }
}