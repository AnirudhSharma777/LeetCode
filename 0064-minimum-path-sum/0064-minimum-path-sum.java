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
        for(int[] it : dp){
            Arrays.fill(it,-1);
        }
        return helper(n-1,m-1,grid,dp);
    }
    

}