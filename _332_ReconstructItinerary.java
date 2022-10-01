package neetcode_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @Sir Darey
 */
public class _332_ReconstructItinerary {
    
    List<String> result = new ArrayList<>();
    Map <String, PriorityQueue<String>> map = new HashMap<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.forEach(ticket -> {
            map.computeIfAbsent(ticket.get(0), k-> new PriorityQueue()).add(ticket.get(1));
        });
        
        recur ("JFK");
        return result;
    }
    
    void recur (String airport) {
        while(map.containsKey(airport) && !map.get(airport).isEmpty())
            recur (map.get(airport).poll());
        result.add(0, airport);
    }
}
