package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _211_DesignDictionary1 {
  
    private static class TrieNode {
        TrieNode [] children;
        boolean isWord;
        
        public TrieNode () {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root;
    
    public _211_DesignDictionary1() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
        return recur (word, 0, root);
    }
    
    boolean recur (String word, int start, TrieNode node) {
        TrieNode current = node;
        
        for (int i=start; i<word.length(); i++) {
            char c = word.charAt(i);
           
            if (c == '.') {
                for (int j=0; j<26; j++) {
                    if (current.children[j] != null && 
                            recur(word, i+1, current.children[j]))
                        return true;
                }
                return false;
            } else {
                int index = c - 'a';
                if(current.children[index] == null)
                    return false;
                current = current.children[index];
            }
        }
        return current.isWord;
    }
}
