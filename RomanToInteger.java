package neetcode_150;


import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author USER
 */
public class RomanToInteger {
    
    int toInteger(String roman) {
        Map <Character, Integer> map = new HashMap<>();
        map.put ('I', 1);
        map.put ('V', 5);
        map.put ('X', 10);
        map.put ('L', 50);
        map.put ('C', 100);
        map.put ('D', 500);
        map.put ('M', 1000);

        int result = 0;
        int prev = map.get(roman.charAt(0));

        for (char c : roman.toCharArray()){
            int current = map.get(c);

            result += current;
            if (prev < current)
                result -= 2*prev;
            prev = current;
        }
        return result;
}
    
    public static void main(String[] args) {
        RomanToInteger roman = new RomanToInteger();
        System.out.println(roman.toInteger("MCMXCIV"));
    }
}
