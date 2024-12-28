package educative.stacks;

import java.util.Stack;

public class Calculator {
    public static int calculator(String expression) {
        int signValue = 1;
        int number = 0;
        int result = 0;
        int secondValue = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + Character.getNumericValue(c);
            } else if (c == '+' || c == '-') {
                result += number * signValue;
                if (c == '-')
                    signValue = -1;
                else
                    signValue = 1;
                number = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(signValue);
                result = 0;
                signValue = 1;
            } else if (c == ')') {
                result += signValue * number;
                int popSignValue = stack.pop();
                result *= popSignValue;

                secondValue = stack.pop();
                result += secondValue;
                number = 0;
            }
        }
        return result + number * signValue;
    }
}
