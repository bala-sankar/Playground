package educative.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinRemoveParentheses {
    public static String minRemoveParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> invalidIndexes = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    invalidIndexes.add(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            invalidIndexes.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndexes.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveParentheses("lee(t(c)o)de)"));
        System.out.println(minRemoveParentheses("a)b(c)d"));
        System.out.println(minRemoveParentheses("))(("));
        System.out.println(minRemoveParentheses("(a(b(c)d)"));
    }
}
