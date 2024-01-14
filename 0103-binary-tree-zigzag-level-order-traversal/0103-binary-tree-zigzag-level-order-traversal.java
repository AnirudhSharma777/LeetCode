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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        boolean isleftToRight = true;
        while(!dq.isEmpty()){
            int size = dq.size();
            Integer[] subArray = new Integer[size];
            for(int i = 0; i<size; i++){
                TreeNode cur = dq.peek();
                if(cur.left != null){
                    dq.offer(cur.left);
                }
                if(cur.right != null){
                    dq.offer(cur.right);
                }
                int index = isleftToRight ? i : size - i - 1;
                TreeNode node = dq.poll();
                subArray[index] = node.val;
            }
            isleftToRight = !isleftToRight;
            ans.add(Arrays.asList(subArray));
        }
        return ans;
    }
    
}