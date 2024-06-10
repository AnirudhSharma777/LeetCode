class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            graph.put(i,new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // System.out.println(graph);
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            if(source == destination){
                return true;
            }
            
            for(Integer nbr : graph.get(node)){
                if(!visited[nbr]){
                    queue.offer(nbr);
                    visited[nbr] = true;
                }
            }
        }
        
        
        return visited[destination] ? true : false;
        
    }
}