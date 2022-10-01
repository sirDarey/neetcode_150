package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _572_SubTreeOfAnother {
   
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
    
//    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//        if (root == null)
//            return subRoot == null;
//        return ((isSame(root, subRoot))
//                || (isSubtree(root.left, subRoot))
//                || (isSubtree(root.right, subRoot)));
//    }
//     
//    boolean isSame (TreeNode root, TreeNode subRoot) {
//        if (root == null || subRoot == null)
//            return root == subRoot;
//        
//        return ((root.val == subRoot.val) 
//                && (isSame(root.left, subRoot.left))
//                && (isSame(root.right, subRoot.right)));
//    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;
        return ((isSame(root, subRoot))
                || (isSubtree(root.left, subRoot))
                || (isSubtree(root.right, subRoot)));
    }
     
    boolean isSame (TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null)
            return true;
        else if (root != null && subRoot != null) { 
            if (root.val == subRoot.val) {
                if (isSame (root.left, subRoot.left))
                    return isSame(root.right, subRoot.right);
            }
            return false;
        } else
            return false;
    }
}
