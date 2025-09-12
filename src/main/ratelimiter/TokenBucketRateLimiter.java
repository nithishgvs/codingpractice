package main.ratelimiter;

public class TokenBucketRateLimiter {

    //Bucket capacity
    private final int capacity;

    //Token bucket fill rate
    private final int fillRate;

    private long lastRequestTimeStamp;

    private int currentBucketCapacity;

    public TokenBucketRateLimiter(int capacity, int fillRate) {
        this.capacity = capacity;
        this.fillRate = fillRate;
        this.currentBucketCapacity = 0;
        this.lastRequestTimeStamp = System.currentTimeMillis();
    }


    private synchronized void bucketFill() {
        long now = System.currentTimeMillis();
        long elapsedSeconds = (now - lastRequestTimeStamp) / 1000;
        if (elapsedSeconds <= 0) {
            return;
        }

        long tokensToAdd = elapsedSeconds * (long) fillRate;
        long newLevel = currentBucketCapacity + tokensToAdd;
        if (newLevel >= capacity) {
            currentBucketCapacity = capacity; // cap to bucket size
        } else {
            currentBucketCapacity = (int) newLevel;
        }
        // advance by whole seconds only to preserve sub-second remainder
        lastRequestTimeStamp += elapsedSeconds * 1000;
    }

    public synchronized boolean allowRequest() {
        bucketFill();
        if (currentBucketCapacity > 0) {
            currentBucketCapacity -= 1; // consume one token
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(5, 2); // capacity=5, fillRate=2 tokens/sec
        //With your 300 ms spacing, elapsedSeconds is 0 for the first three/four calls, so no tokens are added and the requests are rejected until ≥1s has passed. At ~1.2s you add 2 tokens (fillRate=2), so requests 4 & 5 pass, then you run out again until the next whole second tick.
        for (int i = 0; i < 10; i++) {
            boolean allowed = limiter.allowRequest();
            System.out.println((allowed ? "✅" : "❌") + " Request " + i + (allowed ? " processed" : " rejected"));
            Thread.sleep(300); // 300ms between requests
        }

        System.out.println("--- Waiting 3 seconds to refill bucket ---");
        Thread.sleep(3000);

        for (int i = 10; i < 15; i++) {
            boolean allowed = limiter.allowRequest();
            System.out.println((allowed ? "✅" : "❌") + " Request " + i + (allowed ? " processed" : " rejected"));
        }
    }
}
