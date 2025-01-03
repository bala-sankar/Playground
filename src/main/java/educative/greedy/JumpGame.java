package educative.greedy;

public class JumpGame {
    public static boolean jumpGame(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
