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
public class _210_CourseSchedule2 {
    
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set <Integer> visited = new HashSet<>(),
                  cycle = new HashSet<>();;
    int [] result; int i = 0;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new int [numCourses];
        
        for (int i=0; i<numCourses; i++) 
            map.put(i, new ArrayList<>());
        for (int i=0; i<prerequisites.length; i++) 
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        
        for (int course=0; course<numCourses; course++)
            if (!recur(course))
                return new int [0];
        return result;
    }
    
    boolean recur (int course) {
        if (cycle.contains(course))
            return false;
        if (visited.contains(course))
            return true;
        
        cycle.add(course);
        for (int pre : map.get(course))
            if (!recur(pre))
                return false;
        cycle.remove(course);
        visited.add(course);
        result[i] = course;
        i++;
        return true;
    }
}
