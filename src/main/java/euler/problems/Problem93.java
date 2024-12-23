package euler.problems;

import euler.utils.Util;
import org.apache.commons.math3.fraction.Fraction;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem93 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static String solution1() {
        ArrayList<String> order = new ArrayList<>();
        order.add("0");
        order.add("1");
        order.add("2");
        order.add("3");
        ArrayList<String> orderOfNumbers = Util.getPermutations(order);
        ArrayList<String> operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        ArrayList<String> arithmeticOperators = Util.getPermutationsWithRepetition(operators, 3);
        ArrayList<String> digit = new ArrayList<>();
        digit.add("0");
        digit.add("1");
        digit.add("2");
        digit.add("3");
        digit.add("4");
        digit.add("5");
        digit.add("6");
        digit.add("7");
        digit.add("8");
        digit.add("9");
        ArrayList<String> numbers = Util.getCombination(digit, 4);
        ArrayList<String> bracket =  new ArrayList<>();
        bracket.add("1");
        bracket.add("2");
        bracket.add("3");

        int maxConsInteger = 0;
        String maxDigits = "";
        for(String number : numbers) {
            HashSet<Integer> results = new HashSet<>();
            for (String orderOfNumber : orderOfNumbers) {
                Fraction a = new Fraction(number.charAt(orderOfNumber.charAt(0) - '0') - '0');
                Fraction b = new Fraction(number.charAt(orderOfNumber.charAt(1) - '0') - '0');
                Fraction c = new Fraction(number.charAt(orderOfNumber.charAt(2) - '0') - '0');
                Fraction d = new Fraction(number.charAt(orderOfNumber.charAt(3) - '0') - '0');
                for (String arithmeticOperator : arithmeticOperators) {
                    Fraction result;
                    Fraction x;
                    Fraction y;

                    x = operate(a, b, arithmeticOperator.charAt(0));
                    y = operate(x, c, arithmeticOperator.charAt(1));
                    result = operate(y, d, arithmeticOperator.charAt(2));
                    if (result !=null && result.getDenominator() == 1 && result.intValue() > 0) {
                        results.add(result.intValue());
                    }

                    x = operate(a, b, arithmeticOperator.charAt(0));
                    y = operate(c, d, arithmeticOperator.charAt(1));
                    result = operate(x, y, arithmeticOperator.charAt(2));
                    if (result !=null && result.getDenominator() == 1 && result.intValue() > 0) {
                        results.add(result.intValue());
                    }
                }
            }
            for (int i = 1; i <= 100 ; i++){
                if(!results.contains(i)){
                    if(i-1 > maxConsInteger) {
                        maxConsInteger = i - 1;
                        maxDigits = number;
                    }
                    break;
                }
            }
        }
        return maxDigits;
    }

    private static Fraction operate (Fraction u, Fraction v, char operator){
        if(u == null || v==null){
            return null;
        }
        return switch (operator) {
            case '+' -> u.add(v);
            case '-' -> u.subtract(v);
            case '*' -> u.multiply(v);
            case '/' -> {
                if (v.equals(Fraction.ZERO)) {
                    yield null;
                }
                yield u.divide(v);
            }
            default -> null;
        };
    }
}
