package main.arrayshashing;

import org.junit.Test;

public class ReplaceElementswithGreatestElementonRightSide_1299 {


    public int[] replaceElements(int[] arr) {

        int maxSeenSoFar = -1;

        for (int i = arr.length - 1; i > -1; i--) {
            int temp = arr[i];
            arr[i] = maxSeenSoFar;
            maxSeenSoFar = Math.max(temp, maxSeenSoFar);
        }

        return arr;
    }

    @Test
    public void test1() {
        int[] arr = {17, 18, 5, 4, 6, 1};
        replaceElements(arr);
    }
}
