package neetcode_150;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @Sir Darey
 */
public class _102_LevelOrderTraversal {
   
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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new LinkedList<>();
        if (root == null)
            return list;
        
        Queue <TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            List <Integer> newList = new LinkedList<>();
           
            for (int i=0; i<n; i++) {
                TreeNode peek = queue.peek();
                if (peek.left != null)
                    queue.offer (peek.left);
                if (peek.right != null)
                    queue.offer(peek.right);
                
                newList.add(queue.poll().val);
            }
            list.add(newList);
        }
        return list;
    }
}
