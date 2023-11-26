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


//tc = o(n) 
// sc = O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null){
            return ans;
        }
        
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        
        while(!dq.isEmpty()){
            int size = dq.size();
            
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode cur = dq.poll();
                if(cur.left != null){
                    dq.offer(cur.left);
                }
                if(cur.right != null){
                    dq.offer(cur.right);
                }
                list.add(cur.val);
                
            }
            ans.add(list);
        }
        return ans;
    }
}