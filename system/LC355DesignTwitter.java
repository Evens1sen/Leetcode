package system;

import java.util.*;

public class LC355DesignTwitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1)); // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

    }

    static class Twitter {

        List<Tweet> tweets;
        Map<Integer, LinkedList<Tweet>> userTweets;
        Map<Integer, List<Integer>> userFollowings;

        public Twitter() {
            tweets = new ArrayList<>();
            userTweets = new HashMap<>();
            userFollowings = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            Tweet tweet = new Tweet(userId, tweetId, tweets.size());
            tweets.add(tweet);

            if (!userTweets.containsKey(userId)) {
                userTweets.put(userId, new LinkedList<>());
            }
            userTweets.get(userId).addFirst(tweet);

            if (!userFollowings.containsKey(userId)) {
                userFollowings.put(userId, new ArrayList<>());
            }
        }

        // Get the top k element from N sorted lists
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> followings = userFollowings.get(userId);
            List<LinkedList<Tweet>> targetLists = new ArrayList<>();
            for (Integer f : followings) {
                targetLists.add(userTweets.get(f));
            }
            targetLists.add(userTweets.get(userId));

            List<Integer> res = new ArrayList<>();
            PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
            List<Iterator<Tweet>> iters = new ArrayList<>();
            for (LinkedList<Tweet> lst : targetLists) {
                Iterator<Tweet> it = lst.iterator();
                iters.add(it);
                if (it.hasNext()) {
                    pq.add(it.next());
                }
            }

            // TODO
            while (!pq.isEmpty() && res.size() < 10) {
                res.add(pq.poll().tweetId);

            }

            return res;
        }

        public void follow(int followerId, int followeeId) {
            if (!userFollowings.containsKey(followerId)) {
                userFollowings.put(followerId, new ArrayList<>());
            }

            if (!userFollowings.containsKey(followeeId)) {
                userFollowings.put(followeeId, new ArrayList<>());
            }

            userFollowings.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            userFollowings.get(followerId).remove((Integer) followeeId);
        }

        public class Tweet {
            int tweetId;
            int userId;

            int time;

            public Tweet(int userId, int tweetId, int time) {
                this.tweetId = tweetId;
                this.userId = userId;
                this.time = time;
            }
        }
    }

}
