package educative.fastandslowpointers;

public class HappyNumber {
    public static boolean isHappyNumber(int n) {
        int slow = n;
        int fast = sumOfSquaredDigits(n);
        if (n == 1) {
            return true;
        }
        while (slow != fast) {
            slow = sumOfSquaredDigits(slow);
            fast = sumOfSquaredDigits(sumOfSquaredDigits(fast));
            if (fast == 1) {
                return true;
            }
        }
        return false;
    }

    private static int sumOfSquaredDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = (n % 10);
            sum = sum + (digit * digit);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("28: " + isHappyNumber(28));
        System.out.println("4: " + isHappyNumber(4));
    }
}
