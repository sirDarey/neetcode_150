package neetcode_150;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Sir Darey
 */
public class _105_ConBinTreeFromPre_InOrder {
        
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
    
    Map<Integer, Integer> map = new HashMap<>();
    int [] preorder;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        
        return recur(0, 0, inorder.length-1);
    }
    
    private TreeNode recur(int pre_0_Index, int inLeft, int inRight) {
        int newRootVal = preorder[pre_0_Index],
            inMid = map.get(newRootVal);
        
        TreeNode newRoot = new TreeNode(newRootVal);
        
        if (inMid > inLeft) 
            newRoot.left = recur (pre_0_Index + 1, inLeft, inMid-1);
        if (inMid  < inRight)
            newRoot.right = recur(pre_0_Index +inMid -inLeft +1, inMid+1, inRight);
        
        return newRoot;
    }
}
