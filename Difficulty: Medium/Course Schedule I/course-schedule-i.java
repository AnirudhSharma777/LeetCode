class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        for(int[] it : prerequisites){
            int u = it[0];
            int v = it[1];
            adj.get(v).add(u);
        }
        
        for(int i = 0; i<n; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            count++;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
        if(count == n){
            return true;
        }
        return false;
    }
}