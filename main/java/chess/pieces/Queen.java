
package chess.pieces;

public class Queen extends Piece {

    
    public Queen(boolean isWhite, Object representation)
    {
        super(isWhite, representation, PieceType.Queen, 9);
    }
    public boolean[][] GetValidMoves(int row, int column, Piece[][] tilesPieces) 
    {
        boolean[][] validMoves = new boolean[8][8];
    for(int i=0;i<8;++i)
    {
        for(int j=0;j<8;j++)
        {
        
               validMoves[i][j] = false;
        }
        
    }
    
        for(int k=1;k<8;++k)
        {
        int newRow=row+k;
        int newCol=column+k;
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
                break;
            }
        else if (tilesPieces[newRow][newCol].IsWhite == this.IsWhite)
            {
                break;
            }
        }
        
        for(int k=1;k<8;++k)
        {
        int newRow=row+k;
        int newCol=column-k;
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
                break;
            }
        else if (tilesPieces[newRow][newCol].IsWhite == this.IsWhite)
            {
                break;
            }
        }
        for(int k=1;k<8;++k)
        {
        int newRow=row-k;
        int newCol=column+k;
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
                break;
            }
        else if (tilesPieces[newRow][newCol].IsWhite == this.IsWhite)
            {
                break;
            }
        }
        for(int k=1;k<8;++k)
        {
        int newRow=row-k;
        int newCol=column-k;
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
                break;
            }
        else if (tilesPieces[newRow][newCol].IsWhite == this.IsWhite)
            {
                break;
            }
        }
         for(int i=0;i<8;++i)
    {
        for(int j=0;j<8;j++)
        {
        
               validMoves[i][j] = false;
        }
        
    }
    
        for(int k=1;k<8;++k)
        {
        int newRow=row+k;
        int newCol=column;
        if (newRow < 0 || newRow > 7 )
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
                break;
            }
        else if (tilesPieces[newRow][newCol].IsWhite == this.IsWhite)
            {
                break;
            }
        }
        
        for(int k=1;k<8;++k)
        {
        int newRow=row-k;
        int newCol=column;
        if (newRow < 0 || newRow > 7 )
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
                break;
            }
        else if (tilesPieces[newRow][newCol].IsWhite == this.IsWhite)
            {
                break;
            }
        }
        for(int k=1;k<8;++k)
        {
        int newRow=row;
        int newCol=column-k;
        if (newCol < 0 || newCol > 7)
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
                break;
            }
        else if (tilesPieces[newRow][newCol].IsWhite == this.IsWhite)
            {
                break;
            }
        }
        for(int k=1;k<8;++k)
        {
        int newRow=row;
        int newCol=column+k;
        if ( newCol < 0 || newCol > 7)
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
                break;
            }
        else if (tilesPieces[newRow][newCol].IsWhite == this.IsWhite)
            {
                break;
            }
        }
        return validMoves;
    }
}
