class Solution {
    public int rob(int[] nums) {
        
        
        if(nums.length == 1){
            return nums[0];
        }
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        
        int n = nums.length;
        for(int i = 0; i<n; i++){
            if(i != 0){
                temp1.add(nums[i]);
            }
            if(i != n-1){
                temp2.add(nums[i]);
            }
        }
        
        return Math.max(houseRob(temp1),houseRob(temp2));
    }
    
    private int houseRob(List<Integer> nums){
        int n = nums.size();
        
        int[] dp = new int[n+1];
        
        dp[0] = nums.get(0);
        
        for(int i = 1; i<n; i++){
            int take = nums.get(i);
            if(i > 1){
                take += dp[i-2];
            }
            int not = 0 + dp[i-1];
            
            dp[i] = Math.max(take,not);
        }
        return dp[n-1];
    }
}