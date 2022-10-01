package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _684_RedundantConnection {
    
    int [] parent, rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        parent = new int[n];
        rank = new int[edges.length+1];
        
        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for (int i=0; i<n-1; i++) {
            if (!union (edges[i][0], edges[i][1]))
                return new int [] {edges[i][0], edges[i][1]};
        }
        return null;
    }
    
    int findParent (int node) {
        int p = parent[node];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;        
    }
    
    boolean union (int node1, int node2) {
        int p1 = findParent(node1);
        int p2 = findParent(node2);
        
        if (p1 == p2)
            return false;
        
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }   
}
