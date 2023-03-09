abstract class Piece {
    // make abstract
    public Tile tile;
    public String name;
    
    public boolean isLight;
    
    public Piece(boolean isLight) {
        this.isLight = isLight;
    }
    public void setTile(Tile tile) {
        this.tile = tile;
    }
    public boolean diag(Tile dest) {
        try {
            int i = (dest.get_number() - this.tile.get_number()) / (dest.get_letter() - this.tile.get_letter());
        }
        catch (ArithmeticException e) {
            return false;
        }
        return (dest.get_number() - this.tile.get_number()) / (dest.get_letter() - this.tile.get_letter()) == 1;
    }
    public boolean updown(Tile dest) {
        return (dest.get_letter() == this.tile.get_letter());
    }
    public boolean leftright(Tile dest) {
        return (dest.get_number() == this.tile.get_number());
    }
    abstract boolean canMove(Tile dest);
    
}
