package main.arrayshashing;

import org.junit.Test;

public class MergeSortedArray_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index1 = m - 1, index2 = n - 1;

        int totalIndex = m + n - 1;


        while (index2 > -1) {
            if (index1 > -1 && nums1[index1] > nums2[index2]) {
                nums1[totalIndex] = nums1[index1];
                totalIndex--;
                index1--;
            } else {
                nums1[totalIndex] = nums2[index2];
                index2--;
                totalIndex--;
            }
        }


    }

    @Test
    public void test() {
        //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3

        merge(new int[]{2, 2, 3, 0, 0, 0}, 3, new int[]{1, 1, 1}, 3);
    }
}
