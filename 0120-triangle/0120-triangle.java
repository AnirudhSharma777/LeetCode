class Solution {
    
    // recursion+memo
    private int recursion(int i,int j,List<List<Integer>> triangle,int n,int[][] dp){
        
        if(i == n-1){
            return triangle.get(n-1).get(j);
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int d = triangle.get(i).get(j) + recursion(i+1,j,triangle,n,dp);
        int dg = triangle.get(i).get(j) + recursion(i+1,j+1,triangle,n,dp);
        
        dp[i][j] = Math.min(d,dg);
        
        return dp[i][j];
    }
    
    
    // tabulation
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        int[][] dp = new int[n+1][n+1];
        for(int[] it : dp){
            Arrays.fill(it,0);
        }
        
        for(int i = 0; i<n; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        
        for(int i = n-2; i>=0; i--){
            for(int j = i; j>=0; j--){
                 int d = triangle.get(i).get(j) + dp[i+1][j];
                 int dg = triangle.get(i).get(j) + dp[i+1][j+1];
                 
                dp[i][j] = Math.min(d,dg);
            }
        }
        
        return dp[0][0];
    }
}