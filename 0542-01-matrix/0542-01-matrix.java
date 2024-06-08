class Solution {
    static class Tuple{
        int first;
        int second;
        int steps;

        public Tuple(int _first,int _second,int _steps){
            this.first = _first;
            this.second = _second;
            this.steps = _steps;
        }
    }
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] ans = new int[n][m];
        for(int[] it : ans){
            Arrays.fill(it,-1);
        }
        Queue<Tuple> queue = new LinkedList<>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 0 && !visited[i][j]){
                    queue.offer(new Tuple(i,j,0));
                    visited[i][j] = true;
                    ans[i][j] = 0;
                }
            }
        }

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,-1,0,1};

        while(!queue.isEmpty()){
            Tuple tuple = queue.peek();
            int row = tuple.first;
            int col = tuple.second;
            int step = tuple.steps;
            queue.poll();
            ans[row][col] = step;
            for(int k = 0; k<4; k++){
                int nexti = row + drow[k];
                int nextj = col + dcol[k];

                if(nexti >=0 && nextj >=0 && nexti < n && nextj < m && !visited[nexti][nextj]){
                    queue.offer(new Tuple(nexti,nextj,step+1));
                    visited[nexti][nextj] = true;
                }
            }
        }
        return ans;
    }
}