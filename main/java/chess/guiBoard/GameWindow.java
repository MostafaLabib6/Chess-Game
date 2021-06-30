package chess.guiBoard;

import chess.pieces.Bishop;
import chess.pieces.Knight;
import chess.pieces.Piece;
import chess.pieces.PieceType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.border.EmptyBorder;

public class GameWindow
{
    private static final Color WHITE_TILE_COLOR = new Color(245, 230, 205);
    private static final Color BLACK_TILE_COLOR = new Color(205, 172, 129);
    
    private static final PiecesImages PIECES_IMAGES  = new PiecesImages();
    
    private final JFrame Frame;
    
    private final JLabel Player1NameLabel;
    private final JLabel Player1ScoreLabel;
    
    private final JLabel Player2NameLabel;
    private final JLabel Player2ScoreLabel;
    
    
    private final JButton[][] Tiles;
    private Piece[][] tilesPieces;
    
    private final ActionListener onTileActivation = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JButton tile = (JButton)e.getSource();
            String name = tile.getName();
            int num = Integer.parseInt(name, 4, name.length(), 10);
            int row = num / 8;
            int col = num % 8;
            System.out.println("row: " + row + " col: " + col);
            tile.setEnabled(false);
        }   
    };
    
    public GameWindow(String firstPlayerName, String secondPlayerName)
    {   
        Frame = new JFrame("Chess");
        Frame.setLayout(new GridLayout(1,1,5,5));
        Frame.setSize(720, 720);
        Frame.setResizable(false);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Draw Player Name Label and Player Score Label
        Player1NameLabel = new JLabel(firstPlayerName, SwingConstants.CENTER);
        Player1ScoreLabel = new JLabel("0", SwingConstants.CENTER);

        Player2NameLabel = new JLabel(secondPlayerName, SwingConstants.CENTER);
        Player2ScoreLabel = new JLabel("0", SwingConstants.CENTER);

        JPanel playersPanel = new JPanel(new GridLayout(1, 1, 7 , 7));
        playersPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel playersPanel1 = new JPanel(new GridLayout(2, 1, 5 , 5));
        playersPanel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        playersPanel1.setBackground(Color.GRAY);

        playersPanel1.add(Player1NameLabel, 0);
        playersPanel1.add(Player1ScoreLabel, 1);

        JPanel playersPanel2 = new JPanel(new GridLayout(2, 1, 5, 5));
        playersPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        playersPanel2.setBackground(Color.lightGray);

        playersPanel2.add(Player2NameLabel, 0);
        playersPanel2.add(Player2ScoreLabel, 1);

        playersPanel.add(playersPanel1, 0);
        playersPanel.add(playersPanel2, 1);

        playersPanel.setSize(640, 100);
        playersPanel.setBackground(Color.WHITE);

        JPanel playPanel = new JPanel(new GridLayout(8, 8, 0, 0));

        playPanel.setSize(560, 560);
        playPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        Tiles = new JButton[8][8];
        tilesPieces = new Piece[8][8];

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                Tiles[row][col] = new JButton();
                
                Tiles[row][col].setName("Tile" + (row * 8 + col));
                
                Tiles[row][col].addActionListener(onTileActivation);
                
                // Setting color according to the position
                if ((row + col) % 2 == 0)
                {
                    Tiles[row][col].setBackground(WHITE_TILE_COLOR);
                }
                else
                {
                    Tiles[row][col].setBackground(BLACK_TILE_COLOR);
                }

                Tiles[row][col].setBorderPainted(false);
                Tiles[row][col].setFocusPainted(false);
                playPanel.add(Tiles[row][col]);
            }
        }

        JPanel mainPanel = new JPanel(new BorderLayout(0, 0));
        mainPanel.setBorder(new EmptyBorder(4, 4, 4, 4));
        mainPanel.setSize(710, 710);

        mainPanel.add(playPanel, BorderLayout.CENTER);
        mainPanel.add(playersPanel, BorderLayout.SOUTH);

        Frame.getContentPane().add(mainPanel);

        //Window movement
        Frame.setLocationByPlatform(true);

        // Last thing to add.
        Frame.setVisible(true);
    }
    
    public void InitChessBoard()
    {
        
    }
    
    public void Run()
    {
    }
    
    public void Draw()
    {
        tilesPieces[0][0] = new Knight(true, PIECES_IMAGES.GetImage(true, PieceType.Knight));
        tilesPieces[0][1] = new Bishop(false, PIECES_IMAGES.GetImage(false, PieceType.Bishop));
        for (int row = 0; row < 8; ++row)
        {
            for (int col = 0; col < 8; ++col)
            {
                if (tilesPieces[row][col] != null)
                {
                    Tiles[row][col].setIcon((ImageIcon)tilesPieces[row][col].Representation);
                }
            }
        }
    }
}
