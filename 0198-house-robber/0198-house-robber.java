class Solution {
    
    // using recursion
    // tc :O(2^n) & sc :O(n)
    
    // using recursion + memoization
    // tc :O(n) & sc : O(n)
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp,-1);
//         return helper(nums,n-1,dp);
//     }
    
//     private int helper(int[] nums,int idx,int[] dp){
//         if(idx == 0){
//             return nums[idx];
//         }
//         if(idx < 0){
//             return 0;
//         }
        
//         if(dp[idx] != -1){
//             return dp[idx];
//         }
//         int skip = helper(nums,idx-1,dp);
//         int take = nums[idx] + helper(nums,idx-2,dp);
        
//         dp[idx] = Math.max(skip,take);
//         return dp[idx];
//     }
    
    public int rob(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        int neg = 0;
        
        for(int i = 1; i<n; i++){
            
            int skip = 0 + dp[i-1];
            int take = nums[i];
            if(i > 1){
                take += dp[i-2];
            }                
            
            dp[i] = Math.max(skip,take);
        }
        
        return dp[n-1];
        
    }
}