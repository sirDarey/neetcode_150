package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _79_WordSearch {
    int rows, columns, n;
    String word;
    char[][] board;
    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        columns = board[0].length;
        this.board = board;
        this.word = word;
        n = word.length();
        visited = new boolean [rows][columns];
        
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++) {
                if (word.charAt(0) == board[i][j] && recur (i, j, 0))
                    return true;
            }
        }
        return false;
    }
    
    boolean recur (int i, int j, int wordIndex) {
        if (wordIndex == n)
            return true;
        
        if (i < 0   ||    j < 0    
                || i == rows || j == columns
                || visited[i][j] || word.charAt(wordIndex) != board[i][j])
            
            return false;
        
        visited[i][j] = true;
        
        if (recur(i, j-1, wordIndex+1) ||
                recur(i, j+1, wordIndex+1) ||
                recur(i-1, j, wordIndex+1) ||
                recur(i+1, j, wordIndex+1)   
            )
            
            return true;         
        
        visited[i][j] = false;
        return false;        
    }
}
