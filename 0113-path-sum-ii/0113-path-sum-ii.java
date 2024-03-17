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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        solve(root,0,targetSum,new ArrayList<>());
        return res;
    }
    private void solve(TreeNode root,int curSum,int targetSum,List<Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.val);
        if(root.left == null && root.right == null && curSum+ root.val == targetSum){
            res.add(new ArrayList<>(ans));
        }
        else{
            solve(root.left,curSum+root.val,targetSum,ans);
            solve(root.right,curSum+root.val,targetSum,ans);
        }
        ans.remove(ans.size()-1);
    }
}