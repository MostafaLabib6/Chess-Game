
package chess.pieces;

public abstract class Piece
{
    public final boolean IsWhite;
    public final PieceType Type;
    public final int Score;
    
    public final Object Representation;
    
    public Piece(boolean isWhite, Object representation, PieceType type, int score)
    {
        IsWhite = isWhite;
        Representation = representation;
        Type = type;
        Score = score;
    }
    
    public abstract boolean[][] GetValidMoves(int row, int column, Piece[][] tilesPieces);
}
