class Solution {
    int findWays(int n) {
        // code here
        if(n%2 == 1){
            return 0;
        }
        
        return nthCatalan(n/2);
    }
    
     int nthCatalan(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (n >= 1) dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}