package euler.utils;

import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.Fraction;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/15/11
 */
public class Util {
    private static final Integer ZERO = 0;

    public static long getFactorCount(long number, TreeSet<Long> primeNums) {
        long limit;
        long count;
        long size = 1;

        limit = (long) Math.sqrt((double) number);
        if (limit > primeNums.last()) {
            System.out.println("we have an issue");
        }
        for (long primeNum : primeNums) {
            if (primeNum <= limit || number > 1) {
                count = 0;
                while (number % primeNum == 0) {
                    count++;
                    number = number / primeNum;
                }
                if (count != 0) {
                    size = size * (count + 1);
                }
            } else {
                break;
            }
        }
        return size;
    }

    //Optimize the GetFactors algorithm
    public static HashSet<Long> getFactors(long number) {
        int incr;
        long limit;
        HashSet<Long> factors = new HashSet<>();
        factors.add(1L);
        factors.add(number);
        if (number % 2 == 0) {
            factors.add(2L);
            incr = 1;
            limit = number / 2;
        } else {
            incr = 2;
            limit = number / 3;
        }
        for (long j = 3; j <= limit; j = j + incr) {
            if (number % j == 0) {
                factors.add(j);
            }
        }
        return factors;
    }

    /*public static TreeSet<Long> getPrimeFactors(long number, TreeSet<Long> primeNums) {
        long limit;
        long num = number;
        TreeSet<Long> factors = new TreeSet<Long>();
        limit = (long) Math.sqrt((double) number);
        if (limit > primeNums.last()) {
            System.out.println("we have an issue");
        }
        for (long primeNum : primeNums) {
            if (primeNum <= limit) {
                if (number % primeNum == 0) {
                    factors.add(primeNum);
                    while (number % primeNum == 0) {
                        number = number / primeNum;
                    }
                    if (number == 1) {
                        break;
                    }
                }
            } else {
                if (number > 1) {
                    //it's a prime number
                    if (factors.size() == 0) {
                        factors.add(number);
                        return factors;
                    } else {
                        if (number % primeNum == 0) {
                            factors.add(primeNum);
                            while (number % primeNum == 0) {
                                number = number / primeNum;
                            }
                            if (number == 1) {
                                break;
                            }
                        }
                    }
                } else {
                    break;
                }
            }
        }
        if (number > 1) {
            System.out.println("We have an issue " + number);
        }
        return factors;
    }*/

    public static double phiFunction(long number, TreeSet<Long> primeNums) {
        long limit;

        limit = (long) Math.sqrt((double) number);
        /*if (limit > primeNums.last()) {
            System.out.println("we have an issue");
        }*/
        double phi = number;
        for (long primeNum : primeNums) {
            if (primeNum <= limit) {
                if (number % primeNum == 0) {
                    double temp = 1.0 / (double) primeNum;
                    temp = 1 - temp;
                    phi = phi * temp;
                    while (number % primeNum == 0) {
                        number = number / primeNum;
                    }
                    if (number == 1) {
                        return phi;
                    }
                }
            } else {
                break;
            }
        }
        if (number > 1) {
            double temp = 1.0 / (double) number;
            temp = 1 - temp;
            phi = phi * temp;
        }
        return phi;
    }

    public static HashMap<Long, Long> getPrimeFactorsWithExponent(long number, TreeSet<Long> primeNums) {
        long limit;
        HashMap<Long, Long> factors = new HashMap<>();
        if (number % 2 == 0) {
            limit = number / 2;
        } else {
            limit = number / 3;
        }
        for (long primeNum : primeNums) {
            if (primeNum <= limit) {
                while (number % primeNum == 0) {
                    if (factors.containsKey(primeNum)) {
                        factors.put(primeNum, factors.get(Long.valueOf(primeNum)) + 1);
                    } else {
                        factors.put(primeNum, 1L);
                    }
                    number = number / primeNum;
                }
            } else {
                break;
            }
        }
        return factors;
    }

    public static TreeSet<Long> getPrimeNumsByCount(long count) {
        TreeSet<Long> primeNums = new TreeSet<>();
        primeNums.add(2L);
        long i = 3;
        while (primeNums.size() < count) {
            boolean isPrime = isPrimeNumber(i, primeNums);
            if (isPrime) {
                //System.out.print(" " + i);
                primeNums.add(i);
                /*if (primeNums.size() % 20 == 0) {
                    System.out.println();
                }*/
            }
            i = i + 2;
        }
        return primeNums;
    }

    public static TreeSet<Long> getPrimeNumsByLimit(long limit) {
        TreeSet<Long> primeNums = new TreeSet<>();
        primeNums.add(2L);
        long i = 3;
        return Util.getPrimeNumsByLimit(i, limit, primeNums);
    }


    //Start should be greater than two
    public static TreeSet<Long> getPrimeNumsByLimit(long start, long limit,
                                                    TreeSet<Long> primeNums) {
        long i = start;
        if (i == 2 && i < limit) {
            primeNums.add(2L);
        }
        if (i % 2 == 0) {
            i++;
        }
        while (i < limit) {
            boolean isPrime = isPrimeNumber(i, primeNums);
            if (isPrime) {
                //System.out.print(" " + i);
                primeNums.add(i);
                /*if (primeNums.size() % 20 == 0) {
                    System.out.println();
                }*/
            }
            i = i + 2;
        }
        return primeNums;
    }

    public static boolean isPrimeNumber(long i, TreeSet<Long> primeNums) {
        boolean isPrime = true;
        double loop = Math.sqrt((double) i);
        for (long primeNum : primeNums) {
            if (primeNum > loop) {
                break;
            }
            if (i % primeNum == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static boolean isPrimeNumber(long num) {
        double loop = Math.sqrt((double) num);
        if (num != 2 && num % 2 == 0) {
            return false;
        }
        if (num != 5 && num % 5 == 0) {
            return false;
        }
        for (int i = 3; i <= loop; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long sum(HashSet<Long> numbers) {
        long sum = 0;
        for (Long number : numbers) {
            sum = sum + number;
        }
        return sum;
    }

    public static ArrayList<Integer> getDigits(long num) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add((int) (num % 10));
            num = num / 10;
        }
        return digits;
    }

    public static ArrayList<Integer> getDigits(String num) {
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            digits.add(Integer.valueOf(String.valueOf(num.charAt(i))));
        }
        return digits;
    }

    public static ArrayList<String> getDigitsString(long num) {
        ArrayList<String> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(String.valueOf((int) (num % 10)));
            num = num / 10;
        }
        return digits;
    }

    public static int getUniqueDigitCount(String num) {
        long number = Long.parseLong(num);
        HashSet<Integer> uniqueDigits = new HashSet<>();
        while (number > 0) {
            uniqueDigits.add((int) (number % 10));
            number = number / 10;
        }
        if (uniqueDigits.contains(ZERO)) {
            uniqueDigits.remove(ZERO);
        }
        return uniqueDigits.size();
    }

    /*public static boolean isPanDigital(String num)
    {
        String pattern = "[1-"+num.length()+"]{"+ num.length() + "," + num.length()+"}";
        return num.length() == getUniqueDigitCount(num) && num.matches(pattern);
    }*/

    public static boolean isPalindrome(long num) {
        return isPalindrome(String.valueOf(num));
    }

    public static boolean isPalindrome(String num) {
        StringBuilder s1 = new StringBuilder().append(num);
        return s1.toString().equals(s1.reverse().toString());
    }

    public static ArrayList<String> getPermutations(ArrayList<String> numbers) {
        return getPermutations(numbers, numbers.size());
    }

    public static ArrayList<String> getPermutations(ArrayList<String> numbers, int length) {
        ArrayList<String> permutations = new ArrayList<>();
        permutation(numbers, "", permutations, length, 0);
        return permutations;
    }

    public static ArrayList<String> getPermutationsWithRepetition(ArrayList<String> numbers, int length) {
        ArrayList<String> permutations = new ArrayList<>();
        permutationWithRepetition(numbers, "", permutations, length, 0);
        return permutations;
    }

    protected static void permutation(ArrayList<String> numbers, String num,
                                      ArrayList<String> permutations, int length, int loop) {
        if (loop == length) {
            permutations.add(num);
            return;
        }
        for (String number : numbers) {
            ArrayList<String> temp = new ArrayList<>();
            temp.addAll(numbers);
            temp.remove(number);
            permutation(temp, num + number, permutations, length, loop + 1);
        }
    }

    protected static void permutationWithRepetition(ArrayList<String> numbers, String num,
                                                    ArrayList<String> permutations, int length, int loop) {
        if (loop == length) {
            permutations.add(num);
            return;
        }
        for (String number : numbers) {
            permutationWithRepetition(numbers, num + number, permutations, length, loop + 1);
        }
    }

    public static ArrayList<String> getCombination(ArrayList<String> numbers, int length) {
        ArrayList<String> combinations = new ArrayList<>();
        combination(numbers, "", combinations, length, 0);
        return combinations;
            /*StringBuilder combination;
            ArrayList<String> combinations;
            ArrayList<String> temp = new ArrayList<String>();
            temp.addAll(numbers);
            if(length == numbers.size()){
                combinations = new ArrayList<String>();
                combination = new StringBuilder();
                for(String number: numbers){
                    combination.append(number);
                }
                combinations.add(combination.toString());
                return combinations;
            } else if (length == 1){
                return numbers;
            } else if (length == 0){
                combinations = new ArrayList<String>();
                combinations.add("");
                return combinations;
            }
            combinations = new ArrayList<String>();
            for(String number : numbers){
                if(temp.size() < length) break;

                temp.remove(number);
                int loop = 1;
                combination = new StringBuilder();
                combination.append(number);
                for(String num : temp){
                    combination.append(num);
                    loop++;
                    if(loop == length){
                        combinations.add(combination.toString());
                        combination = new StringBuilder();
                        combination.append(number);
                    }
                }
            }
            return combinations;*/
    }

    protected static void combination(ArrayList<String> numbers, String num,
                                      ArrayList<String> combinations, int length, int loop) {
        if (loop == length) {
            combinations.add(num);
            return;
        }
        /*if(loop + numbers.size() < length){
            return;
        }*/
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(numbers);
        for (String number : numbers) {
            temp.remove(number);
            combination(temp, num + number, combinations, length, loop + 1);
        }
    }


    public static TreeSet<Long> getTriangleNumbersByCount(long count) {
        TreeSet<Long> triangleNums = new TreeSet<>();
        for (long i = 1; i <= count; i++) {
            triangleNums.add((i * (i + 1)) / 2);
        }
        return triangleNums;
    }

    public static TreeSet<Long> getTriangleNumbersByLimit(long limit) {
        TreeSet<Long> triangleNums = new TreeSet<>();
        long num, i = 0;
        while (true) {
            num = (i * (i + 1)) / 2;
            if (num < limit) {
                triangleNums.add(num);
                i++;
            } else {
                break;
            }
        }
        return triangleNums;
    }

    /*public static TreeSet<Long> GetSquareNumbersByCount(long count){
        TreeSet<Long> nums = new TreeSet<Long>();
        for(long i = 1 ; i <= count ; i++){
            nums.add(i*i);
        }
        return nums;
    }*/

    public static TreeSet<Long> getSquareNumbersByLimit(long limit) {
        TreeSet<Long> nums = new TreeSet<>();
        long num, i = 0;
        while (true) {
            num = i * i;
            if (num < limit) {
                nums.add(num);
                i++;
            } else {
                break;
            }
        }
        return nums;
    }

    public static TreeSet<Long> getPentagonalNumbersByCount(long count) {
        TreeSet<Long> nums = new TreeSet<>();
        for (long i = 1; i <= count; i++) {
            nums.add((i * (3 * i - 1)) / 2);
        }
        return nums;
    }

    public static TreeSet<Long> getPentagonalNumbersByLimit(long limit) {
        TreeSet<Long> nums = new TreeSet<>();
        long num, i = 0;
        while (true) {
            num = (i * (3 * i - 1)) / 2;
            if (num < limit) {
                nums.add(num);
                i++;
            } else {
                break;
            }
        }
        return nums;
    }

    public static TreeSet<Long> getHexagonalNumbersByCount(long count) {
        TreeSet<Long> nums = new TreeSet<>();
        for (long i = 1; i <= count; i++) {
            nums.add(i * (2 * i - 1));
        }
        return nums;
    }

    public static TreeSet<Long> getHexagonalNumbersByLimit(long limit) {
        TreeSet<Long> nums = new TreeSet<>();
        long num, i = 0;
        while (true) {
            num = i * (2 * i - 1);
            if (num < limit) {
                nums.add(num);
                i++;
            } else {
                break;
            }
        }
        return nums;
    }

    /*public static TreeSet<Long> GetHeptagonalNumbersByCount(long count){
        TreeSet<Long> nums = new TreeSet<Long>();
        for(long i = 1 ; i <= count ; i++){
            nums.add((i*(5*i-3))/2);
        }
        return nums;
    }*/

    public static TreeSet<Long> getHeptagonalNumbersByLimit(long limit) {
        TreeSet<Long> nums = new TreeSet<>();
        long num, i = 0;
        while (true) {
            num = (i * (5 * i - 3)) / 2;
            if (num < limit) {
                nums.add(num);
                i++;
            } else {
                break;
            }
        }
        return nums;
    }

    /*public static TreeSet<Long> GetOctagonalNumbersByCount(long count){
        TreeSet<Long> nums = new TreeSet<Long>();
        for(long i = 1 ; i <= count ; i++){
            nums.add(i*(3*i-2));
        }
        return nums;
    }*/

    public static TreeSet<Long> getOctagonalNumbersByLimit(long limit) {
        TreeSet<Long> nums = new TreeSet<>();
        long num, i = 0;
        while (true) {
            num = i * (3 * i - 2);
            if (num < limit) {
                nums.add(num);
                i++;
            } else {
                break;
            }
        }
        return nums;
    }

    public static boolean isPentagonalNumber(long num) {
        /*
         * Formula derived from Pentagon number equation,
         * 3n^2 - n -2*num = 0, it's a quadratic equation
         * Hence by solving the quadratic formula we get,
         * n = (1 (+/-) sqrt(1+ 24*num))/6
         * Also, n should be a positive integer to be an pentagonal number
         * Therefore, we consider only, n = (1 + sqrt(1+ 24*num))/6
         */
        double root = Math.sqrt(1 + (24 * (double) num));
        return root == (double) (long) root && (1 + root) % 6 == 0;
    }

    public static boolean isTriangleNumber(long num) {
        /*
         * Formula derived from Triangle number equation,
         * n^2 + n - 2*num = 0, it's a quadratic equation
         * Hence by solving the quadratic formula we get,
         * n = (-1 (+/-) sqrt(1+ 8*num))/2
         * Also, n should be a positive integer to be an pentagonal number
         * Therefore, we consider only, n = (-1 + sqrt(1+ 8*num))/2
         */
        double root = Math.sqrt(1 + (8 * (double) num));
        return root == (double) (long) root && (root - 1) % 2 == 0;
    }

    public static boolean isHexagonalNumber(long num) {
        /*
         * Formula derived from Hexagonal number equation,
         * 2n^2 - n - num = 0, it's a quadratic equation
         * Hence by solving the quadratic formula we get,
         * n = (1 (+/-) sqrt(1+ 8*num))/4
         * Also, n should be a positive integer to be an pentagonal number
         * Therefore, we consider only, n = (1 + sqrt(1+ 8*num))/4
         */
        double root = Math.sqrt(1 + (8 * (double) num));
        return root == (double) (long) root && (1 + root) % 4 == 0;
    }

    public static long maxSumPath(int[] triangle) {
        long max = 0;
        int level = 0;
        int start, end, nodes;
        int nodesProcessed = 0;

        while (nodesProcessed < triangle.length) {
            start = (level * (level + 1)) / 2;
            end = start + level;
            nodes = end - start + 1;
            for (int i = start; i <= end; i++) {
                int temp1, temp2;
                temp1 = temp2 = triangle[i];
                if (i != start) {
                    temp1 = triangle[i] + triangle[i - nodes];
                }
                if (i != end) {
                    temp2 = triangle[i] + triangle[i - nodes + 1];
                }
                triangle[i] = temp1 > temp2 ? temp1 : temp2;
                if (max < triangle[i]) {
                    max = triangle[i];
                }
            }
            level++;
            nodesProcessed = (level * (level + 1)) / 2;
        }

        return max;
    }

    public static String sqrtForBigNum(String num) {
        //Validation
        if (null == num || num.length() == 0 || num.split("\\.").length > 2) {
            throw new IllegalArgumentException("Invalid number");
        }

        StringBuilder number = new StringBuilder();
        String[] parts = num.split("\\.");

        if (parts[0].length() % 2 != 0) {
            number.append(0);
        }
        number.append(parts[0]);
        number.append(".");
        if (parts.length > 1) {
            number.append(parts[1]);
            if (parts[1].length() % 2 != 0) {
                number.append(0);
            }
            number.append("00000000");
        } else {
            number.append("00000000000000");
        }
        StringBuilder p = new StringBuilder();
        long y;
        long c = 0;
        long x;
        int decimalPosition = -1;
        for (int i = 0; i < number.length(); i = i + 2) {
            String digit = number.substring(i, i + 2);
            if (digit.startsWith(".")) {
                i = i + 1;
                decimalPosition = p.length();
                digit = number.substring(i, i + 2);
            }

            if (p.length() == 0) {
                c = Integer.parseInt(digit);
                x = (long) Math.sqrt(c);
                y = x * x;
                c = c - y;
                p.append(x);
            } else {
                long pTemp = Long.parseLong(p.toString());
                c = Long.parseLong(String.valueOf(c) + digit);
                x = findX(c, pTemp);
                y = x * (20 * pTemp + x);
                p.append(x);
                c = c - y;
            }
            if (c < 0 || y < 0 || x < 0) {
                System.out.println("We have an issue");
            }
/*            if(c == 0){
                
            }
            return p.toString();*/
        }
        if (decimalPosition >= 0) {
            p.insert(decimalPosition, ".");
        }
        return p.toString();
    }

    protected static long findX(long c, long p) {
        long xTemp = c / (20 * p);
        long yTemp = xTemp * (20 * p + xTemp);
        long x = xTemp;
        while (yTemp > c) {
            xTemp--;
            yTemp = xTemp * (20 * p + xTemp);
            x = xTemp;
        }
        while (yTemp <= c) {
            x = xTemp;
            xTemp++;
            yTemp = xTemp * (20 * p + xTemp);
        }
        return x;
    }

    public static String getContinuedFractions(long i) {
        double sqrt = Math.sqrt(i);
        if (sqrt == (double) (long) sqrt) {
            return "";
        }
        int a = (int) sqrt;
        int limitNum = 0;
        int limitDenom = 0;
        int x = 0;
        int y = 1;
        int v = 1;
        Fraction z;
        StringBuilder sb = new StringBuilder();
        int period = 0;
        while (true) {
            sb.append(a);
            //(c-a) = v((sqrt + x) - ay)/y. Make v/y as a Fraction z. (vx-ay) as t
            z = new Fraction(v, y);
            int t = (z.getNumerator() * x - a * z.getDenominator());

            a = (int) ((z.getDenominator()) / (z.getNumerator() * sqrt + t));
            x = -t;
            y = ((int) (i) - (t * t)) * z.getNumerator();
            v = z.getDenominator();
            if (period == 0) {  //Set the limits
                sb.append(";");
                limitNum = v * x;
                limitDenom = y;
            } else if ((v * x) == limitNum && y == limitDenom) {
                // if you find the same numerator and the denominator,
                // then it means the pattern is repeating. Hence, break the loop.
                break;
            } else {
                sb.append(",");
            }
            period++;
        }
        return sb.toString();
    }

    public static BigFraction getConvergent(int term, String[] periods, int a0) {
        BigFraction sum = BigFraction.ZERO;
        int length = periods.length;
        for (int k = term; k >= 1; k--) {
            int curPos = (k - 1) % length;
            int temp = Integer.parseInt(periods[curPos]);
            sum = sum.add(temp);
            sum = sum.reciprocal();
        }
        sum = sum.add(a0);
        return sum;
    }

    public static String getSortedDigitsAsString(long num) {
        ArrayList<Integer> digits = Util.getDigits(num);
        Collections.sort(digits);
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }

    public static long gcd(long a, long b) {
        long r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    public static long dijkstra(SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph,
                                String source, String target, long initialWeight) {
        HashMap<String, Long> distance = new HashMap<>();
        HashMap<String, Long> previous = new HashMap<>();

        for (String vertex : graph.vertexSet()) {
            distance.put(vertex, Long.MAX_VALUE);
            previous.put(vertex, Long.MAX_VALUE);
        }

        distance.put(source, initialWeight);
        HashSet<String> Q = new HashSet<>();
        Q.addAll(graph.vertexSet());
        while (Q.size() != 0) {
            String u = "";
            long minDistance = Long.MAX_VALUE;
            for (Map.Entry<String, Long> temp : distance.entrySet()) {
                if (Q.contains(temp.getKey()) && temp.getValue() < minDistance) {
                    minDistance = temp.getValue();
                    u = temp.getKey();
                }
            }

            if (distance.get(u) == Long.MAX_VALUE) {
                break;
            }
            Q.remove(u);
            for (DefaultWeightedEdge edge : graph.outgoingEdgesOf(u)) {
                String v = graph.getEdgeTarget(edge);
                long alt = distance.get(u) + (long) graph.getEdgeWeight(edge);
                if (alt < distance.get(v)) {
                    distance.put(v, alt);
                }
                if (target.equals(v)) {
                    return distance.get(v);
                }
            }
        }
        //return distance;
        return 0;
    }

    public static long minDistInGraph(SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph,
                                      HashMap<String, Long> weights, List<String> sources, List<String> targets) {
        long minDist = Long.MAX_VALUE;
        for (String source : sources) {
            HashMap<String, Long> distance = new HashMap<>();
            for (String vertex : graph.vertexSet()) {
                distance.put(vertex, Long.MAX_VALUE);
            }
            long initialWeight = weights.get(source);
            distance.put(source, initialWeight);
            while (distance.size() != 0) {
                String u = "";
                long minDistance = Long.MAX_VALUE;
                for (Map.Entry<String, Long> temp : distance.entrySet()) {
                    if (temp.getValue() < minDistance) {
                        minDistance = temp.getValue();
                        u = temp.getKey();
                    }
                }

                if (distance.get(u) == Long.MAX_VALUE || distance.get(u) > minDist) {
                    break;
                }

                for (DefaultWeightedEdge edge : graph.outgoingEdgesOf(u)) {
                    String v = graph.getEdgeTarget(edge);
                    if (distance.containsKey(v)) {
                        long alt = distance.get(u) + (long) graph.getEdgeWeight(edge);
                        if (alt < distance.get(v)) {
                            distance.put(v, alt);
                        }
                        if (targets.contains(v)) {
                            if (distance.get(v) < minDist) {
                                minDist = distance.get(v);
                            }
                        }
                    }
                }
                distance.remove(u);
            }
        }
        return minDist;
    }
}
