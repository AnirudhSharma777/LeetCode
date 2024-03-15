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

class Tuple{
    TreeNode node;
    int row;
    int col;
    Tuple(TreeNode node,int row,int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> hm = new TreeMap<>();
        Deque<Tuple> dq = new ArrayDeque<>();
        dq.offer(new Tuple(root,0,0));
        
        while(!dq.isEmpty()){
            Tuple tuple = dq.poll();
            TreeNode node = tuple.node;
            int row = tuple.row;
            int col = tuple.col;
            
            if(!hm.containsKey(row)){
                hm.put(row,new TreeMap<>());
            }
            
            if(!hm.get(row).containsKey(col)){
                hm.get(row).put(col,new PriorityQueue<>());
            }
            
            hm.get(row).get(col).add(node.val);
            
            if(node.left != null){
                dq.offer(new Tuple(node.left,row-1,col+1));
            }
            if(node.right != null){
                dq.offer(new Tuple(node.right,row+1,col+1));
            }
            
        }
        
        for(TreeMap<Integer,PriorityQueue<Integer>> it : hm.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : it.values()){
                while(!pq.isEmpty()){
                    ans.get(ans.size()-1).add(pq.poll());
                }
            }
        }
        return ans;
    }
}