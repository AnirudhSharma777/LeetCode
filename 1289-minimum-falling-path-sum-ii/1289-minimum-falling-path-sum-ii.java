class Solution {
    
    // recursion + memoization
    
//     public int minFallingPathSum(int[][] grid) {
//         int n = grid.length;
//         int[][] dp = new int[n+1][n+1];
//         for(int[] it : dp){
//             Arrays.fill(it,-1);
//         }
//         int min = Integer.MAX_VALUE;
//         for(int i = 0; i<n; i++){
//             min = Math.min(min,recursion(0,i,n,grid,dp));
//         }
//         return min;
//     }
    
//     public int recursion(int i,int j,int n,int[][] grid,int[][] dp){
        
//         if(i >= n || j >= n){
//             return 0;
//         }
//         if(i == n-1){
//             return grid[i][j];
//         }
        
//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }
//         int min = Integer.MAX_VALUE;
//         for(int k = 0; k<n; k++){
//             if(k != j){
//                 min = (int)Math.min(min ,grid[i][j]+ recursion(i+1,k,n,grid,dp));
//             }
//         }
        
//         return dp[i][j] = min;
//     }
    
    
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] it : dp){
            Arrays.fill(it,0);
        }
       
        for(int j = 0; j<n; j++){
           dp[0][j] = grid[0][j];
        }
        
        for(int i = 1; i<n; i++){
            for(int j = 0; j<n; j++){
                
                 int min = Integer.MAX_VALUE;
                for(int k = 0; k<n; k++){
                    if(k != j){
                        min = Math.min(min,dp[i-1][k]);
                    }
                }
                dp[i][j] = grid[i][j] + min;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            ans = Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }
}