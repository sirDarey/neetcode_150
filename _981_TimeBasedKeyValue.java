package neetcode_150;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @Sir Darey
 */
public class _981_TimeBasedKeyValue {
    
    Map <String, TreeMap> timeMap;
       
    public _981_TimeBasedKeyValue() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key,new TreeMap<>());
        timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> temp = timeMap.getOrDefault(key, null);
        if(timeMap.get(key) == null || temp.floorKey(timestamp) == null)
            return "";
        return temp.get(temp.floorKey(timestamp));  
    }
       
    public static void main(String[] args) {
        _981_TimeBasedKeyValue solution = new _981_TimeBasedKeyValue();
        
        solution.set("foo", "bar", 1);
        System.out.println(solution.get("foo", 1));
        System.out.println(solution.get("foo", 3));
        solution.set("foo", "bar2", 4);
        System.out.println(solution.get("foo", 4));
        System.out.println(solution.get("foo", 5));       
        System.out.println(solution.get("foo", 1)); 
    }
    
}
