package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _1448_GoodNodesInBinTree {
   
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
    
    public int goodNodes(TreeNode root) {
        return recur(root, root.val);
    }
    
    int recur (TreeNode root, int max) {
        if (root == null)
            return 0;
        int rootVal = root.val;
        int result = (rootVal >= max)? 1 : 0;
        
        result += recur (root.left, Math.max(max, rootVal));
        result += recur (root.right, Math.max(max, rootVal));
        
        return result;
    }
}
