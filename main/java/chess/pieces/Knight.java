
package chess.pieces;

public class Knight extends Piece
{
    public Knight(boolean isWhite, Object representation)
    {
        super(isWhite, representation, PieceType.Knight, 3);
    }
    
    @Override
    public boolean[][] GetValidMoves(int row, int column, Piece[][] tilesPieces)
    {
        boolean[][] validMoves = new boolean[8][8];
        for (int i = 0; i < 8; ++i)
        {
            for (int j = 0; j < 8; ++j)
            {
                validMoves[i][j] = false;
            }
        }
        int[] dRow = new int[]
        {
            -2, -2, 2, 2, 1, 1, -1, -1
        };
        int[] dCol = new int[]
        {
            1, -1, 1, -1, 2, -2, 2, -2
        };
        for (int k = 0; k < 8; ++k)
        {
            int newRow = row + dRow[k];
            int newCol = column + dCol[k];
            
            if (newRow < 0 || newRow > 7 || newCol < 0 || newCol > 7)
            {
                continue;
            }
            
            if (tilesPieces[newRow][newCol] == null)
            {
                validMoves[newRow][newCol] = true;
            }
            else if (tilesPieces[newRow][newCol].IsWhite != this.IsWhite)
            {
                validMoves[newRow][newCol] = true;
            }
        }
        return validMoves;
    }
    
}
