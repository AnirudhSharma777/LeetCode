class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[101][101];
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
		return helper(0,0,m,n,dp);
    }
    
    private int helper(int i,int j,int m,int n,int[][] dp){
		if((i==n-1) && (j==m-1)){
			return 1;
		}
		if(i>n || j>m){
			return 0;
		}
		if(dp[i][j] != -1){
			return dp[i][j];
		}
		int c1 = helper(i+1,j,m,n,dp);
		int c2 = helper(i,j+1,m,n,dp);
		dp[i][j] = c1+c2;
		return dp[i][j];
	}
}