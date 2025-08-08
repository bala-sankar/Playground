package educative.graphs;

public class FriendDistance {
    public static int friendDistance(int[][] friends, int userA, int userB) {
        if (friends == null || friends.length == 0 || userA < 0 || userB < 0 || userA >= friends.length || userB >= friends.length) {
            return -1; // Invalid input
        }

        boolean[] visited = new boolean[friends.length];
        return dfs(friends, userA, userB, visited, 0);
    }

    private static int dfs(int[][] friends, int current, int target, boolean[] visited, int distance) {
        if (current == target) {
            return distance; // Found the target user
        }

        visited[current] = true; // Mark the current user as visited
        int minDistance = Integer.MAX_VALUE;

        for (int friend : friends[current]) {
            if (!visited[friend]) {
                int result = dfs(friends, friend, target, visited, distance + 1);
                if (result != -1) {
                    minDistance = Math.min(minDistance, result);
                }
            }
        }

        visited[current] = false; // Unmark the current user for other paths
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance; // Return -1 if no path found
    }
}
