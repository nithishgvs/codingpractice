package main.stack;

import org.junit.Test;

import java.util.Stack;

public class BaseballGame_682 {

    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "C":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "D":
                    if (!stack.isEmpty()) {
                        stack.push(2 * stack.peek());
                    }
                    break;
                case "+":
                    if (stack.size() >= 2) {
                        int first = stack.pop();
                        int second = stack.peek();
                        int newEntry = first + second;
                        stack.add(first);
                        stack.add(newEntry);
                    }
                    break;
                default:
                    stack.add(Integer.valueOf(operations[i]));
                    break;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;

    }

    @Test
    public void test(){
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
