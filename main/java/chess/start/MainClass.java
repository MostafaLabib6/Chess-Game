package chess.start;

import chess.guiBoard.GameWindow;

public class MainClass
{
    public static void main(String[] args)
    {
        GameWindow game = new GameWindow("P 1", "P 2");
        game.InitChessBoard();
        game.Draw();
        game.Run();
    }
}
