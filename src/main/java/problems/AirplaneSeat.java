package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AirplaneSeat {
    public int solution(int N, String S) {
        return seatAllocator(N, S);
    }

    // Number of rows
    private int seatAllocator(int N, String S) {
        List<Seat> reservedSeats = new ArrayList<>();
        SeatUtil util = new SeatUtil(N);
        for(String s: S.split("\\s")) {
            reservedSeats.add(new Seat(s));
        }

        return util.maxFourSeater(reservedSeats);
    }
    class Seat {
        int row;
        char column;

        Seat (String s) {
            // column
            // Add validation to check if it's between A-K and excluding I
            column = s.charAt(s.length()-1);
            row = Integer.parseInt(s.substring(0, s.length()-1));
        }

        Seat (int row, char col) {
            this.column = col;
            this.row = row;
        }

        int getRow() {
            return this.row;
        }

        int getColumn() {
            return this.column;
        }

        public String toString() {
            return Integer.toString(row) + Character.toString(column);
        }
    }

     class SeatUtil {
        final List<Character> columns = new ArrayList<>();
        {
            columns.add('A');
            columns.add('B');
            columns.add('C');
            columns.add('D');
            columns.add('E');
            columns.add('F');
            columns.add('G');
            columns.add('H');
            columns.add('J');
            columns.add('K');
        }
        List<Seat> seats;
        int rows;

        SeatUtil(int rows){
            this.rows = rows;
            seats = new ArrayList<>();
            for (int i=1; i<=rows; i++) {
                for(char col: columns) {
                    seats.add(new Seat(i, col));
                }
            }
        }

        int maxFourSeater(List<Seat> reserverdSeats) {
            // valid 4 seat combination
            // Q1 - BCDE, Q2 - DEFG, Q3 - FGHJ

            // Set reservedSeats for easy check
            Set<String> resSeat = new HashSet<>();

            return 0;
        }
    }
}
