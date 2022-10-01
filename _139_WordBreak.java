package neetcode_150;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @Sir Darey
 */
public class _139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set <String> set = new HashSet<>(wordDict);     
        int end = s.length(),
            i = end - 1,
            track = end;
        while (i >= 0) {
            if (set.contains(s.substring(i, end))){
                track = end;
                end = i;
                i = end - 1;
            } else
                i--;                
        }
        return (set.contains(s.substring(0, track)));
    }
}
