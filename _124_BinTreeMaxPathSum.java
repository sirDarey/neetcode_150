package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _124_BinTreeMaxPathSum {
    
    int maxSoFar = Integer.MIN_VALUE;
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }   
    
    public int maxPathSum(TreeNode root) {
        recur(root);
        return maxSoFar;
    }
    
    int recur (TreeNode tempRoot) {
        if (tempRoot == null)
            return 0;
                
        int tempLeft = Math.max(0, recur(tempRoot.left));
        int tempRight = Math.max(0, recur(tempRoot.right));
        
        int max = tempLeft + tempRight +tempRoot.val;
        maxSoFar = Math.max(max, maxSoFar);
        
        return Math.max(tempLeft, tempRight)+tempRoot.val;
    }
}
