class Solution {
public:
    int tribonacci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        
        vector<int> dp(n+1,-1);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        return dp[n-1];
    }
};