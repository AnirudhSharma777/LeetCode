class Solution {
    
    // recursion + memoization
    // tc:O(n*m) && sc:O(n*m)
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int n = obstacleGrid.length;
//         int m = obstacleGrid[0].length;
//         int[][] dp = new int[n+1][m+1];
//         for(int[] it : dp){
//             Arrays.fill(it,-1);
//         }
//         return helper(n-1,m-1,obstacleGrid,dp);
//     }
    
//     private int helper(int i,int j,int[][] grid,int[][] dp){
        
//         if(i >=0 && j >=0 && grid[i][j] == 1){
//             return 0;
//         }
        
//         if(i == 0 && j == 0){
//             return 1;
//         }
        
//         if(i < 0 || j <0){
//             return 0;
//         }
        
//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }
        
//         int path = 0;
//         if(i >= 0){
//             path = path  + helper(i-1,j,grid,dp);
//         }
        
//         if(j >= 0){
//             path = path + helper(i,j-1,grid,dp);
//         }
        
//         dp[i][j] = path;
        
//         return dp[i][j];
//     }
    
    // using tabulation
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int[] it : dp){
            Arrays.fill(it,-1);
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }
                else{
                    int u = 0;
                    int l = 0;
                    if(i > 0){
                        u = dp[i-1][j];
                    }
                    if(j > 0){
                        l = dp[i][j-1];
                    }
                    dp[i][j] = u+l;
                }
            }
        }
        return dp[n-1][m-1];
    }
}