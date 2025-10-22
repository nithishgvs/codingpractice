package main.stack;

import org.junit.Test;

import java.util.Stack;
import java.util.stream.Collectors;

public class MakeTheStringGreat_1544 {

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && shouldRemove(ch, stack.peek())) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder(stack.size());
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean shouldRemove(char current, char top) {
        return Character.toLowerCase(current) == Character.toLowerCase(top)
                && current != top;
    }

    @Test
    public void test() {
        System.out.println(makeGood("leEeetcode"));
    }
}
