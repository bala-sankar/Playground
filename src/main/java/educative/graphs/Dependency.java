package educative.graphs;

public class Dependency {
    static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return true; // No courses to finish
        }

        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }

        int count = 0;
        while (true) {
            int current = -1;
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    current = i;
                    break;
                }
            }

            if (current == -1) {
                break; // No more courses with zero in-degree
            }

            count++;
            inDegree[current] = -1; // Mark as processed

            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == current) {
                    inDegree[prerequisite[0]]--;
                }
            }
        }

        return count == numCourses; // All courses can be finished
    }

}
