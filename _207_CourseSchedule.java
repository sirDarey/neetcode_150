package neetcode_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @Sir Darey
 */
public class _207_CourseSchedule {
    
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set <Integer> visited = new HashSet<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i=0; i<numCourses; i++) 
            map.put(i, new ArrayList<>());
        for (int i=0; i<prerequisites.length; i++) 
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        
        for (int course=0; course<numCourses; course++)
            if (!recur(course))
                return false;
        return true;
    }
    
    boolean recur (int course) {
        if (visited.contains(course))
            return false;
        if (map.get(course).isEmpty())
            return true;
        
        visited.add(course);
        for (int pre : map.get(course))
            if (!recur(pre))
                return false;
        visited.remove(course);
        map.get(course).clear();
        return true;
    }
}
