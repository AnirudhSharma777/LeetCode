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
class Pair{
    Node node;
    int col;
    Pair(Node _node,int _col){
        this.node = _node;
        this.col = _col;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<Pair> queue = new ArrayDeque<>();
        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
        queue.offer(new Pair(root,0));
        
        while(!queue.isEmpty()){
            Pair p = queue.peek();
            Node first = p.node;
            int second = p.col;
            queue.poll();
            
            if (!tm.containsKey(second)) {
                tm.put(second, new ArrayList<>());
            }
            tm.get(second).add(first.data);
            
            if(first.left != null){
                queue.offer(new Pair(first.left,second-1));
            }
            if(first.right != null){
                queue.offer(new Pair(first.right,second+1));
            }
        }
        
        
        for (ArrayList<Integer> list : tm.values()) {
            ans.add(list);
        }
        
        return ans;
        
        
    }
}