package educative.dynamic;

public class CountBits {
    public static int[] countingBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = countOnes(i);
        }
        return result;
    }

    private static int countOnes(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}
