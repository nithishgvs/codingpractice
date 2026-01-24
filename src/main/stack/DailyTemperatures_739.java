package main.stack;

import org.junit.Test;

import java.util.Stack;

public class DailyTemperatures_739 {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        stack.add(temperatures.length - 1);

        for (int i = temperatures.length - 2; i > -1; i--) {

            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    result[i] = stack.peek() - i;
                }
                stack.add(i);
            } else
                stack.add(i);
        }


        return result;

    }


    @Test
    public void test() {
        int[] temperatures = {30, 40, 50, 60};
        dailyTemperatures(temperatures);
    }
}
