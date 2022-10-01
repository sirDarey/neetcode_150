package neetcode_150;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @Sir Darey
 */

public class _853_CarFleet {
    
    public int carFleet(int target, int[] position, int[] speed) {
        
        TreeMap <Float, Float> map = new TreeMap<>();
        int n = speed.length, fleets = 0;
        float lastTime = 0;
        
        for (int i=0; i<n; i++) 
            map.put(-(float)position[i], (float)speed[i]);
        
        for (Map.Entry<Float, Float> fleet : map.entrySet()) {
            float time = (target + fleet.getKey())/fleet.getValue();
            
            if (time > lastTime){
                lastTime = time;
                fleets++;
            }
        }
        return fleets;
    }
    
    public static void main(String[] args) {
        _853_CarFleet solution = new _853_CarFleet();
        
        int [] position = {10,8,0,5,3}, speed = {2,4,1,1,3};
        System.out.println(solution.carFleet(12, position, speed));
    }
    
}
