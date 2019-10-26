package piece;


import chessFrame.Frame;

/**
 * A class to show movable places of the Queen on the chessboard.
 *
 * @author 고가해
 * @since 2018-06-07
 */
public class Queen implements Piece {
    @Override
    public void movePiece(Frame frame) {
        new Rook().movePiece(frame);
        new Bishop().movePiece(frame);
    }

    @Override
    public void movablePiece(Frame frame, int i, int j) {
        new Rook().movablePiece(frame, i, j);
        new Bishop().movablePiece(frame, i, j);
    }
}