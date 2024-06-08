class Solution {

    public static class Tuple{
        int first;
        int second;
        int steps;
        public Tuple(int _first,int _second, int _steps){
            this.first = _first;
            this.second = _second;
            this.steps = _steps;
        }
    }
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Tuple> queue = new LinkedList<>();
        int nonEmptyCnt = 0;

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
            int i = tuple.first;
            int j = tuple.second;
            int step = tuple.steps;

            maxi = Math.max(maxi,step);
            for(int k = 0; k < 4; k++){
                int nexti = i+di[k];
                int nextj = j+dj[k];

                if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < m && !visited[nexti][nextj] && grid[nexti][nextj] == 1){
                    queue.offer(new Tuple(nexti,nextj,step+1));
                    visited[nexti][nextj] = true;
                }
            }

            cnt++;
        }

        if(nonEmptyCnt == cnt){
            return maxi;
        }
        else  return -1;
    }
}