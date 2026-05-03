package main.binarysearch;

import org.junit.Test;

public class Searcha2DMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // We will treat the 2 d array as 1 dimensional array of length rows * cols
        int l = 0, h = (rows * cols )- 1;

        while (l <= h) {

            int mid = l + (h - l) / 2;

            int value = matrix[mid / cols][mid % cols];

            if (value == target)
                return true;
            else if (value < target)
                l = mid +1;
            else
                h= mid - 1;

        }
        return false;

    }


    @Test
    public void test() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };


        System.out.println(searchMatrix(matrix, 3));
    }
}
