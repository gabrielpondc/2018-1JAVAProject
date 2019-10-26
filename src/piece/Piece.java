package piece;

import chessFrame.Frame;

/**
 * A class to run a chess game.
 *
 * @author 왕천용
 * @since 2018-06-07
 */
public interface Piece{
    void movePiece(Frame frame);
    void movablePiece(Frame frame, int i, int j);
}

