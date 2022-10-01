package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _200_NumberOfIslands {
    
    private int row, column, count;
    private boolean [][] visited;
    char[][] grid;
    
    public int numIslands(char[][] grid) {
        row = grid.length;
        column = grid[0].length;
        this.grid = grid;
        count = 0;
        visited  = new boolean [row][column];  
        
        countIslands();
        return count;
    }
    
    public void countIslands () {
        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                if (!visited[i][j] && grid[i][j]=='1') {
                    recur (i, j);
                    count++;
                }
            }            
        }        
    }
    
    void recur (int row, int column) {
        if (row < 0 || column < 0
                || row >= this.row ||  column >= this.column
                || visited[row][column] || grid[row][column]=='0')
            
            return;
        
        visited[row][column] = true;
                
        recur (row-1, column); //Go Up
        recur (row, column+1); //Go Right
        recur (row, column-1); // Go Left
        recur (row+1, column); // Go Down
    }
}
