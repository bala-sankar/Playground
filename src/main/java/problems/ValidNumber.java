package problems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumber {
    // Current State to Next State map
    private static final List<Map<String, Integer>> dfa = List.of(
            Map.of("digit", 1, "sign", 2, "dot", 3),
            Map.of("digit", 1, "dot", 4, "exponent", 5),
            Map.of("digit", 1, "dot", 3),
            Map.of("digit", 4),
            Map.of("digit", 4, "exponent", 5),
            Map.of("sign", 6, "digit", 7),
            Map.of("digit", 7),
            Map.of("digit", 7)
    );

    // These are all of the valid finishing states for our DFA.
    private static final Set<Integer> validFinalStates = Set.of(1, 4, 7);

    // regex - ^[+-]?(\d+|\d+\.\d*|\d*\.\d+)([eE][+-]?\d+)?$
    //DFA - docs/problems/ValidNumber/DFA.png
    public static boolean isNumber(String s) {
        int currentState = 0;
        String group = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                group = "digit";
            } else if (c == '+' || c == '-') {
                group = "sign";
            } else if (c == 'e' || c == 'E') {
                group = "exponent";
            } else if (c == '.') {
                group = "dot";
            } else {
                return false;
            }
            if (!dfa.get(currentState).containsKey(group)) {
                return false;
            }

            currentState = dfa.get(currentState).get(group);
        }
        return validFinalStates.contains(currentState);
    }

    public static boolean isNumberPattern(String s) {
        String patternString = "^[+-]?(\\d+|\\d+\\.\\d*|\\d*\\.\\d+)([eE][+-]?\\d+)?$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String input = "0";
        System.out.println("Result is : " + isNumber(input));
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        startTime = System.currentTimeMillis();
        System.out.println("Result is : " + isNumberPattern(input));
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        System.out.println("--------------------");

        input = "e";
        startTime = System.currentTimeMillis();
        System.out.println("Result is : " + isNumber(input));
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        startTime = System.currentTimeMillis();
        System.out.println("Result is : " + isNumberPattern(input));
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        System.out.println("--------------------");

        input = ".";
        startTime = System.currentTimeMillis();
        System.out.println("Result is : " + isNumber(input));
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        startTime = System.currentTimeMillis();
        System.out.println("Result is : " + isNumberPattern(input));
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        System.out.println("--------------------");

        input = ".1";
        startTime = System.currentTimeMillis();
        System.out.println("Result is : " + isNumber(input));
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        startTime = System.currentTimeMillis();
        System.out.println("Result is : " + isNumberPattern(input));
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        System.out.println("--------------------");
    }
}
