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
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        int[][] dp = new int[n+1][n+1];
        for(int[] it : dp){
            Arrays.fill(it,-1);
        }
        return recursion(0,0,triangle,n,dp);
    }
}