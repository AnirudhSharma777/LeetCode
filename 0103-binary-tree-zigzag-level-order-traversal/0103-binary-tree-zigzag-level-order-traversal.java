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
        Deque<TreeNode> queue = new ArrayDeque<>();
        boolean leftToright = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Integer[] subArray = new Integer[size];
            for(int i = 0; i<size; i++){
                TreeNode r = queue.peek();
                if(r.left != null){
                    queue.offer(r.left);
                }
                if(r.right != null){
                    queue.offer(r.right);
                }
                int index = leftToright ? i : size - i - 1;
                TreeNode node = queue.poll();
                subArray[index] = node.val;
            }
            leftToright = !leftToright;
            ans.add(Arrays.asList(subArray));
        }
        return ans;
    }
}