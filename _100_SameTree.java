package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _100_SameTree {
   
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
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recur (p, q);
    }
     
    boolean recur (TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return  true;
        else if (p != null && q!= null) { 
            if (p.val == q.val) {
                if (recur (p.left, q.left))
                    return recur(p.right, q.right);
            }
            return false;
        } else
            return false;
    }
}
