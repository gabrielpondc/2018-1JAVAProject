package piece;

import chessFrame.Frame;

import java.awt.*;

/**
 * A class to show movable places of the Knight on the chessboard.
 *
 * @author 서신악
 * @since 2018-06-07
 */
public class Knight implements Piece {
    @Override
    public void movePiece(Frame frame) {
        int i = frame.board.srcInfo.i;
        int j = frame.board.srcInfo.j;
        knightMove(frame, i - 2, j - 1);
        knightMove(frame, i - 1, j - 2);
        knightMove(frame, i + 1, j - 2);
        knightMove(frame, i + 2, j - 1);
        knightMove(frame, i - 2, j + 1);
        knightMove(frame, i - 1, j + 2);
        knightMove(frame, i + 1, j + 2);
        knightMove(frame, i + 2, j + 1);
    }

    @Override
    public void movablePiece(Frame frame, int i, int j) {
        knightMovable(frame, i - 2, j - 1);
        knightMovable(frame, i - 1, j - 2);
        knightMovable(frame, i + 1, j - 2);
        knightMovable(frame, i + 2, j - 1);
        knightMovable(frame, i - 2, j + 1);
        knightMovable(frame, i - 1, j + 2);
        knightMovable(frame, i + 1, j + 2);
        knightMovable(frame, i + 2, j + 1);
    }

    private void knightMove(Frame frame, int a, int b) {
        try {
            if(frame.board.boardInfo[a][b].pieceColor != null) {
                if (frame.game.ifAlly(frame.board.boardInfo[a][b].pieceColor, frame.board.thisTurn))
                    return;
                frame.board.iPanel[a][b].setBackground(new Color(255, 152, 142));
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {
        }
    }

    private void knightMovable(Frame frame, int a, int b) {
        try {
            if(frame.board.boardInfo[a][b].pieceColor != null) {
                if (frame.game.ifAlly(frame.board.boardInfo[a][b].pieceColor, frame.board.thisTurn))
                    return;
                frame.board.attackZone[a][b] = true;
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {
        }
    }
}

