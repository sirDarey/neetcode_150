package neetcode_150;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Sir Darey
 */
public class _146_LRUCache {
    
    int capacity;
    Map <Integer, dll> map = new HashMap<>();
    dll headDummy = new dll(0,0);
    dll tailDummy = new dll(0,0);
    
    public _146_LRUCache(int capacity) {
       this.capacity = capacity; 
       headDummy.next = tailDummy;
       tailDummy.prev = headDummy;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
            insertNode(map.get(key));
            return map.get(key).val;
        }
        return -1;  
    }
    
    public void put(int key, int value) {

        if (map.containsKey(key)) 
            removeNode(map.get(key));
        
        dll newNode = new dll(key, value);
        map.put(key, newNode); 
        insertNode(map.get(key));
        
        if (map.size() > capacity) {
            dll removeNode = headDummy.next; 
            map.remove(removeNode.key);
            removeNode(removeNode);
        }      
    }
    
    private static class dll {
        int key, val;
        dll prev, next;
        
        public dll (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public void insertNode(dll newNode) {
        dll prev = tailDummy.prev,
            next = tailDummy;
        
        prev.next = next.prev = newNode;
        newNode.next = next;
        newNode.prev = prev;
    }
    
    public void removeNode (dll node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }    
}
