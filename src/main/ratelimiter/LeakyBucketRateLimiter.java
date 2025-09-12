package main.ratelimiter;

public class LeakyBucketRateLimiter {

    //Time stamp for last leak time
    private long lastLeakTimeStamp;
    //Total capacity of the water this bucket can hold
    private final int capacity;
    //Constant leak rate of water drops/requests
    private final int leakRate;
    //Current amount of water the bucket holds
    private int water;


    public LeakyBucketRateLimiter(int capacity, int leakRate) {
        this.lastLeakTimeStamp = System.currentTimeMillis();
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.water = 0;
    }


    private synchronized void leak() {

        long now = System.currentTimeMillis();
        long elapsedTime = now - lastLeakTimeStamp;
        long secondsElapsed = elapsedTime / 1000;
        int leakedRequests = (int) (secondsElapsed * leakRate);

        if (leakedRequests > 0) {
            int newWaterLevel = Math.max(0, water - leakedRequests);
            water = newWaterLevel;
            lastLeakTimeStamp += secondsElapsed * 1000; // advance by whole seconds to preserve subsecond remainder
        }
    }

    public synchronized boolean allowRequest() {
        leak();
        if (water < capacity) {
            water++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        LeakyBucketRateLimiter limiter = new LeakyBucketRateLimiter(5, 2);
        // capacity=5, leakRate=2 req/sec

        for (int i = 0; i < 10; i++) {
            if (limiter.allowRequest()) {
                System.out.println("✅ Request " + i + " processed");
            } else {
                System.out.println("❌ Request " + i + " rejected (bucket full)");
            }
            Thread.sleep(200); // simulate interval between requests
        }
    }
}
