class Solution {
    
    // bfs
//    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        
//         HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        
//         for(int i = 0; i<n; i++){
//             graph.put(i,new ArrayList<>());
//         }
        
//         for(int[] edge : edges){
//             int u = edge[0];
//             int v = edge[1];
            
//             graph.get(u).add(v);
//             graph.get(v).add(u);
//         }
        
//         // System.out.println(graph);
        
//         boolean[] visited = new boolean[n];
//         Queue<Integer> queue = new LinkedList<>();
//         queue.offer(source);
//         visited[source] = true;
        
//         while(!queue.isEmpty()){
//             int node = queue.peek();
//             queue.remove();
//             if(source == destination){
//                 return true;
//             }
            
//             for(Integer nbr : graph.get(node)){
//                 if(!visited[nbr]){
//                     queue.offer(nbr);
//                     visited[nbr] = true;
//                 }
//             }
//         }
        
        
//         return visited[destination] ? true : false;
        
//     }
    
//     dfs
    public boolean validPath(int n, int[][] edges, int source, int destination){
        
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj[u].add(v);
            adj[v].add(u);
        }
        
        boolean[] visited = new boolean[n];
        
        return dfs(source,destination,visited,adj);
    } 

    private boolean dfs(int source,int destination,boolean[] visited,ArrayList<Integer>[] adj){
        
        visited[source] = true;
        
        if(source == destination){
            return true;
        }
        
        for(Integer nbr : adj[source]){
            if(!visited[nbr] && dfs(nbr,destination,visited,adj)){
                return true;
            }
        }
        return false;
    }
}