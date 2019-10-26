package game;

import chessFrame.Board;
import chessFrame.Frame;
import runtimeException.MoveException;

/**
 * A class to judge whether check, checkmate and stalemate or not.
 *
 * @author 곽태욱
 * @since 2018-06-07
 */
//가정 : 모든 플레이어의 킹은 잡힐 수 없음. 킹이 잡히면 스테일메이트(무승부).
public class Rule{
    //킹이 위험한 곳에 있으면 체크
    protected boolean ifCheck(Frame frame) {
        //보드 위에서
        for (int i = 0; i < Board.HEIGHT; i++) {
            for (int j = 0; j < Board.WIDTH; j++) {
                try {
                    //상대방 킹이
                    if (frame.board.boardInfo[i][j].pieceType.equals("king") && frame.game.ifEnemy(frame.board.thisTurn, frame.board.boardInfo[i][j].pieceColor)) {
                        //아군의 공격대상이면 체크
                        if (frame.board.attackZone[i][j])
                            return true;
                    }
                } catch (NullPointerException ignore) {}
            }
        }
        return false;
    }

    //킹이 위험한 곳에 있으면서 움직이지 못하면 체크메이트
    protected boolean ifCheckmate(Frame frame) {
        if(ifCheck(frame)) {
            return kingCannotMove(frame);
        }
        return false;
    }

    //킹이 위험한 곳엔 없지만 움직이지 못하면 스테일메이트
    protected boolean ifStalemate(Frame frame) {
        if(!ifCheck(frame))  {
            return kingCannotMove(frame);
        }
        return false;
    }

    protected boolean ifPromote(Frame frame) {

        return true;
    }

    //킹이 움직일 수 없는 경우는
    private boolean kingCannotMove(Frame frame) {
        //보드 위에서
        for (int i = 0; i < Board.HEIGHT; i++) {
            for (int j = 0; j < Board.WIDTH; j++) {
                try {
                    //상대방 킹의
                    if (frame.board.boardInfo[i][j].pieceType.equals("king") && frame.game.ifEnemy(frame.board.thisTurn, frame.board.boardInfo[i][j].pieceColor)) {
                        for (int a = -1; a < 2; a++) {
                            for (int b = -1; b < 2; b++) {
                                //(상대방 킹자리는 제외)
                                if (a == 0 && b == 0)
                                    continue;
                                try {
                                    //모든 이동가능한 위치에(8칸)
                                    if (frame.board.boardInfo[i + a][j + b].pieceColor != null) {
                                        //아군의 공격지점이 없거나 상대방 체스말이 없으면
                                        if (!frame.board.attackZone[i + a][j + b] || !frame.game.ifAlly(frame.board.boardInfo[i + a][j + b].pieceColor, frame.board.thisTurn))
                                            //움직일 수 있으니 거짓
                                            return false;
                                    }
                                } catch (ArrayIndexOutOfBoundsException ignore) {
                                }
                            }
                        }
                    }
                } catch (NullPointerException ignore) {}
            }
        }
        //상대방 킹의 이동가능한 위치가 모두 아군의 공격지점이거나 상대 체스말이 있으면 참
        return true;
    }
}
