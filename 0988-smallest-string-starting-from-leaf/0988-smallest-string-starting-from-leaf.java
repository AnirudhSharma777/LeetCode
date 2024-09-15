/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    String smallestString = null;
    public String smallestFromLeaf(TreeNode root) {
        helper(root,"");
        return smallestString;
    }
    
    private void helper(TreeNode root, String currentString){
        
        if(root == null){
            return;
        }
        
        currentString = (char) (root.val + 'a') + currentString;
        
       if (root.left == null && root.right == null) {
            if (smallestString == null || currentString.compareTo(smallestString) < 0) {
                smallestString = currentString;
            }
        }
        
        helper(root.left,currentString);
        helper(root.right,currentString);
    }
}