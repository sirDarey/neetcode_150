package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _543_DiameterBinTree {
    
    int maxSoFar;
    
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
    
    public int diameterOfBinaryTree(TreeNode root) {
        recur(root);
        return maxSoFar;
    }
     
    int recur (TreeNode tempRoot) {
        if (tempRoot == null)
            return 0;
        
        int tempLeft = recur(tempRoot.left);
        int tempRight = recur(tempRoot.right);
        
        maxSoFar = Math.max(maxSoFar, tempLeft + tempRight);
        return Math.max(tempLeft, tempRight) +1;
    }
}
