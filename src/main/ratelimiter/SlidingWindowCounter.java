package main.ratelimiter;

public class SlidingWindowCounter {
    private final int limit;       // max requests
    private final long windowSize; // window size in ms

    private long windowStart;      // start of current window
    private int currCount;         // count in current window
    private int prevCount;         // count in previous window

    public SlidingWindowCounter(int limit, long windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
        this.windowStart = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        long elapsed = now - windowStart;

        // if we've moved to a new window
        if (elapsed >= windowSize) {
            // shift current -> prev
            prevCount = currCount;
            currCount = 0;
            windowStart = now;
            elapsed = 0;
        }

        // how much of current window has passed
        double fraction = (double) elapsed / windowSize;
        double effectiveCount = currCount + prevCount * (1 - fraction);

        if (effectiveCount < limit) {
            currCount++;
            return true; // ✅ allow
        }
        return false; // ❌ reject
    }

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowCounter limiter = new SlidingWindowCounter(5, 1000);
        // 5 requests per 1s sliding window

        for (int i = 1; i <= 10; i++) {
            System.out.println("Request " + i + " -> " + limiter.allowRequest());
            Thread.sleep(200);
        }
    }
}
