class Solution {
    // using recursion + memoization
    // Tc: O(n^2) & sc:O(n)
//     public boolean canJump(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n+1];
//         Arrays.fill(dp,-1);
//         return jumpFrom(0,nums,dp);
//     }
    
//    public static boolean jumpFrom(int index , int[] nums,int[] dp){
//         if(index>=nums.length-1)
//           return true;

//         if(dp[index]!=-1)
//          return dp[index]==0?false:true;
        
//         for(int i=1;i<=nums[index];i++){
//             if(jumpFrom(index + i , nums,dp)==true)
//             { dp[index]=1;
//               return true;
//             }
//         }

//         dp[index]=0;
//         return false;
//     }
    
    
    public boolean canJump(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[n-1] = 1;
        for(int i = n-2; i>=0; i--){
            for(int j = 1; j<=nums[i] && i+j<n; j++){
                if(dp[i+j] == 1){
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[0] == 1 ? true : false;
    }
}