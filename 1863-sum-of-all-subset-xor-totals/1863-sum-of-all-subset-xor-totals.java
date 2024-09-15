class Solution {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
        return helper(nums,nums.length,0,0);
    }
    
    private int helper(int[] nums,int n,int index,int xor){
        if(index == n){
            return xor;
        }
        return helper(nums,n,index+1,xor^nums[index]) + helper(nums,n,index+1,xor);
    }
}