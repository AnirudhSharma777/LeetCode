class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    
    private int helper(int n,int[] dp){
        if(n <= 1){  // base case
            return n;
        }
        
        if(n == 2){ // base case;
            return 1;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        dp[n] =  helper(n-1,dp)+helper(n-2,dp)+helper(n-3,dp);
        return dp[n];
    }
}