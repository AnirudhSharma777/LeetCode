/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
};
*/
class Solution {
    public ArrayList<Integer> inOrder(Node root) {
        // code here
        if(root == null){
            return new ArrayList<>();
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node node = root;
        
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                ans.add(node.data);
                node = node.right;
            }
        }
        
        return ans;
    }
}