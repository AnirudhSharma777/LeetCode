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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        solve(root,"",res);
        return res;
    }
    private void solve(TreeNode root,String paths,List<String> ans){
        if(root.left == null && root.right == null){
            ans.add(paths+root.val);
        }
        if(root.left != null){
            solve(root.left,paths+root.val+"->",ans);
        }
        if(root.right != null){
            solve(root.right,paths+root.val+"->",ans);
        }
    }
}