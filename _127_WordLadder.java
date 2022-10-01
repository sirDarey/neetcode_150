package neetcode_150;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @Sir Darey
 */
public class _127_WordLadder {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set <String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        
        int count = 1;
        Queue <String> q = new LinkedList<>();
        Set <String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i=0; i<n; i++) {
                String current = q.poll(); 
                if (current.equals(endWord))
                    return count;
                for (int j=0; j<current.length(); j++) {
                    char [] temp = current.toCharArray();
                    for (char c='a'; c<='z'; c++) {
                        temp[j] = c;
                        String newWord = new String(temp);
                        if (!visited.contains(newWord) && set.contains(newWord)) {
                            visited.add(newWord);
                            q.offer(newWord);
                        }
                    }
                }
            }
            count++;
        }
        
        return 0;
    }
}
