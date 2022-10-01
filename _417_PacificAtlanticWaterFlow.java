package neetcode_150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @Sir Darey
 */
public class _417_PacificAtlanticWaterFlow {
    
    private int rows, columns;
    int[][] heights;
    List<List<Integer>> result;
    Set <List<Integer>> pacific, atlantic;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        columns = heights[0].length;
        result = new ArrayList<>();
        this.heights = heights; 
        pacific = new HashSet<>();
        atlantic = new HashSet<>();
        
        for (int c=0; c<columns; c++) {
            recur(0, c, pacific, heights[0][c]);
            recur(rows-1, c, atlantic, heights[rows-1][c]);
        }
        
        for (int r=0; r<rows; r++) {
            recur(r, 0, pacific, heights[r][0]);
            recur(r, columns-1, atlantic, heights[r][columns-1]);
        }
        
        pacific.forEach(list ->{
            if (atlantic.contains(list))
                result.add(list);
        });
        
        return result;
    }
    
    List<Integer> createNewList (int r, int c) {
        List <Integer> newList = new ArrayList<>();
        newList.add(r);
        newList.add(c);
        return newList;
    }
    
    void recur (int r, int c, Set <List<Integer>> visited, int prevHeight){
        List <Integer> newList = createNewList(r, c);
        if (c < 0 || r < 0 || c == columns || r == rows || heights[r][c] <  prevHeight
                || visited.contains(newList) )
            return;
        
        visited.add(newList);
        recur(r, c-1, visited, heights[r][c]);
        recur(r, c+1, visited, heights[r][c]); 
        recur(r-1, c, visited, heights[r][c]);
        recur(r+1, c, visited, heights[r][c]);
    }
    
    public static void main(String[] args) {
        _417_PacificAtlanticWaterFlow obj = new _417_PacificAtlanticWaterFlow();
        
        int [][] heights = {{1,2},
                            {4,3}
                           };
        obj.pacificAtlantic(heights);
        
    }
}
