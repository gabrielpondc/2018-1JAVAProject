package piece;


import chessFrame.Frame;
import runtimeException.MoveException;

import java.awt.*;

/**
 * A class to show movable places of the King on the chessboard.
 *
 * @author 곽태욱
 * @since 2018-06-07
 */
public class King implements Piece {
    //frame.board.srcInfo.i; 클릭된 i위치
    //frame.board.srcInfo.j; 클릭된 j위치
    //frame.board.boardInfo[i][j] != null; 존재하는 체스판
    //frame.board.boardInfo[i][j].pieceColor != null; 2vs2에서 이동가능한 체스판
    @Override
    public void movePiece(Frame frame) {
        int i = frame.board.srcInfo.i;
        int j = frame.board.srcInfo.j;

        //킹 주위 색칠, 아군 말이 있거나 위험한 곳이면 갈 수 없음
        kingMove(frame, i, j);
    }

    @Override
    public void movablePiece(Frame frame, int i, int j) {
        kingMovable(frame, i, j);
    }

    private void kingMove(Frame frame, int i, int j) {
        for (int a = -1; a < 2; a++) {
            for (int b = -1; b < 2; b++) {
                try {
                    if(frame.board.boardInfo[i + a][j + b].pieceColor != null) {
                        if (frame.game.ifAlly(frame.board.boardInfo[i + a][j + b].pieceColor, frame.board.thisTurn) || frame.board.attackZone[i + a][j + b])
                            throw new MoveException();
                        frame.board.iPanel[i + a][j + b].setBackground(new Color(255, 152, 142));
                    }
                } catch (ArrayIndexOutOfBoundsException | MoveException ignore) {}
            }
        }
    }

    private void kingMovable(Frame frame, int i, int j) {
        for (int a = -1; a < 2; a++) {
            for (int b = -1; b < 2; b++) {
                try {
                    if(frame.board.boardInfo[i + a][j + b].pieceColor != null) {
                        if (frame.game.ifAlly(frame.board.boardInfo[i + a][j + b].pieceColor, frame.board.thisTurn) || frame.board.attackZone[i + a][j + b])
                            throw new MoveException();
                        frame.board.attackZone[i + a][j + b] = true;
                    }
                } catch (ArrayIndexOutOfBoundsException | MoveException ignore) {}
            }
        }
    }
}