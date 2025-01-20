package main.heaps;

import java.util.*;

public class DesignTwitter_355 {


    class Tweet {
        Integer time;
        Integer tweetId;

        public Tweet(Integer time, Integer tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    class Twitter {

        Map<Integer, Set<Integer>> userFollowerMap;
        Map<Integer, List<Tweet>> userTweets;

        int timeStamp = 0;

        public Twitter() {
            userFollowerMap = new HashMap<>();
            userTweets = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            if (!userTweets.containsKey(userId)) {
                userTweets.put(userId, new ArrayList<>());
            }
            userTweets.get(userId).add(new Tweet(++timeStamp, tweetId));
        }

        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> followeeIds = userFollowerMap.getOrDefault(userId, new HashSet<>());
            List<Integer> tweetList = new ArrayList<>();
            PriorityQueue<Tweet> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
            for (Integer followee : followeeIds) {
                if (!userTweets.getOrDefault(followee, new ArrayList<>()).isEmpty()) {
                    minHeap.addAll(userTweets.get(followee));
                }
            }
            if (!userTweets.getOrDefault(userId, new ArrayList<>()).isEmpty()) {
                minHeap.addAll(userTweets.get(userId));
            }

            while (!minHeap.isEmpty() && tweetList.size() < 10) {
                tweetList.add(minHeap.poll().tweetId);
            }

            return tweetList;
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> followeeIds = userFollowerMap.getOrDefault(followerId, new HashSet<>());
            followeeIds.add(followeeId);
            userFollowerMap.put(followerId, followeeIds);
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> followeeIds = userFollowerMap.getOrDefault(followerId, new HashSet<>());
            followeeIds.remove(Integer.valueOf(followeeId));
            userFollowerMap.put(followerId, followeeIds);
        }
    }

    public static void main(String[] args) {
        DesignTwitter_355 obj = new DesignTwitter_355();
        Twitter twitter = obj.new Twitter();
        twitter.postTweet(1, 4); // User 1 posts a new tweet (id = 5).
        twitter.postTweet(2, 5); // User 1 posts a new tweet (id = 5).
        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1);

    }
}
