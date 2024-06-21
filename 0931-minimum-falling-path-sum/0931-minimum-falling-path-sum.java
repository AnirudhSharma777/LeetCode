class Solution {
    // forword direction 
    // this give me tle
//     private int recursion(int i,int j,int n,int m,int[][] matrix,int[][] dp){
        
//         if(i < 0 || j < 0 || j>= m || i>=n){
//             return 999999999;
//         }
//         if(i == n-1){
//             return matrix[n-1][j];
//         }
        
//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }
        
//         int d = matrix[i][j] + recursion(i+1,j,n,m,matrix,dp);
//         int dg = matrix[i][j] + recursion(i+1,j+1,n,m,matrix,dp);
//         int dgg = matrix[i][j] + recursion(i+1,j-1,n,m,matrix,dp);
        
//         dp[i][j] = Math.min(d,Math.min(dg,dgg));
        
//         return dp[i][j];
//     }

    
    // this is backword direction
    
//     private int recursion(int i,int j,int n,int m,int[][] matrix,int[][] dp){
        
//         if(j < 0 || j >= m){
//             return 999999999;
//         }
        
//         if(i == 0){
//             return matrix[0][j];
//         }
        
//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }
        
        
//        int d = matrix[i][j] + recursion(i-1,j,n,m,matrix,dp);
//        int dg = matrix[i][j] + recursion(i-1,j-1,n,m,matrix,dp);
//        int dgg = matrix[i][j] + recursion(i-1,j+1,n,m,matrix,dp);
        
//         dp[i][j] = Math.min(d,Math.min(dg,dgg));
        
//         return dp[i][j];
        
//     }
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n+1][m+1];
        for(int[] it : dp){
            Arrays.fill(it,0);
        }
        
        for(int j = 0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }
        
        for(int i = 1; i<n; i++){
            for(int j = 0; j<m; j++){
                int d = matrix[i][j] + dp[i-1][j];
                int dg = matrix[i][j];
                if(j-1 >= 0){
                    dg +=  dp[i-1][j-1];
                }else dg += 99999999;
                int dgg = matrix[i][j];
                if(j+1 < m){
                    dgg += dp[i-1][j+1];
                }
                else{
                    dgg += 99999999;
                }
                dp[i][j] = Math.min(d,Math.min(dg,dgg));
            }
        }
        
        for(int j=0; j<m; j++){
            min = Math.min(dp[n-1][j],min);
        }
        return min;
    }
}