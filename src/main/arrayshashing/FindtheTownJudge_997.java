package main.arrayshashing;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class FindtheTownJudge_997 {

    public int findJudge(int n, int[][] trust) {

        int[] score = new int[n + 1];

        for (int[] t : trust) {
            //who trusts someone cant be judge
            score[t[0]]--;
            //who is being trusted will be the judge
            score[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }


    @Test
    public void test() {
        int[][] arr = {
                {1, 3},
                {2, 3}
        };
        System.out.println(findJudge(3, arr));
    }
}
