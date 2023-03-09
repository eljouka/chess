public class Board {
    public Tile[][] board;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK_BACKGROUND = "\033[0;30m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK = "\033[1;30m";
    public static final String ANSI_WHITE = "\033[1;97m";
    public Board() {
        this.board = new Tile[8][8];
        this.board = generateBoard();
    }
    // i : number
    // j : letter
    public Tile[][] generateBoard() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                board[j][i] = new Tile(j,i);
                board[j][i].set_letter(j);
                board[j][i].set_number(i);
    
            }
            if (board[0][i].get_number() == 0) {
                board[0][i].placePiece(new Rook(true));
                board[1][i].placePiece(new Knight(true));
                board[2][i].placePiece(new Bishop(true));
                board[3][i].placePiece(new Queen(true));
                board[4][i].placePiece(new King(true));
                board[5][i].placePiece(new Bishop(true));
                board[6][i].placePiece(new Knight(true));
                board[7][i].placePiece(new Rook(true));
            }
            if (board[0][i].get_number() == 7) {
                board[0][i].placePiece(new Rook(false));
                board[1][i].placePiece(new Knight(false));
                board[2][i].placePiece(new Bishop(false));
                board[3][i].placePiece(new Queen(false));
                board[4][i].placePiece(new King(false));
                board[5][i].placePiece(new Bishop(false));
                board[6][i].placePiece(new Knight(false));
                board[7][i].placePiece(new Rook(false));
            }
            
    
            if (board[0][i].get_number() == 1) {
                board[0][i].placePiece(new Pawn(true));
                board[1][i].placePiece(new Pawn(true));
                board[2][i].placePiece(new Pawn(true));
                board[3][i].placePiece(new Pawn(true));
                board[4][i].placePiece(new Pawn(true));
                board[5][i].placePiece(new Pawn(true));
                board[6][i].placePiece(new Pawn(true));
                board[7][i].placePiece(new Pawn(true));
            }
            if (board[0][i].get_number() == 6) {
                board[0][i].placePiece(new Pawn(false));
                board[1][i].placePiece(new Pawn(false));
                board[2][i].placePiece(new Pawn(false));
                board[3][i].placePiece(new Pawn(false));
                board[4][i].placePiece(new Pawn(false));
                board[5][i].placePiece(new Pawn(false));
                board[6][i].placePiece(new Pawn(false));
                board[7][i].placePiece(new Pawn(false));
            }
        }
        
        
        return board;
    }
    
    
    public void displayBoard() {
        System.out.println("");
        for (int i = 7; i >= 0; i--) {
            
            System.out.print((i) + "  ");
            
            for (int j = 0; j < 8; j++) {
                String colour;
                String pieceColour;
                if (board[j][i].isLight) {
                    colour = ANSI_WHITE_BACKGROUND;
                }
                else {
                    colour = ANSI_BLACK_BACKGROUND;
                }
                if (board[j][i].getPiece() == null) {
                    System.out.print(colour + "   " + ANSI_RESET);
                }
                else {
                    if (board[j][i].getPiece().isLight) pieceColour = ANSI_WHITE;
                    else pieceColour = ANSI_BLACK;
                    System.out.print(colour + " " + pieceColour + board[j][i].getPiece().name + " " + ANSI_RESET);
                }
            }
            System.out.println("");
    
        }
        System.out.println("\tA  B  C  D  E  F  G  H");
        System.out.println("\t0  1  2  3  4  5  6  7");
    }
    
    
    
}
