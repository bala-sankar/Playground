package educative.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosest {
    public static List<Point> kClosest(Point[] points, int k) {
        PriorityQueue<Point> minHeap = new PriorityQueue<>((p1, p2)
                -> p2.distanceToOrigin() - p1.distanceToOrigin());
        for (Point point : points) {
            minHeap.add(point);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Write your code here
        public int distanceToOrigin() {
            return x * x + y * y;
        }
    }
}
