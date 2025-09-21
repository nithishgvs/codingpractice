package main.stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DailyTemperatures_739 {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        stack.add(temperatures.length - 1);

        for (int i = temperatures.length - 2; i > -1; i--) {

            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }
            stack.add(i);
        }

        return result;
    }

    @Test
    public void test() {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(dailyTemperatures(input));
    }
}
