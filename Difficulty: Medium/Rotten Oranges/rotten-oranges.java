

class Solution
{
    
    static class Tuple{
        int i;
        int j;
        int step;
        
        public Tuple(int i,int j,int step){
            this.i = i;
            this.j = j;
            this.step = step;
        }
    }
    //Function to find minimum time required to rot all oranges. 
    public int orangesRot(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        int nonEmptyCnt = 0;
        Queue<Tuple> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2 && !visited[i][j]){
                    queue.offer(new Tuple(i,j,0));
                    visited[i][j] = true;
                    nonEmptyCnt++;
                }
                else if(grid[i][j] == 1){
                    nonEmptyCnt++;
                }
            }
        }
        
        
        int cnt = 0;
        int maxi = 0;
        
        int[] di = {-1,0,0,1};
        int[] dj = {0,-1,1,0};
        
        while(!queue.isEmpty()){
            Tuple tuple = queue.peek();
            queue.poll();
            int i = tuple.i;
            int j = tuple.j;
            int steps = tuple.step;
            maxi = Math.max(maxi,steps);
            for(int k = 0; k<4; k++){
                int nexti = i + di[k];
                int nextj = j + dj[k];
                
                if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < m && !visited[nexti][nextj] && grid[nexti][nextj] == 1){
                    queue.offer(new Tuple(nexti,nextj,steps+1));
                    visited[nexti][nextj] = true;
                }
            }
            
            cnt++;
        }
        
        if(cnt == nonEmptyCnt){
            return maxi;
        }
        else return -1;
    }
}