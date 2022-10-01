package neetcode_150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @Sir Darey
 */
public class _212_WordSearch2 {
    int rows, columns;
    char[][] board;
    Set <String> result = new HashSet<>();
    TrieNode root = new TrieNode();
    boolean [][] visited;
    
    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        columns = board[0].length;
        this.board = board;
        visited = new boolean[rows][columns];
            
        for (String word : words) 
            insert(word);
        
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) 
                recur (i, j, root, "");  
        }
        return new ArrayList<>(result);
    }
    
    private static class TrieNode {
        TrieNode [] children;
        boolean isWord;
        
        public TrieNode () {
            children = new TrieNode[26];
            isWord = false;
        }
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
    
    void recur (int i, int j, TrieNode current, String wordSoFar) {
        
        if (i < 0 || j < 0 || i == rows || j == columns
                || visited[i][j] || current.children[board[i][j] - 'a'] == null)
            return;
        
        char c = board[i][j];
        visited[i][j] = true;
        current = current.children[c - 'a'];
        wordSoFar += c;
        if (current.isWord)
            result.add(wordSoFar);
        
        recur(i, j-1, current, wordSoFar);
        recur(i, j+1, current, wordSoFar);
        recur(i-1, j, current, wordSoFar);
        recur(i+1, j, current, wordSoFar);
        
        visited[i][j] = false;
    }
}
