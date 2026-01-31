package blind75Sheet.stackParsing;

import java.util.Stack;

/**
 * Approach: Stack stores opening brackets
 */
public class ValidParenthesesSolution1 {
    public static void main(String[] args) {
        ValidParenthesesSolution1 obj = new ValidParenthesesSolution1();

        String s1 = "()";
        System.out.println("s1=" + s1 + ", result=" + obj.isValid(s1));

        String s2 = "()[]{}";
        System.out.println("s2=" + s2 + ", result=" + obj.isValid(s2));

        String s3 = "(]";
        System.out.println("s3=" + s3 + ", result=" + obj.isValid(s3));

        String s4 = "([])";
        System.out.println("s4=" + s4 + ", result=" + obj.isValid(s4));

        String s5 = "([)]";
        System.out.println("s5=" + s5 + ", result=" + obj.isValid(s5));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
