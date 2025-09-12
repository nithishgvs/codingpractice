package main.ratelimiter;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowLogRateLimiter {

    private final int limit;//Max Requests allowd
    private final long windowMs;// sliding window size in ms
    private Deque<Long> log;

    public SlidingWindowLogRateLimiter(int limit, long windowMs) {
        this.limit = limit;
        this.windowMs = windowMs;
        log = new ArrayDeque<>();
    }


    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        long cutOff = now - windowMs;

        //evict time stamps outside the window
        while (!log.isEmpty() && log.peek() <= cutOff) {
            log.removeFirst();
        }

        if (log.size() < limit) {
            log.addLast(now);
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        SlidingWindowLogRateLimiter rl = new SlidingWindowLogRateLimiter(3, 1000);
        for (int i = 1; i <= 6; i++) {
            System.out.println(i + " -> " + rl.allowRequest());
            Thread.sleep(200);
        }
    }
}
