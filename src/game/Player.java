package game;

/**
 * A class to store each player's information.
 *
 * @author 서신악
 * @since 2018-06-07
 */
public class Player {
    private String color;
    public boolean pieceDetail[] = new boolean[16];
    private int numberOfPiece;

    Player(String color) {
        this.color = color;
        numberOfPiece = pieceDetail.length;
        for (int i = 0; i < pieceDetail.length; i++) {
            pieceDetail[i] = true;
        }
    }

    public int getNumberOfPiece() {
        return numberOfPiece;
    }

    public void setNumberOfPiece(int numberOfPiece) {
        this.numberOfPiece = numberOfPiece;
    }

    public String getColor() {
        return color;
    }
}
