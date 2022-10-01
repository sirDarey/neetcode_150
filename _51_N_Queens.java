package neetcode_150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @Sir Darey
 */
public class _51_N_Queens {
    
    List<List<String>> result = new ArrayList<>();
    Character [][] board;
    int n;
    
    Set <Integer> columns = new HashSet<>(), 
            posDiag = new HashSet<>(), 
            negDiag = new HashSet<>();
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new Character[n][n];
           
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++)
                board[i][j] = '.';
        }
        recur (0);
        return result;
    }
    
    void recur (int r) {
        if (r == n) {
            result.add(construct(board));
        }
        
        for (int c=0; c<n; c++) {
            if (columns.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c))
                continue;
            
            columns.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            board[r][c] = 'Q';
            
            recur (r+1);
            
            columns.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            board[r][c] = '.';
        }
    }
    
    List <String> construct(Character [][] board) {
        List <String> ans = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) 
                sb.append(board[i][j]);
            ans.add(sb.toString());
        }
        return ans;
    }
}
