class Pair{
    int i;
    int j;
    public Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
         Queue<Pair> q = new LinkedList<Pair>();
        int n = grid.length; 
        int m = grid[0].length; 
        boolean vis[][] = new boolean[n][m];
        // traverse boundary elements
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                // first row, first col, last row, last col 
                if(i == 0 || j == 0 || i == n-1 || j == m-1) {
                    // if it is a land then store it in queue
                    if(grid[i][j] == 1) {
                        q.add(new Pair(i, j)); 
                        vis[i][j] = true; 
                    }
                }
            }
        }
        
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, +0, -1}; 
        
        while(!q.isEmpty()) {
            int row = q.peek().i; 
            int col = q.peek().j; 
            q.remove(); 
            
            // traverses all 4 directions
            for(int i = 0;i<4;i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i]; 
                // check for valid coordinates and for land cell
                if(nrow >=0 && nrow <n && ncol >=0 && ncol < m 
                && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                }
            }
            
        }
        int cnt = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                // check for unvisited land cell
                if(grid[i][j] == 1 & !vis[i][j]) 
                    cnt++; 
            }
        }
        return cnt; 
    }
}