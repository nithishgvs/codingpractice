package main.backtracking;

import org.junit.Test;

import java.util.*;

public class SubsetsII_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        backTrack(nums, 0, set, new ArrayList<>());
        return new ArrayList<>(set);
    }

    private void backTrack(int[] nums, int index, Set<List<Integer>> set, List<Integer> currentList) {
        set.add(new ArrayList<>(currentList));
        for (int i = index; i < nums.length; i++) {
            //Add element which is the choice
            currentList.add(nums[i]);
            //Explore combinations
            backTrack(nums, i + 1, set, currentList);
            //Remove the choice
            currentList.remove(currentList.size() - 1);
        }
    }

    @Test
    public void test() {
        subsetsWithDup(new int[]{1, 2, 2});
    }
}
