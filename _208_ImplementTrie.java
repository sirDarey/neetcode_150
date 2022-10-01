package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _208_ImplementTrie {
  
    private static class TrieNode {
        TrieNode [] children;
        boolean isWord;
        
        public TrieNode () {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root;
    
    public _208_ImplementTrie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            
            if (current.children[index] == null) 
                current.children[index] = new TrieNode();
            current = current.children[index];            
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            
            if (current.children[index] == null)
                return false;
            
            current = current.children[index];
        }
        return current.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            
            if (current.children[index] == null)
                return false;
            
            current = current.children[index];
        }
        return true;
    }
}
