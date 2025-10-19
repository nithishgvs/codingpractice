package main.slidingwindow;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();

            deque.addLast(i);

            if (deque.peekFirst() <=i-k)
                deque.pollFirst();

            if (i + 1 >= k)
                result.add(nums[deque.peekFirst()]);

        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(maxSlidingWindow(nums, 3));
    }
}
