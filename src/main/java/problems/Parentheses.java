package problems;

import data_structure.stack.Stack;
import data_structure.stack.StackImpl;

public class Parentheses {
    public static boolean check(String expression) {
        Stack<Character> paren = new StackImpl<Character>();
        char[] symbols = expression.toCharArray();
        for (char symbol : symbols) {
            if (symbol == '{' || symbol == '[' || symbol == '(') {
                paren.push(symbol);
            } else if (symbol == '}' || symbol == ']' || symbol == ')') {
                if (paren.isEmpty()) {
                    return false;
                } else if (!paren.peep().equals(matcher(symbol))) {
                    return false;
                } else {
                    paren.pop();
                }
            }
        }
        if (!paren.isEmpty()) {
            return false;
        }
        return true;
    }

    private static char matcher(char symbol) {
        switch (symbol) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
        }
        return ' ';
    }
}
