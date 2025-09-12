package main.ratelimiter;

public class FixedWindowRateLimiter {

    //Total number of allowed requests
    private final int maxRequests;

    //Window size 1000 ms like 1 minute
    private final long windowSizeMs;

    private long windowStart;

    private int currentRequestCount;


    public FixedWindowRateLimiter(int maxRequests, long windowSizeMs) {
        this.maxRequests = maxRequests;
        this.windowSizeMs = windowSizeMs;
        this.windowStart = System.currentTimeMillis();
        this.currentRequestCount = 0;
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        if (now - windowStart >= windowSizeMs) {
            //Passed the window so reset the requests and window start
            currentRequestCount = 0;
            windowStart = now;
        }

        if (currentRequestCount < maxRequests) {
            currentRequestCount += 1;
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        FixedWindowRateLimiter limiter = new FixedWindowRateLimiter(1, 1000);
        // 1 request per 1 second

        for (int i = 1; i <= 6; i++) {
            System.out.println("Request " + i + " -> " + limiter.allowRequest());
            Thread.sleep(200); // wait 200 ms between requests
        }


        System.out.println("--- Negative test: exceed limit ---");
        FixedWindowRateLimiter smallLimiter = new FixedWindowRateLimiter(2, 2000); // 2 requests per 2 sec
        for (int i = 1; i <= 4; i++) {
            System.out.println("Request " + i + " -> " + smallLimiter.allowRequest());
        }
    }
}
