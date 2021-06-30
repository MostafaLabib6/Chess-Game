package chess.guiBoard;

import chess.pieces.PieceType;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PiecesImages
{
    private final ImageIcon[] BlackPiecesImages;
    private final ImageIcon[] WhitePiecesImages;
    
    private static final String[] names = new String[]
    {
        "King", "Knight", "Bishop", "Queen", "Pawn", "Rook"
    };
    
    public PiecesImages()
    {
        BlackPiecesImages = new ImageIcon[6];
        WhitePiecesImages = new ImageIcon[6];
        
        for (int i = 0; i < names.length; ++i)
        {
            try
            {
                BlackPiecesImages[i] =
                        new ImageIcon(ImageIO.read(getClass().getResource("/Pieces/Black " + names[i] + ".png")));
                WhitePiecesImages[i] =
                        new ImageIcon(ImageIO.read(getClass().getResource("/Pieces/White " + names[i] + ".png")));
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public ImageIcon GetImage(boolean isWhite, PieceType type)
    {
        int index = 0;
        for (int i = 0; i < names.length; ++i)
        {
            System.out.println(type.toString());
            if (type.toString().equals(names[i]))
            {
                index = i;
                break;
            }
        }
        if (isWhite)
        {
            return WhitePiecesImages[index];
        }
        return BlackPiecesImages[index];
    }
}
