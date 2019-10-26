package piece;


import chessFrame.Board;
import chessFrame.Frame;
import runtimeException.MoveException;

import java.awt.*;

/**
 * A class to show movable places of the Pawn on the chessboard.
 *
 * @author 곽태욱
 * @since 2018-06-07
 */
public class Pawn implements Piece {
    @Override
    public void movePiece(Frame frame) {
        int i = frame.board.srcInfo.i;
        int j = frame.board.srcInfo.j;
        switch (frame.board.srcInfo.pieceColor) {
            case "White":
                pawnAttack(frame, i - 1, j - 1);
                pawnAttack(frame, i - 1, j + 1);
                pawnMove(frame, i - 1, j);
                if (i == Board.HEIGHT - 2) { //폰이 처음 움직일 때
                    try {
                        if (frame.game.ifEnemy(frame.board.boardInfo[i - 1][j].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        if (frame.game.ifAlly(frame.board.boardInfo[i - 1][j].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        if (frame.game.ifEnemy(frame.board.boardInfo[i - 2][j].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        if (frame.game.ifAlly(frame.board.boardInfo[i - 2][j].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        frame.board.iPanel[i-2][j].setBackground(new Color(255, 152, 142));
                    } catch (ArrayIndexOutOfBoundsException | MoveException | NullPointerException ignore) {
                    }
                }
                break;
            case "Black":
                pawnAttack(frame, i + 1, j - 1);
                pawnAttack(frame, i + 1, j + 1);
                pawnMove(frame, i + 1, j);
                if (i == 1) { //폰이 처음 움직일 때
                    try {
                        if (frame.game.ifEnemy(frame.board.boardInfo[i + 1][j].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        if (frame.game.ifAlly(frame.board.boardInfo[i + 1][j].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        if (frame.game.ifEnemy(frame.board.boardInfo[i + 2][j].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        if (frame.game.ifAlly(frame.board.boardInfo[i + 2][j].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        frame.board.iPanel[i+ 2][j].setBackground(new Color(255, 152, 142));
                    } catch (ArrayIndexOutOfBoundsException | MoveException | NullPointerException ignore) {
                    }
                }
                break;
            case "Red":
                pawnAttack(frame, i - 1, j + 1);
                pawnAttack(frame, i + 1, j + 1);
                pawnMove(frame, i, j + 1);
                if (j == 1) { //폰이 처음 움직일 때
                    try {
                        if (frame.game.ifEnemy(frame.board.boardInfo[i][j + 1].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        if (frame.game.ifAlly(frame.board.boardInfo[i][j + 1].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        if (frame.game.ifEnemy(frame.board.boardInfo[i][j + 2].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        if (frame.game.ifAlly(frame.board.boardInfo[i][j + 2].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        frame.board.iPanel[i][j + 2].setBackground(new Color(255, 152, 142));
                    } catch (ArrayIndexOutOfBoundsException | MoveException | NullPointerException ignore) {
                    }
                }
                break;
            case "Green":
                pawnAttack(frame, i - 1, j - 1);
                pawnAttack(frame, i + 1, j - 1);
                pawnMove(frame, i, j - 1);
                if (j == Board.WIDTH - 2) { //폰이 처음 움직일 때
                    try {
                        if (frame.game.ifEnemy(frame.board.boardInfo[i][j - 1].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        if (frame.game.ifAlly(frame.board.boardInfo[i][j - 1].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        if (frame.game.ifEnemy(frame.board.boardInfo[i][j - 2].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        if (frame.game.ifAlly(frame.board.boardInfo[i][j - 2].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        frame.board.iPanel[i][j - 2].setBackground(new Color(255, 152, 142));
                    } catch (ArrayIndexOutOfBoundsException | MoveException | NullPointerException ignore) {
                    }
                }
                break;
            default:
                System.out.println("등록되지 않은 사용자입니다...");
        }
    }

    @Override
    public void movablePiece(Frame frame, int i, int j) {
        switch (frame.board.boardInfo[i][j].pieceColor) {
            case "White":
                pawnAttackable(frame, i - 1, j - 1);
                pawnAttackable(frame, i - 1, j + 1);
                break;
            case "Black":
                pawnAttackable(frame, i + 1, j - 1);
                pawnAttackable(frame, i + 1, j + 1);

                break;
            case "Red":
                pawnAttackable(frame, i - 1, j + 1);
                pawnAttackable(frame, i + 1, j + 1);

                break;
            case "Green":
                pawnAttackable(frame, i - 1, j - 1);
                pawnAttackable(frame, i + 1, j - 1);
                break;
            case "":
                break;
            default:
                System.out.println("등록되지 않은 사용자입니다... piece.Pawn.movablePiece()");
        }

    }

    private void pawnAttack(Frame frame, int a, int b) {
        try {
            if (frame.game.ifEnemy(frame.board.boardInfo[a][b].pieceColor, frame.board.thisTurn))
                frame.board.iPanel[a][b].setBackground(new Color(255, 152, 142));
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ignore) {}
    }

    private void pawnAttackable(Frame frame, int a, int b) {
        try {
            if (frame.game.ifEnemy(frame.board.boardInfo[a][b].pieceColor, frame.board.thisTurn))
                frame.board.attackZone[a][b] = true;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ignore) {}
    }

    private void pawnMove(Frame frame, int a, int b) {
        try {
            if(frame.game.ifEnemy(frame.board.boardInfo[a][b].pieceColor, frame.board.thisTurn))
                return;
            if(frame.game.ifAlly(frame.board.boardInfo[a][b].pieceColor, frame.board.thisTurn))
                return;
            frame.board.iPanel[a][b].setBackground(new Color(255, 152, 142));
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ignore) {}
    }
}
