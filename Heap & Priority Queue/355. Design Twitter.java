/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented Twitter using user-follow relationships, reverse chronological tweet lists, and a priority queue to retrieve the 10 most recent tweets.
/* “I maintain a user map where each user stores their followees and tweets. Tweets are inserted at the front so each user’s tweets remain newest-first. For the news feed, 
    I take at most 10 tweets from the user and each followee and put them into a priority queue ordered by timestamp. I then extract the 10 most recent tweets from the heap.” */

class Tweet implements Comparable<Tweet> {
    int time;
    int tweetId;
    Tweet(int t, int id) {
        time = t;
        tweetId = id;
    }
    // Newer tweets have higher priority
    public int compareTo(Tweet that) {
        return that.time - this.time;
    }
}
class User {
    int userId;
    Set<Integer> followers;
    List<Tweet> tweets;
    User(int userId) {
        this.userId = userId;
        followers = new HashSet<>();
        tweets = new LinkedList<>();
    }
    // Add newest tweet at the front
    public void addTweet(Tweet t) {
        tweets.add(0, t);
    }
    public void addFollower(int followeeId) {
        followers.add(followeeId);
    }
    public void removeFollower(int followeeId) {
        followers.remove(followeeId);
    }
}
class Twitter {
    Map<Integer, User> userMap;
    int timeCount;
    public Twitter() {
        userMap = new HashMap<>();
        timeCount = 0;
    }
    public void postTweet(int userId, int tweetId) {
        timeCount++;
        // Create user if needed
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId)
               .addTweet(new Tweet(timeCount, tweetId));
    }
    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(userId)) {
            return new ArrayList<>();
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        User user = userMap.get(userId);
        // Add up to 10 tweets from each followee
        for (int followeeId : user.followers) {
            User followee = userMap.get(followeeId);
            if (followee == null) {
                continue;
            }
            int count = 0;
            for (Tweet tweet : followee.tweets) {
                pq.offer(tweet);
                if (++count == 10) {
                    break;
                }
            }
        }
        // Add user's own tweets
        int count = 0;
        for (Tweet tweet : user.tweets) {
            pq.offer(tweet);
            if (++count == 10) {
                break;
            }
        }
        // Extract the 10 most recent tweets
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < 10) {
            res.add(pq.poll().tweetId);
        }
        return res;
    }
    public void follow(int followerId, int followeeId) {
        // Ensure both users exist
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).addFollower(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            return;
        }
        userMap.get(followerId)
               .removeFollower(followeeId);
    }
}

// Time Complexity :- O(F log F). F = Users
// Space Complexity :- O(T). T = twwets
