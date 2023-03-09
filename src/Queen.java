public class Queen extends Piece {
    
    public Queen(boolean isLight) {
        super(isLight);
        this.name = "Q";
    }
    
    public boolean canMove(Tile dest) {
        System.out.println("trying to move the queen diagonally: "+ super.diag(dest)) ;
        return (super.leftright(dest) ^ super.updown(dest) || super.diag(dest));
    }
}