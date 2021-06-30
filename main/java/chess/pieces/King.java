/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.pieces;

/**
 *
 * @author DELL
 */
public class King extends Piece {

    public King(boolean isWhite, Object representation) {
        super(isWhite, representation, PieceType.King, 0);
    }

    @Override
    public boolean[][] GetValidMoves(int row, int column, Piece[][] tilesPieces) {
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
            1, -1, 0, 0, 1, 1, -1, -1
        };
        int[] dCol = new int[]
        {
            0, 0, 1, -1, 1, -1, 1, -1
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
