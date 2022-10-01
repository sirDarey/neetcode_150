package neetcode_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @Sir Darey
 */
public class _355_Twitter {
    
    Map <Integer, List<Integer>>tweetsMap;
    Map <Integer, Set<Integer>> followersMap;
    Map <Integer, Integer> tweetTimeLine;
    int i = 0;
    
    public _355_Twitter() {
        followersMap = new HashMap<>();
        tweetsMap = new HashMap<>();
        tweetTimeLine = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (tweetsMap.containsKey(userId)) 
            tweetsMap.get(userId).add(tweetId);
        else {
            List <Integer> newList = new ArrayList<>();
            newList.add(tweetId);
            tweetsMap.put(userId, newList);
        }
        tweetTimeLine.put(tweetId, ++i);
    }
    
   public List<Integer> getNewsFeed(int userId) {
        List <Integer> list = new ArrayList<>();
       
        PriorityQueue <Integer> pq = new PriorityQueue<>
                        ((a,b) -> tweetTimeLine.get(b) - tweetTimeLine.get(a));
       
        if (tweetsMap.containsKey(userId)) {
            int i = 0, n = tweetsMap.get(userId).size()-1;
            while (i <= n && i < 10) {
                pq.offer(tweetsMap.get(userId).get(n-i));
                i++;
            }
        }        
       
        if (followersMap.containsKey(userId)) {
            followersMap.get(userId).forEach(following -> {
                if (tweetsMap.containsKey(following)) {
                    int j = 0, m = tweetsMap.get(following).size()-1;
                    while (j <= m && j < 10) {
                        pq.offer(tweetsMap.get(following).get(m-j));
                        j++;
                    }
                }
            });
        }
        
        int count = 0;
        
        while (count<10 && !pq.isEmpty()) {
            list.add(pq.poll());
            count++;
        }           
        
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followersMap.containsKey(followerId)) 
            followersMap.get(followerId).add(followeeId);
        else {
            Set <Integer> newSet = new HashSet<>();
            newSet.add(followeeId);
            followersMap.put(followerId, newSet);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followersMap.containsKey(followerId) && followersMap.get(followerId).contains(followeeId))
            followersMap.get(followerId).remove(followeeId);
    }
}