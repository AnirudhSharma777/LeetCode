class Solution {
    // recursion
    // Tc:O(2^n*m)
    
    // recursion + memoization
    // tc: O(n*m)
    private int helper(int i,int j,int[][] grid,int[][] dp){
        
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(i < 0 || j < 0 ){
            return 999999;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int up = grid[i][j] + helper(i-1,j,grid,dp);
        int left = grid[i][j] + helper(i,j-1,grid,dp);
        
        dp[i][j] = Math.min(up,left);
        return dp[i][j];
    }
    
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
       
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }
                else{
                    int u = grid[i][j];
                    if(i > 0){
                        u += dp[i-1][j];
                    }else u += 999999;
                    int l = grid[i][j];
                    if(j > 0){
                        l += dp[i][j-1];
                    }else l += 999999;
                    
                    dp[i][j] = Math.min(u,l);
                }
            }
        }
        return dp[n-1][m-1];
    }
    

}