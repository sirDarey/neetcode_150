package neetcode_150;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @Sir Darey
 */
public class _994_RottingOranges {
    
    int[][] grid;
    int rows , columns, time = 0, goodOranges = 0;
    Queue <Integer> q = new LinkedList<>();
             
    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        columns = grid[0].length;
        
        for (int i=0; i<rows; i++) 
            for (int j=0; j<columns; j++) {
                if (grid[i][j] == 1)
                    goodOranges++;
                if (grid[i][j] == 2) {
                    q.offer(i);
                    q.offer(j);
                }
            } 
        
        int [] dir = {0, 1, 0, -1, 0};
        while (!q.isEmpty() && goodOranges > 0) {
            int n = q.size()/2;
            for (int i=0; i<n; i++) {
                int r = q.poll(),
                    c = q.poll();
                
                for (int k=0; k<4; k++) {
                    int row = r+dir[k], column = c+dir[k+1];
                    if (row < 0  || column < 0 || row == rows || column == columns
                            || grid[row][column] != 1)
                        continue;
                    
                    grid [row][column] = 2;
                    q.offer(row);
                    q.offer(column);
                    
                    goodOranges--;
                    if (goodOranges == 0)
                        break;
                }
                if (goodOranges == 0)
                        break;
            }
            System.out.println(goodOranges);
            time ++;            
        }
        
        return goodOranges == 0? time : -1;
    }
}
