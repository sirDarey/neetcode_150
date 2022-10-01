package neetcode_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @Sir Darey
 */

public class _199_BinRightSideView {
   
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
    
    public List<Integer> rightSideView(TreeNode root) {
        List <Integer> result = new LinkedList<>();
        if (root == null)
            return result;
        
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int n = queue.size();
           
            for (int i=0; i<n; i++) {
                TreeNode peek = queue.peek();
                if (peek.left != null)
                    queue.offer (peek.left);
                if (peek.right != null)
                    queue.offer(peek.right);
                
                int newValue = queue.poll().val;
                if (i == n-1)
                    result.add(newValue);
            }
            
        }
        return result;
    }
}
