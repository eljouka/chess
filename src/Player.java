public class Player {
    public boolean isLight;
    //public int numMoves; // piece
    public String name;
    public boolean isTurn;
    
    public Player(boolean isLight, String name) {
        this.isLight = isLight;
        this.name = name;
        if (isLight) this.isTurn = true; // white goes first
    }
    
    
    
}
