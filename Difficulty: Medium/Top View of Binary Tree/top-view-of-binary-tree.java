/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution
{
    static class Pair{
        Node node;
        int col;
        Pair(Node node,int col){
            this.node = node;
            this.col = col;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
       ArrayList<Integer> ans = new ArrayList<>();
       if(root == null){
           return ans;
       }
       TreeMap<Integer,Integer> hm = new TreeMap<>();
       Deque<Pair> dq = new ArrayDeque<>();
       dq.offer(new Pair(root,0));
       
       while(!dq.isEmpty()){
           Pair pair = dq.poll();
           Node node = pair.node;
           int col = pair.col;
           
           if(hm.get(col) == null){
               hm.put(col,node.data);
           }
           
           if(node.left != null){
               dq.offer(new Pair(node.left,col-1));
           }
           if(node.right != null){
               dq.offer(new Pair(node.right,col+1));
           }
       }
       
       for(int i : hm.values()){
           ans.add(i);
       }
       return ans;
    }
}