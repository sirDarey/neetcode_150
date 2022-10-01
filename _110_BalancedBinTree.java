package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _110_BalancedBinTree {
   
    int maxDifference;
    
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
    
    public boolean isBalanced(TreeNode root) {
        recur(root);
        return maxDifference <= 1;
    }
    
    int recur (TreeNode tempRoot) {
        if (tempRoot == null)
            return 0;
        
        int tempLeft = recur(tempRoot.left);
        int tempRight = recur(tempRoot.right);
        
        maxDifference = Math.max(maxDifference, Math.abs(tempLeft - tempRight));
        return Math.max(tempLeft, tempRight) +1;
    }
}
