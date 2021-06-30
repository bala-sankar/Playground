package problems;

public class Shuffle {
    public static void main(String[] args) {
        Shuffle s = new Shuffle();
//        System.out.println(s.solution(130));
//        System.out.println(s.solution(123456));
//        System.out.println(s.solution(1));
        System.out.println(s.solution(Integer.MAX_VALUE));
    }

    public int solution(int A) {
        // write your code in Java SE 8
        // From the problem - Integer is within the range [0...100,000,000]
        if (A < 0 || A > 100000000) {
            return -1;
        }
        return shuffle(Integer.toString(A));
    }

    public int shuffle(String number) {
        int i = 0, j = number.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i < j) {
            sb.append(number.charAt(i)).append(number.charAt(j));
            i++;
            j--;
        }
        if (i == j) {
            sb.append(number.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }
}
