package euler.problems;

import java.util.HashSet;

public class Problem91 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        int n = 50;
        HashSet<String> coordinates = new HashSet<String>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                coordinates.add(i + "," + j);
            }
        }
        HashSet<String> anotherCoordinates = new HashSet<String>();
        anotherCoordinates.addAll(coordinates);
        long counter = 0;
        for (String coordinate : coordinates) {
            String[] aPoints = coordinate.split(",");
            int x1 = Integer.parseInt(aPoints[0]);
            int y1 = Integer.parseInt(aPoints[1]);
            anotherCoordinates.remove(coordinate);
            for(String anotherCoordinate : anotherCoordinates) {
                String[] bPoints = anotherCoordinate.split(",");
                int x2 = Integer.parseInt(bPoints[0]);
                int y2 = Integer.parseInt(bPoints[1]);
                long sideASqr = (x1 * x1) + (y1 * y1);
                long sideBSqr = (x2 * x2) + (y2 * y2);
                long sideCSqr = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
                if ((sideCSqr == (sideASqr + sideBSqr))
                        || (sideBSqr == (sideASqr + sideCSqr))
                        || (sideASqr == (sideBSqr + sideCSqr))) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
