package main.stack;

import org.junit.Test;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses_1190 {

    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                StringBuilder temp = new StringBuilder();

                // pop until '(' and collect chars
                while (!stack.isEmpty() && stack.peek() != '(') {
                    temp.append(stack.pop());
                }

                stack.pop(); // remove '('

                // push back reversed content
                for (char reversedChar : temp.toString().toCharArray()) {
                    stack.push(reversedChar);
                }
            } else {
                stack.push(ch);
            }
        }

        // build final string (stack has final order)
        StringBuilder result = new StringBuilder(stack.size());
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

    @Test
    public void test() {
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(abcd)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }
}
