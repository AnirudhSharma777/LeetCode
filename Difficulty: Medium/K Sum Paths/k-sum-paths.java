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
    
    int count = 0;
    HashMap<Long,Integer> hm = new HashMap<>();
    
    public int countAllPaths(Node root, int k) {
        // code here
        hm.put(0L,1);
        dfs(root,0L,k);
        return count;
    }
    
    private void dfs(Node root,long currSum, int k){
        if(root == null){
            return;
        }
        
        currSum += root.data;
        
        if(hm.containsKey(currSum - k)){
            count += hm.get(currSum - k);
        }
        
        hm.put(currSum,hm.getOrDefault(currSum,0)+1);
        
        dfs(root.left,currSum,k);
        dfs(root.right,currSum,k);
        
        hm.put(currSum,hm.get(currSum)-1);
    }
}