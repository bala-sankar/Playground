package educative.track;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicTacToe {
    List<Integer> rows;
    List<Integer> cols;
    int diagonal;
    int antiDiagonal;

    // TicTacToe class contains rows, cols, diagonal,
    // and anti_diagonal to create a board.
    // Constructor is used to create a board of size n * n.
    public TicTacToe(int n) {
        this.rows = new ArrayList<>(Collections.nCopies(n, 0));
        this.cols = new ArrayList<>(Collections.nCopies(n, 0));
        diagonal = 0;
        antiDiagonal = 0;
    }

    // move will be used to play a move by a specific player and identify who
    // wins at each move
    public int move(int row, int col, int player) {
        int currentPlayer = player == 1 ? 1 : -1;
        int size = rows.size();
        rows.set(row, rows.get(row) + currentPlayer);
        cols.set(col, cols.get(col) + currentPlayer);
        if (row == col) {
            diagonal += currentPlayer;
        }
        if (row + col == size - 1) {
            antiDiagonal += currentPlayer;
        }
        if (Math.abs(rows.get(row)) == size || Math.abs(cols.get(col)) == size
                || Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size) {
            return player;
        }
        return 0;
    }
}
