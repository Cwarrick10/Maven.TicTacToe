package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    Character[][] board;
    public Board(Character[][] matrix) {
        board = matrix;
    }
    private Boolean isInFavorOfChar(Character c) {
        int[] turn = new int[8];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == c) {
                    turn[row]++;
                    turn[col + 3]++;
                    turn[7] = (row + col == 2) ? ++turn[7] : turn[7];
                    turn[6] = (row == col) ? ++turn[6] : turn[6];
                }
            }
        }
        for (int i : turn) {
            if (i == 3) {
                return true;
            }
        }
        return false;
    }

    public Boolean isInFavorOfX() {
        return isInFavorOfChar('X');
    }

    public Boolean isInFavorOfO() {
        return isInFavorOfChar('O');
    }

    public Boolean isTie() {
        return !(isInFavorOfX() || isInFavorOfO() );
    }

    public String getWinner() {
        for(int i= 0; i < 3; i++) {
            if (isInFavorOfX()) {
                return "X";
            }
            if (isInFavorOfO()) {
                return "O";
            }
        }

        return "";
    }

}
