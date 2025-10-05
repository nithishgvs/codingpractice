package main.heaps;

import org.junit.Test;

import java.util.PriorityQueue;

public class TheKWeakestRowsMatrix_1337 {

    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        for (int i = 0; i < mat.length; i++) {
            int binaryCount = binarySearchHelper(mat, i, 0, mat[0].length - 1);
            minHeap.add(new int[]{binaryCount, i});
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[1];
        }

        return result;
    }

    private int binarySearchHelper(int[][] mat, int rowIndex, int l, int h) {

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (mat[rowIndex][mid] == 0) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        return l;
    }

    @Test
    public void test() {
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };


        kWeakestRows(mat, 3);
    }
}
