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
    
    
    // using tabulation 
    // tc:O(n) & sc:O(n)
//     public int rob(int[] nums){
//         int n = nums.length;
//         int[] dp = new int[n];
        
//         dp[0] = nums[0];
//         
        
//         for(int i = 1; i<n; i++){
            
//             int skip = 0 + dp[i-1];
//             int take = nums[i];
//             if(i > 1){
//                 take += dp[i-2];
//             }                
            
//             dp[i] = Math.max(skip,take);
//         }
        
//         return dp[n-1];
        
//     }
    
    
    // space optimization
    // Tc: O(n) & sc:O(1)
    
    public int rob(int[] nums){
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 0;
        int cur = 0;
        for(int i = 1; i<n; i++){
        
            int take = nums[i];
            if(i > 1){
                take += prev2;
            }
            int skip = 0 + prev1;
            cur = Math.max(skip,take);
            prev2 = prev1;
            prev1 = cur;
            
        }
        
        return prev1;
    }
}