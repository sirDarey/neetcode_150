package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _695_MaxAreaOfIsland {
    
    private int row, column, maxSoFar;
    private boolean [][] visited;
    int [][] grid;
    
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        column = grid[0].length;
        this.grid = grid;
        maxSoFar = 0;
        visited  = new boolean [row][column];  
        
        countIslands();
        return maxSoFar;
    }
    
    public void countIslands () {
        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    maxSoFar = Math.max(recur (i, j), maxSoFar);
                }
            }            
        }        
    }
    
    int recur (int row, int column) {
        if (row < 0 || column < 0
                || row >= this.row ||  column >= this.column
                || visited[row][column] || grid[row][column] == 0)
            
            return 0;
        
        visited[row][column] = true;
        
        return 1 + recur (row-1, column)
                 + recur (row, column+1)
                 + recur (row, column-1)
                 + recur (row+1, column);
    }
}
