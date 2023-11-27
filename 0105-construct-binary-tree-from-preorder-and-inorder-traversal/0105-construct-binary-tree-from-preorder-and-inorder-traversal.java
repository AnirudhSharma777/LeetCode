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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder,inorder,0,inorder.length - 1);
    }
    
    private TreeNode solve(int[] preorder,int[] inorder,int start,int end){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        
        int inIndex = 0;
        for(int i = start; i<=end; i++){
            if(inorder[i] == root.val){
                inIndex = i;
                break;
            }
        }
        root.left = solve(preorder,inorder,start,inIndex-1);
        root.right = solve(preorder,inorder,inIndex+1,end);
        return root;
    }
}