class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
             
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0; i<n; i++){
            if(color[i] == -1){
                if(bfs(i,color,graph) == false){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean bfs(int n,int[] color,int[][] graph){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        color[n] = 1;
        
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            
            for(Integer nbr : graph[node]){
                if(color[nbr] == -1){
                    color[nbr] = 1 - color[node];
                    queue.offer(nbr);
                }
                else if(color[nbr] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}    
    
    