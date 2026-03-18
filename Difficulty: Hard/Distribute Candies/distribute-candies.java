/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int moves;
    public int distCandy(Node root) {
        // code here
        moves = 0;
        dfs(root);
        return moves;
    }
    
    private int dfs(Node root){
        if(root == null){
            return 0;
        }
        
        int leftBalance = dfs(root.left);
        int rightBalance = dfs(root.right);
        
        moves += Math.abs(leftBalance) + Math.abs(rightBalance);
        
        return (root.data - 1) + leftBalance + rightBalance;
    }
}