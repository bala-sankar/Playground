package euler.problems;

import euler.utils.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 5/15/12
 */
public class Problem68 extends Util {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        ArrayList<String> digits = new ArrayList<String>();
        digits.add("1");
        digits.add("2");
        digits.add("3");
        digits.add("4");
        digits.add("5");
        digits.add("6");
        digits.add("7");
        digits.add("8");
        digits.add("9");
        digits.add("0");
        ArrayList<String> outerNodesList = GetCircularPermutations(digits, 5);
        TreeSet<Long> result = new TreeSet<Long>();
        for (String outerNodes : outerNodesList) {
            if (!outerNodes.contains("0")) {
                continue;
            }
            if (outerNodes.length() != 5) {
                System.out.println("Node length should be 5");
                break;
            }
            int key = 6;
            HashMap<Integer, Integer> nodeMap = new HashMap<Integer, Integer>();
            ArrayList<String> temp = new ArrayList<String>();
            temp.addAll(digits);
            for (char a : outerNodes.toCharArray()) {
                int t = a - '0';
                if (t == 0) {
                    t = 10;
                }
                nodeMap.put(key, t);
                temp.remove(String.valueOf(a));
                key++;
            }
            ArrayList<String> innerNodesList = Util.getPermutations(temp);
            for (String innerNodes : innerNodesList) {
                key = 1;
                for (char a : innerNodes.toCharArray()) {
                    int t = a - '0';
                    nodeMap.put(key, t);
                    key++;
                }
                int sum1 = nodeMap.get(6) + nodeMap.get(1) + nodeMap.get(2);
                int sum2 = nodeMap.get(7) + nodeMap.get(2) + nodeMap.get(3);
                int sum3 = nodeMap.get(8) + nodeMap.get(3) + nodeMap.get(4);
                int sum4 = nodeMap.get(9) + nodeMap.get(4) + nodeMap.get(5);
                int sum5 = nodeMap.get(10) + nodeMap.get(5) + nodeMap.get(1);
                if (sum1 == sum2 &&
                        sum1 == sum3 &&
                        sum1 == sum4 &&
                        sum1 == sum5) {
                    String tempStr = nodeMap.get(6).toString() + nodeMap.get(1).toString() +
                            nodeMap.get(2).toString() + nodeMap.get(7).toString() +
                            nodeMap.get(2).toString() + nodeMap.get(3).toString() +
                            nodeMap.get(8).toString() + nodeMap.get(3).toString() +
                            nodeMap.get(4).toString() + nodeMap.get(9).toString() +
                            nodeMap.get(4).toString() + nodeMap.get(5).toString() +
                            nodeMap.get(10).toString() + nodeMap.get(5).toString() +
                            nodeMap.get(1).toString();
                    result.add(Long.parseLong(tempStr));
                }
            }
        }
        return result.last();
    }

    private static ArrayList<String> GetCircularPermutations(ArrayList<String> numbers, int length) {
        ArrayList<String> permutations = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<String>();
        temp.addAll(numbers);
        for (String number : numbers) {
            temp.remove(number);
            if (temp.size() < (length - 1)) {
                break;
            }
            permutation(temp, number, permutations, length, 1);
        }
        return permutations;
    }
}
