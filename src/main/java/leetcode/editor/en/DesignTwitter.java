package leetcode.editor.en;

//Design a simplified version of Twitter where users can post tweets, follow/
//unfollow another user, and is able to see the 10 most recent tweets in the user's 
//news feed. 
//
// Implement the Twitter class: 
//
// 
// Twitter() Initializes your twitter object. 
// void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId 
//by the user userId. Each call to this function will be made with a unique 
//tweetId. 
// List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs 
//in the user's news feed. Each item in the news feed must be posted by users who 
//the user followed or by the user themself. Tweets must be ordered from most 
//recent to least recent. 
// void follow(int followerId, int followeeId) The user with ID followerId 
//started following the user with ID followeeId. 
// void unfollow(int followerId, int followeeId) The user with ID followerId 
//started unfollowing the user with ID followeeId. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", 
//"unfollow", "getNewsFeed"]
//[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
//Output
//[null, null, [5], null, null, [6, 5], null, [5]]
//
//Explanation
//Twitter twitter = new Twitter();
//twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 
//tweet id -> [5]. return [5]
//twitter.follow(1, 2);    // User 1 follows user 2.
//twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 
//tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted 
//after tweet id 5.
//twitter.unfollow(1, 2);  // User 1 unfollows user 2.
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 
//tweet id -> [5], since user 1 is no longer following user 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= userId, followerId, followeeId <= 500 
// 0 <= tweetId <= 10⁴ 
// All the tweets have unique IDs. 
// At most 3 * 10⁴ calls will be made to postTweet, getNewsFeed, follow, and 
//unfollow. 
// 
//
// Related Topics Hash Table Linked List Design Heap (Priority Queue) 👍 2599 👎
// 335

import java.util.*;

public class DesignTwitter {
    public static void main(String[] args) {
        //Solution solution = new DesignTwitter().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Twitter {
        private int timestamp = 0;

        private class Tweet {
            private int id;
            private int time;
            private Tweet next;

            public Tweet(int id, int time) {
                this.id = id;
                this.time = time;
                this.next = null;
            }
        }

        private class User {
            private int id;
            public Set<Integer> followed;
            public Tweet head;

            public User(int userId) {
                followed = new HashSet<>();
                this.id = userId;
                this.head = null;
                follow(id);
            }

            public void follow(int userId) {
                followed.add(userId);
            }

            public void unfollow(int userId) {
                if (userId != this.id) {
                    followed.remove(userId);
                }
            }

            public void post(int tweetId) {
                Tweet tweet = new Tweet(tweetId, timestamp);
                timestamp++;
                tweet.next = head;
                head = tweet;
            }
        }

        public Twitter() {
        }

        private HashMap<Integer, User> userHashMap = new HashMap<>();

        public void postTweet(int userId, int tweetId) {
            if (!userHashMap.containsKey(userId)) {
                userHashMap.put(userId, new User(userId));
            }
            User u = userHashMap.get(userId);
            u.post(tweetId);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            if (!userHashMap.containsKey(userId)) {
                return res;
            }
            Set<Integer> followed = userHashMap.get(userId).followed;
            PriorityQueue<Tweet> pq = new PriorityQueue<>(followed.size(), (a, b) -> (b.time - a.time));
            for (Integer id : followed) {
                Tweet head = userHashMap.get(id).head;
                if (head == null) {
                    continue;
                }
                pq.add(head);
            }
            while (!pq.isEmpty()) {
                if (res.size() == 10) {
                    break;
                }
                Tweet poll = pq.poll();
                res.add(poll.id);
                if (poll.next != null) {
                    pq.add(poll.next);
                }
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            if (!userHashMap.containsKey(followerId)) {
                User u = new User(followerId);
                userHashMap.put(followerId, u);
            }
            if (!userHashMap.containsKey(followeeId)) {
                User u = new User(followeeId);
                userHashMap.put(followeeId, u);
            }
            userHashMap.get(followerId).follow(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (userHashMap.containsKey(followerId)) {
                userHashMap.get(followerId).unfollow(followeeId);
            }
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)

}