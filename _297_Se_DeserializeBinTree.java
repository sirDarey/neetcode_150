package neetcode_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @Sir Darey
 */
public class _297_Se_DeserializeBinTree {
        
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    } 
    
    StringBuilder sb = new StringBuilder(); int index = 0;
    public String serialize(TreeNode root) {
        recurSerialization(root);
        return sb.toString();
    }
    
    void recurSerialization (TreeNode root) {
        if (root == null) {
            sb.append(',').append('N');
            return;
        }
            
        sb.append(",").append(root.val);
        
        recurSerialization(root.left);
        recurSerialization(root.right);
    }

    public TreeNode deserialize(String data) {
        List <String> list = new ArrayList<>();
        
        Scanner scan = new Scanner(data);
        scan.useDelimiter(",");
        while (scan.hasNext())
            list.add(scan.next());
        scan.close();
        
        return recurDeserialization(list);        
    }
    
    TreeNode  recurDeserialization (List <String> list) {
        if (list.isEmpty() || list.get(index).equals("N"))
            return null;
        
        TreeNode newRoot = new TreeNode(Integer.parseInt(list.get(index))); 
        index++;
        newRoot.left = recurDeserialization(list); 
        index++;
        newRoot.right = recurDeserialization(list); 
                
        return newRoot;
    }
}
