// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Tree {
    ArrayList<Integer> postOrder(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null){
            return new ArrayList<>();
        }
        
        Stack<Node> st = new Stack<>();
        Stack<Integer> st1 = new Stack<>();
        st.push(node);
        
        while(!st.isEmpty()){
            Node n = st.pop();
            if(n.left != null){
                st.push(n.left);
            }
            if(n.right != null){
                st.push(n.right);
            }
            st1.push(n.data);
        }
        
        while(!st1.isEmpty()){
            ans.add(st1.pop());
        }
        
        
        return ans;
    }
}