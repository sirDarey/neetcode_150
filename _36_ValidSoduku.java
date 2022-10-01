package neetcode_150;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Sir Darey
 */
public class _36_ValidSoduku {
    
     public boolean isValidSudoku(char[][] board) {
           for (int i=0; i<9; i++) {
            Set<Character> set = new HashSet<>();
            
            for (int j=0; j<9; j++) {
                if (Character.isDigit(board[i][j])) {
                    if (set.contains(board[i][j]))
                    return false;
                    
                    set.add(board[i][j]);
                }                    
            }
        }
        
        for (int i=0; i<9; i++) {
            Set<Character> set = new HashSet<>();
            
            for (int j=0; j<9; j++) {
                if (Character.isDigit(board[j][i])) {
                    if (set.contains(board[j][i]))
                    return false;
                    
                    set.add(board[j][i]);
                }
            }
        }
         
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
            
                Set<Character> set = new HashSet<>();

                for (int k=3*i; k<(3*i+3); k++) {
                    for (int l=3*j; l<(3*j+3); l++) {
                        if (Character.isDigit(board[k][l])) {
                            if (set.contains(board[k][l]))
                            return false;

                            set.add(board[k][l]);
                        }
                    }
                }
            }
        }
        
        return true;
    }
       
    public static void main(String[] args) {
        _36_ValidSoduku solution = new _36_ValidSoduku();
        
        char [][] board = {
                           {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                           {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                           {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                           {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                           {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                           {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                           {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                           {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                           {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                          };
        
        System.out.println(solution.isValidSudoku(board));
    }
    
}
