package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _130_SurroundedRegions {
    
    private int row, column;
    char[][] board;
    
    public void solve(char[][] board) {
        row = board.length;
        column = board[0].length;
        this.board = board;
        
        for (int i=0; i<row; i++) {
            dfsT(i, 0);
            dfsT(i, column-1);
        }
        
        for (int j=0; j<column; j++) {
            dfsT(0, j);
            dfsT(row-1, j);
        }
        
        for (int i=1; i<row-1; i++)
            for (int j=1; j<column-1; j++)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
        
        for (int i=0; i<row; i++)
            for (int j=0; j<column; j++)
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
    }
    
    void dfsT (int i, int j) {
        if (i < 0  || j < 0 || i == row || j == column || board[i][j] != 'O')
            return;
        
        board[i][j] = 'T';
        
        dfsT(i, j-1);
        dfsT(i, j+1);
        dfsT(i-1, j);
        dfsT(i+1, j);
    }
}
