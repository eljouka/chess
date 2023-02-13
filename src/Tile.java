public class Tile {
    private int letter;
    private int number;
    private Piece piece;
    public boolean isLight;
    public boolean isDark;
    
    public Tile(int letter, int number) {
        this.letter = letter;
        this.number = number ;
        this.piece = null;
        this.isLight = (letter + number) % 2 == 0;
        this.isDark = !(this.isLight);
    }
    
    // getters
    public int get_letter() {
        return this.letter;
    }
    
    public int get_number() {
        return this.number;
    }
    
    public Piece getPiece() {
        return this.piece;
    }
    
    // setters
    // coords in terms of where they are on the board (not in the list Tile[][])
    public void set_letter(int x_coord) {
        this.letter = x_coord;
    }
    
    public void set_number(int y_coord) {
        this.number = y_coord;
    }
    
    public boolean isOccupied() {
        return (this.piece != null);
    }
    public void placePiece(Piece piece) {
        this.piece = piece;
        this.piece.setTile(this);
    }
    
    public void removePiece(Piece piece) {
        piece.tile = null;
        this.piece = null;
        
    }
}
