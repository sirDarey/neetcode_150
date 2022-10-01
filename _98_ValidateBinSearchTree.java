package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _98_ValidateBinSearchTree {
   
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
    
    public boolean isValidBST(TreeNode root) {
        return recur (root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    boolean recur (TreeNode root, long min, long max) {
        if (root==null) 
           return true;
        
        if (min >= root.val || max <= root.val) 
            return false;
            
        boolean left = recur(root.left, min, root.val);
        
        if (left) {
            boolean right = recur(root.right, root.val, max);
            return right;
        }
        
        return false;        
    }
}
