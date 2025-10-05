package main.stack;

import org.junit.Test;

import java.util.*;

public class IntervalListIntersections_986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        // Two pointers problem dont combine arrays we jumble entries
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {

            int max = Math.max(firstList[i][0], secondList[j][0]);
            int min = Math.min(firstList[i][1], secondList[j][1]);

            if (max <= min) {
                result.add(new int[]{max, min});
            }

            if (firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }


        return result.toArray(new int[result.size()][]);

    }


    @Test
    public void test() {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(intervalIntersection(firstList, secondList));
    }

    @Test
    public void test1() {
        int[][] firstList = {{8, 15}};
        int[][] secondList = {{2, 6}, {8, 10}, {12, 20}};
        System.out.println(intervalIntersection(firstList, secondList));
    }
}
