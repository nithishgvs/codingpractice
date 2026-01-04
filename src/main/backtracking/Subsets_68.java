package main.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Subsets_68 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int index, List<Integer> currentList) {
        result.add(new ArrayList<>(currentList));
        for (int i = index; i < nums.length; i++) {
            currentList.add(nums[i]);
            backtrack(result, nums, i + 1, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }

    @Test
    public void test() {
        subsets(new int[]{1, 2});

    }
}
