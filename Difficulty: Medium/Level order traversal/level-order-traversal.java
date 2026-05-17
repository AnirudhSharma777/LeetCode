/* A binary tree Node
class Node {
    public int data;
    public Node left;
    public Node right;

    // Constructor
    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/

class Solution {
    public ArrayList<Integer> levelOrder(Node root) {
        // code here
        if(root ==  null){
            return new ArrayList<>();
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        
        while(!que.isEmpty()){
            Node node = que.poll();
            
            if(node.left != null){
                que.offer(node.left);
            }
            if(node.right != null){
                que.offer(node.right);
            }
            ans.add(node.data);
        }
        
        return ans;
    }
}