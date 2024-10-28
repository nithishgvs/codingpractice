package main.binarysearch;

public class FirstBadVersion_278 {

    public int firstBadVersion(int n) {

        int l = 1;
        int h = n;

        int ans = -1;

        while (l <= h) {

            int mid = l + (h - l) / 2;

            if (isBadVersion(mid)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;

    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
