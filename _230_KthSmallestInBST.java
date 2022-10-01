package neetcode_150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @Sir Darey
 */
public class _230_KthSmallestInBST {
    
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
    
    List <Integer> list = new ArrayList<>();
    int k;
    
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        iterativeInOrder(root);
        return list.get(k-1);
    }
    
    void iterativeInOrder (TreeNode root) {
        if (root == null) 
            return;
        
        Stack <TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        
        while((!stack.isEmpty() || temp != null) && list.size() < k) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                list.add(temp.val);
                temp = temp.right;
            }
        }
    }
}
