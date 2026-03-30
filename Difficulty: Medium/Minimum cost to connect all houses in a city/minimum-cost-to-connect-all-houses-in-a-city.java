

class Solution {

    public int minCost(int[][] houses) {
        // code here
        int n = houses.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] -b[0]);
        
        boolean[] visited = new boolean[n];
        
        pq.offer(new int[]{0,0});
        
        int sum = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int wt = cur[0];
            int idx = cur[1];
            
            if(visited[idx] == true){
                continue;
            }
            visited[idx] = true;
            
            sum += wt;
            
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    int newWt=Math.abs(houses[idx][0]-houses[i][0])+Math.abs(houses[idx][1]-houses[i][1]);
                    pq.offer(new int[]{newWt,i});
                }
            }
        }
        return sum;
    }
}
