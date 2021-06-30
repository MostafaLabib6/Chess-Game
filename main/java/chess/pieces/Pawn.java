package chess.pieces;

public class Pawn extends Piece {

    public Pawn(boolean isWhite, Object representation) {
        super(isWhite, representation, PieceType.Pawn, 1);
    }

    @Override
    public boolean[][] GetValidMoves(int row, int column, Piece[][] tilesPieces)
    {
        int newRow;
        int newCol;
        boolean[][] validMoves = new boolean[8][8];

        for (int i = 0; i < 8; ++i)
        {
            for (int j = 0; j < 8; j++) 
            {
                validMoves[i][j] = false;
            }
        }
        if (this.IsWhite)
        {
            newRow = row - 1;
            newCol = column + 1;
            if (tilesPieces[newRow][newCol] != null && tilesPieces[newRow][newCol].IsWhite != this.IsWhite)
            {
                validMoves[newRow][newCol] = true;
            }
            newRow = row - 1;
            newCol = column - 1;
            if (tilesPieces[newRow][newCol] != null && tilesPieces[newRow][newCol].IsWhite != this.IsWhite) 
            {
                validMoves[newRow][newCol] = true;
            }
            if (row == 6) 
            {
            for (int i = 1; i < 3; ++i) 
            {
                newRow = row - i;
                if (tilesPieces[newRow][column] == null)
                {
                    validMoves[newRow][column] = true;
                } else 
                {
                    break;
                }

            }

            }
            else {
                newRow = row - 1;
                if (newRow >= 0) 
                {
                if (tilesPieces[newRow][column] == null)
                {
                    validMoves[newRow][column] = true;
                }
                }

            }

        }
        if (!this.IsWhite) 
        {
        newRow = row + 1;
        newCol = column + 1;
        if (tilesPieces[newRow][newCol] != null && tilesPieces[newRow][newCol].IsWhite != this.IsWhite)
        {
            validMoves[newRow][newCol] = true;
        }
        newRow = row + 1;
        newCol = column - 1;
        if (tilesPieces[newRow][newCol] != null && tilesPieces[newRow][newCol].IsWhite != this.IsWhite)
        {
            validMoves[newRow][newCol] = true;
        }

        if (row == 1)
        {
            for (int i = 1; i < 3; ++i)
            {
                
            newRow = row + i;
            if (tilesPieces[newRow][column] == null)
            {
                validMoves[newRow][column] = true;
            } else
            {
                break;
            }
            }

        }
        else 
        {
        newRow = row + 1;
        if (newRow <= 7)
        {
        if (tilesPieces[newRow][column] == null) 
        {
            validMoves[newRow][column] = true;
        }
        }

        }

        }

        return validMoves;
    }

}
